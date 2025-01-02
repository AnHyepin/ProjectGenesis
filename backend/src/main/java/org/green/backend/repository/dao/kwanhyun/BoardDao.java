package org.green.backend.repository.dao.kwanhyun;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.kwanhyun.BoardDto;
import org.green.backend.entity.Board;

import java.util.List;

@Mapper
public interface BoardDao {

    public void regBoard(@Param("board") BoardDto boardDto);
    public Board getBoard(int board_no);
    public List<Board> getMyBoardList(String regist_id);
    public List<Board> getNoticeList();
    public void updateBoard(@Param("board") BoardDto boardDto);
    public void deleteBoard(int board_no);

}
