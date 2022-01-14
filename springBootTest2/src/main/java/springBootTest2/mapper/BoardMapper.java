package springBootTest2.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.BoardDTO;

@Component
@Repository(value = "springBootTest2.mapper.BoardMapper")
public interface BoardMapper {
	public Integer boardInsert(BoardDTO dto);
}
