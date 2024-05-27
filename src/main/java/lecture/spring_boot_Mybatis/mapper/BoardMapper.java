package lecture.spring_boot_Mybatis.mapper;

import lecture.spring_boot_Mybatis.domain.Board;
import lecture.spring_boot_Mybatis.dto.BoardCreateDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoardsALL();

    void insertBoard(BoardCreateDTO board);

    void updateBoard(BoardCreateDTO board);
}
