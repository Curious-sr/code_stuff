package com.MovieApi.csm.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MovieApi.csm.DTO.MovieDto;
import com.MovieApi.csm.Exceptions.EmptyFileException;
import com.MovieApi.csm.Service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		
		this.movieService = movieService;
	}
	
	
	@PostMapping("add-movie")
	public ResponseEntity<MovieDto>addMovieHandler(@RequestPart MultipartFile file,@RequestPart String movieDto) throws IOException, EmptyFileException{
		if(file.isEmpty()) {
			throw new EmptyFileException("File is empty! Please send Another file");
		}
		MovieDto dto = convertToMovieDto(movieDto);
		return new ResponseEntity<>(movieService.addMovie(dto, file),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{movieId}")
	public ResponseEntity<MovieDto> getMovieHandler(@PathVariable Integer movieId){
		return ResponseEntity.ok(movieService.getMovie(movieId));
		
	}
	
	@GetMapping("/allMovie")
	public ResponseEntity<List<MovieDto>> getAllMovieHandler(){
		return ResponseEntity.ok(movieService.getAllMovie());
		
	}
	
	@PutMapping("/update/{movieId}")
	public ResponseEntity<MovieDto> updateMovieHandler(@PathVariable Integer movieId,@RequestPart MultipartFile file,@RequestPart String movieDtoObj) throws IOException{
		if(file.isEmpty()) file = null;
		MovieDto movieDto = convertToMovieDto(movieDtoObj);
		return ResponseEntity.ok(movieService.updateMovie(movieId,movieDto,file));
	}
	
	@DeleteMapping("/delete/{movieId}")
	public ResponseEntity<String> deleteMovieHandler(@PathVariable Integer movieId,@RequestPart MultipartFile file,@RequestPart String movieDtoObj) throws IOException{
		
		return ResponseEntity.ok(movieService.deleteMovie(movieId));
	}
	
	
	private MovieDto convertToMovieDto(String movieDto) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(movieDto,	MovieDto.class);
	}
	
	
	
	
	
	
	
	
	
}
