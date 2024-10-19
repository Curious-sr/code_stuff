package com.MovieApi.csm.DTO;

import java.util.Set;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDto {

	
private Integer movieId;
	
	
	
	@NotBlank(message = "Please provide title")
	private String title;
	
	
	@NotBlank(message = "Please provide director")
	private String director;
	
	
	@NotBlank(message = "Please provide studio")
	private String studio;
	
	
	private Set<String> movieCast;
	
	
	
	private Integer releaseYear;
	
	
	@NotBlank(message = "Please provide poster")
	private String poster;
	
	
	@NotBlank(message = "Please provide posterurl")
	private String posterUrl;
}
