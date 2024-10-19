package com.MovieApi.csm.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadFile(String path, MultipartFile file) throws IOException {
		// get file name
		String fileName = file.getOriginalFilename();
		System.out.println("file Name------> "+fileName);
		//to get file Path
		
		String filePath = path +File.separator+fileName;
		System.out.println("file Name------> "+filePath);
		//create file Object
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
			System.out.println("here.....................................");
		}
		//copy the file or upload the file to the path
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return fileName;
	}

	@Override
	public InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {
		
		String filePath = path +File.separator+fileName;
		System.out.println("file Name------> "+filePath);
		return new FileInputStream(filePath);
	}

}
