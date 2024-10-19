package com.MovieApi.csm.Entities;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	
	
	@Column(nullable = false,length=200)
	@NotBlank(message = "Please provide title")
	private String title;
	
	@Column(nullable = false)
	@NotBlank(message = "Please provide director")
	private String director;
	
	@Column(nullable = false)
	@NotBlank(message = "Please provide studio")
	private String studio;
	
	@ElementCollection
	@CollectionTable(name="movie_cast")
	private Set<String> movieCast;
	
	@Column(nullable = false)
//	@NotBlank(message = "Please provide releaseYear")
	private Integer releaseYear;
	
	@Column(nullable = false)
	@NotBlank(message = "Please provide poster")
	private String poster;
	
	
	
	
	
	
	
}
