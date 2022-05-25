package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.MovieVO;

@Mapper
public interface MovieMapper {

	void register(MovieVO movieVO);

	List<MovieVO> findAllMovieList();

	MovieVO findMovieById(int movieId);

}
