package com.mewadaply.api.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mewadaply.api.model.Result;
import com.mewadaply.api.service.IdeasService;

@RestController
@RequestMapping("/admin")
public class AjaxController {

	@Autowired
	IdeasService ideasServiceImpl;

	@DeleteMapping("/ideas/{type}")
	@CrossOrigin(origins = "*")
	public Result deleteIdea(@PathVariable(value = "type") int type) {
		System.out.println(type);

		return Result.getResult(ideasServiceImpl.deleteDesign(type), "");
	}

	@PostMapping("/ideas")
	public ResponseEntity<String> uploadFile(MultipartHttpServletRequest request, @RequestParam("type_id") int type) {

		try {
			Iterator<String> itr = request.getFileNames();
			while (itr.hasNext()) {
				String uploadedFile = itr.next();
				MultipartFile file = request.getFile(uploadedFile);
				ideasServiceImpl.addDesign(type, file);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("{status : false , error : "+e.getMessage()+"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("{\"status\" : true}", HttpStatus.OK);
	}
}
