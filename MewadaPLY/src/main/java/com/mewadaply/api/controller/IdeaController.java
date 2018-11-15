package com.mewadaply.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mewadaply.api.model.Result;
import com.mewadaply.api.model.IdeaDesignModel;
import com.mewadaply.api.model.IdeaTypeModel;
import com.mewadaply.api.service.IdeasServiceImpl;

@RestController
@RequestMapping("categories")
public class IdeaController {
	
	@Autowired
	IdeasServiceImpl ideaService;
	
	@GetMapping
	List<IdeaTypeModel> getAllIdeaType(){
		List<IdeaTypeModel> categories = ideaService.getCategories();
		System.out.println(categories.size());
		return categories;
	}
	
	@GetMapping("/{type}")
	IdeaTypeModel getIdeaType(@PathVariable int type){
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
	public IdeaTypeModel createIdeaType(@RequestParam("category") String typeName) {
		IdeaTypeModel category = new IdeaTypeModel(typeName);
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
	List<IdeaDesignModel> getIdeaByType(@PathVariable(value="type") int type){
		return ideaService.getDesigns(type);
	}
	
	@PostMapping("/{type}/designs")
	IdeaDesignModel addIdea(@PathVariable(value="type") int type,@RequestParam("image") MultipartFile image){
		return ideaService.addDesign(type,image);
	}
	
	@DeleteMapping("/{type}/designs/{id}")
	Result deleteIdea(@PathVariable(value="type") int type,@PathVariable("id") int id){
		return Result.getResult(ideaService.deleteDesign(type,id),"");
	}
	
}
