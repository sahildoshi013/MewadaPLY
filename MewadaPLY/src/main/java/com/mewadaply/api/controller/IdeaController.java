package com.mewadaply.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mewadaply.api.model.Result;
import com.mewadaply.api.model.TblMpFurnitureDesign;
import com.mewadaply.api.model.TblMpFurnitureType;
import com.mewadaply.api.service.IdeasServiceImpl;
import com.mewadaply.api.utils.FileUtils;

@RestController
@RequestMapping("categories")
public class IdeaController {
	
	@Autowired
	IdeasServiceImpl ideaService;
	
	@GetMapping
	List<TblMpFurnitureType> getAllIdeaType(){
		List<TblMpFurnitureType> categories = ideaService.getCategories();
		System.out.println(categories.size());
		return categories;
	}
	
	@GetMapping("/{type}")
	TblMpFurnitureType getIdeaType(@PathVariable int type){
		return ideaService.getCategoryById(type);
	}
	
	@PostMapping(consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	},
		produces = {
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
	})
	public TblMpFurnitureType createIdeaType(@Valid @RequestBody TblMpFurnitureType category) {
		return ideaService.addCategory(category);
	}
	
	@DeleteMapping(path = "/{type}" ,consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	},
		produces = {
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE
	})
	public Result deleteIdeaType(@PathVariable int type) {
		return Result.getResult(ideaService.deleteCategory(type), "");
	}
	
	@GetMapping("/{type}/designs")
	List<TblMpFurnitureDesign> getIdeaByType(@PathVariable(value="type") int type){
		return ideaService.getDesigns(type);
	}
	
	@PostMapping("/{type}/designs")
	TblMpFurnitureDesign addIdea(@PathVariable(value="type") int type,@RequestParam("image") MultipartFile image){
		return ideaService.addDesign(type,image);
	}
	
	
}
