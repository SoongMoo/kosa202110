package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.EmpLibraryDTO;
import springBootTest2.domain.LibraryDTO;

@Component
@Repository(value="springBootTest2.mapper.EmpLibraryMapper")
public interface EmpLibraryMapper {
	public Integer libInsert(EmpLibraryDTO dto);
	public List<EmpLibraryDTO> selectAll();
	public EmpLibraryDTO selectOne(String libNum);
	public Integer libraryUpdate(EmpLibraryDTO dto);
	public Integer libDelete(String libNum);
}
