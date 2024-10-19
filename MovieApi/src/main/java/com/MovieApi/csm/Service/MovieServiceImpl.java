package com.MovieApi.csm.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MovieApi.csm.DTO.MovieDto;
import com.MovieApi.csm.DTO.MoviePageResponse;
import com.MovieApi.csm.Entities.Movie;
import com.MovieApi.csm.Exceptions.FileExistsException;
import com.MovieApi.csm.Exceptions.MovieNotFoundException;
import com.MovieApi.csm.Repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;
	private final FileService fileService;
	
	@Value("${project.poster}")
	private String path;

	@Value("${base.url}")
	private String baseurl;

	public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
		
		this.movieRepository = movieRepository;
		this.fileService = fileService;
	}

	

	@Override
	public MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException {
		//upload file
		
		if(Files.exists(Paths.get(path+File.separator+file.getOriginalFilename()))) {
			throw new FileExistsException("File already exists.Please provide another file");
			
		}
		String uploadedFileName = fileService.uploadFile(path, file);
		
		//set the value of field poster as filename
		movieDto.setPoster(uploadedFileName);
		
		//map dto to movie object
		Movie movie=new Movie(
				null,
				movieDto.getTitle(),
				movieDto.getDirector(),
				movieDto.getStudio(),
				movieDto.getMovieCast(),
				movieDto.getReleaseYear(),
				movieDto.getPoster()

				);
		//save movie object
		Movie saveMovie = movieRepository.save(movie);
		
		//generate the poster url
		
		String posterUrl = baseurl+"/file/"+uploadedFileName;
		
		//map movie object to dto object and return it
		
		MovieDto response =new MovieDto(
				saveMovie.getMovieId(),
				saveMovie.getTitle(),
				saveMovie.getDirector(),
				saveMovie.getStudio(),
				saveMovie.getMovieCast(),
				saveMovie.getReleaseYear(),
				saveMovie.getPoster(),
				posterUrl

				);
		
		return response;
	}

	@Override
	public MovieDto getMovie(Integer movieId) {
		// check the data in DB if exist fetch the data of given ID
		Movie movie = movieRepository.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie Not Found") );
		
		//Generate Poster url
		String posterUrl = baseurl +"/file/"+movie.getPoster();
		
		//map to movieDto object and return it
		MovieDto response =new MovieDto(
				movie.getMovieId(),
				movie.getTitle(),
				movie.getDirector(),
				movie.getStudio(),
				movie.getMovieCast(),
				movie.getReleaseYear(),
				movie.getPoster(),
				posterUrl
				);
		
		return response;
	}

	@Override
	public List<MovieDto> getAllMovie() {
		//fetch all data from db
		List<Movie> movies =  movieRepository.findAll();
		
		List<MovieDto> movieDtos =  new ArrayList<>();
		
		//iterate through the list generate posterurl for each movie object
		for(Movie movie:movies) {
			String posterUrl = baseurl +"/file/"+movie.getPoster();
			MovieDto movieDto =new MovieDto(
					movie.getMovieId(),
					movie.getTitle(),
					movie.getDirector(),
					movie.getStudio(),
					movie.getMovieCast(),
					movie.getReleaseYear(),
					movie.getPoster(),
					posterUrl
					);
			movieDtos.add(movieDto);
		}
		return movieDtos;
	}



	@Override
	public MovieDto updateMovie(Integer movieId, MovieDto movieDto, MultipartFile file) throws IOException {
		// check if movie exist with given id
		Movie movie = movieRepository.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie Not Found") );
		
		String fileName = movie.getPoster();
		
		if(file != null) {
			Files.deleteIfExists(Paths.get(path+File.separator+fileName));
			fileName = fileService.uploadFile(path,file);
		}
		movieDto.setPoster(fileName);
		
		Movie movieo =new Movie(
				movie.getMovieId(),
				movieDto.getTitle(),
				movieDto.getDirector(),
				movieDto.getStudio(),
				movieDto.getMovieCast(),
				movieDto.getReleaseYear(),
				movieDto.getPoster()
				
				);
		Movie updatedMovie =movieRepository.save(movieo);
		String posterUrl = baseurl +"/file/"+fileName;
		
		MovieDto response =new MovieDto(
				movie.getMovieId(),
				movie.getTitle(),
				movie.getDirector(),
				movie.getStudio(),
				movie.getMovieCast(),
				movie.getReleaseYear(),
				movie.getPoster(),
				posterUrl
				);
		
		return response;
	}



	@Override
	public String deleteMovie(Integer movieId) throws IOException {
		// check existance
		Movie movie = movieRepository.findById(movieId).orElseThrow(()->new MovieNotFoundException("Movie Not Found") );
		Files.deleteIfExists(Paths.get(path+File.separator+movie.getPoster()));
		Integer id =movie.getMovieId();
		
		movieRepository.delete(movie);
		
		return "Movie Deleted With Id = "+id;
	}



	@Override
	public MoviePageResponse getAllMoviesWithPagination(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		Page<Movie> moviePages = movieRepository.findAll(page);
		List<Movie> movies = moviePages.getContent();
		
		List<MovieDto> movieDtos =  new ArrayList<>();
		
		//iterate through the list generate posterurl for each movie object
		for(Movie movie:movies) {
			String posterUrl = baseurl +"/file/"+movie.getPoster();
			MovieDto movieDto =new MovieDto(
					movie.getMovieId(),
					movie.getTitle(),
					movie.getDirector(),
					movie.getStudio(),
					movie.getMovieCast(),
					movie.getReleaseYear(),
					movie.getPoster(),
					posterUrl
					);
		
		
		
		return new MoviePageResponse(movieDto,pageNumber,pageSize,moviePages.getTotalElements(),moviePages.getTotalPages(),
				moviePages.isLast());
	}



	@Override
	public MoviePageResponse getAllMoviesWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String sortBy,
			String dir) {
		// TODO Auto-generated method stub
		return null;
	}

}
