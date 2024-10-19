package com.MovieApi.csm.DTO;

import java.util.List;


public record MoviePageResponse(List<MovieDto> movieDtos,Integer pageNumber,
		Integer pageSize,int totalElements,int totalPages,boolean isLast) {

	
	
}
