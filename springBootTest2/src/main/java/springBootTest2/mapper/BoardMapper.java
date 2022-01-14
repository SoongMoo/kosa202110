package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.BoardDTO;

@Component
@Repository(value = "springBootTest2.mapper.BoardMapper")
public interface BoardMapper {
	public Integer boardUpdate(BoardDTO dto);
	public Integer boardDel(Integer boardNum);
	public BoardDTO selectOne(Integer boardNum);
	public Integer boardInsert(BoardDTO dto);
	public List<BoardDTO> selectAll();
	public Integer visitCount(Integer boardNum);
}
