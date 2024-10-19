package com.MovieApi.csm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MovieApi.csm.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	

}
