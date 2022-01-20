package springBootTest2.service.library;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.LibraryCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;
@Component
@Service
public class LibraryUpdateService {
	@Autowired
	LibraryMapper libraryMapper;
	public String execute(LibraryCommand libraryCommand,
			HttpSession session,Model model) {
		String path = "redirect:libInfo?num="+libraryCommand.getLibNum();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		LibraryDTO dto = libraryMapper.selectOne(libraryCommand.getLibNum());
		
		String originalTotal = null;
		String storeTotal = null;
		String fileSizeTotal = null;
		
		String [] fileNames = null;
		if( dto.getStoreFileName() != null) {
			fileNames = dto.getStoreFileName().split("`");
		}
		
		String filePath = "/view/lib";
		String fileDir = session.getServletContext().getRealPath(filePath);
		
		if(!dto.getLibPw().equals(libraryCommand.getLibPw()) || 
				!dto.getMemId().equals(authInfo.getUserId())) {
			// selectOne으로 가져온 내용을 전달하면 이전 내용이 적용이 되므로
			// 수정한 내용을 수정 페이지에 전달하기 위해 libraryCommand를 전달
			model.addAttribute("dto", libraryCommand);
			model.addAttribute("err_pw","비밀번호가 틀렸습니다.");
			path = "thymeleaf/lib/libModify";
		}else {
			dto.setLibContent(libraryCommand.getLibContent());
			dto.setLibNum(Integer.parseInt(libraryCommand.getLibNum()));
			dto.setLibSubject(libraryCommand.getLibSubject());
			dto.setLibWriter(libraryCommand.getLibWriter());
			if(dto.getOriginalFileName() != null) {
				originalTotal = dto.getOriginalFileName();
				storeTotal = dto.getStoreFileName();
				fileSizeTotal = dto.getFileSize();
			}else {
				originalTotal = "";
				storeTotal = "";
				fileSizeTotal = "";
			}
			
			if(!libraryCommand.getReport()[0].getOriginalFilename().isEmpty()) {
				
				for(MultipartFile mf : libraryCommand.getReport()) {
					String originalFile = mf.getOriginalFilename();
					String extension = originalFile.substring(
							originalFile.lastIndexOf("."));
					String storeName = UUID.randomUUID().toString()
										   .replace("-", "");
					String storeFileName = storeName + extension;
					String fileSize = Long.toString(mf.getSize());
					
					File file = new File(fileDir + "/" + storeFileName);
					try{
						mf.transferTo(file);
					}catch(Exception e) {}
					originalTotal += originalFile + "`";
					storeTotal += storeFileName + "`";
					fileSizeTotal += fileSize +"`";
				}
			}
			///
			dto.setFileSize(fileSizeTotal);
			dto.setOriginalFileName(originalTotal);
			dto.setStoreFileName(storeTotal);
			Integer i = libraryMapper.libraryUpdate(dto);
			// update가 정상적으로 실행이 되었다면 파일 삭제
			if(!libraryCommand.getReport()[0].getOriginalFilename().isEmpty()){
				if(i > 0) {
					File file = null;
					try {
						for(String fileName : fileNames) {
							file = new File(fileDir + "/" + fileName);
							if(file.exists()) file.delete();
						}
					}catch(Exception e) {}
				}
			}
		}
		return path;
	}
}
