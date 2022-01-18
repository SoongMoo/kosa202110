package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.LibraryDTO;

@Component
@Repository(value="springBootTest2.mapper.LibraryMapper")
public interface LibraryMapper {
	public Integer libInsert(LibraryDTO dto);
	public List<LibraryDTO> selectAll();
	public LibraryDTO selectOne(String libNum);
}
