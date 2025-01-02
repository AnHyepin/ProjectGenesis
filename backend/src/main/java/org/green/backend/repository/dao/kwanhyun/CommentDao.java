package org.green.backend.repository.dao.kwanhyun;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.kwanhyun.CommentDto;
import org.green.backend.entity.Comment;

import java.util.List;

@Mapper
public interface CommentDao {

    public void regComment(@Param("comment") CommentDto comment);
    public List<Comment> getCommentList();
    public void updateComment(@Param("comment") CommentDto comment);
    public void deleteComment(int commentNo);

}
