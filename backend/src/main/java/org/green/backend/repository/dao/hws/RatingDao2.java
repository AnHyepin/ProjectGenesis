package org.green.backend.repository.dao.hws;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.green.backend.dto.hws.RatingDto2;

@Mapper
public interface RatingDao2 {
    void insertRating(@Param("rating") RatingDto2 ratingDto);
}
