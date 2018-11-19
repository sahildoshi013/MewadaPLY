package com.mewadaply.api.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.model.Result;
import com.mewadaply.api.model.IdeaDesignModel;
import com.mewadaply.api.model.IdeaTypeModel;
import com.mewadaply.api.service.IdeasService;
import com.mewadaply.api.utils.Utils;

@Controller
@RequestMapping("/admin/ideas")
public class IdeaController {

	@Autowired
	IdeasService ideaService;

	@GetMapping
	List<IdeaTypeModel> getAllIdeaType(){
		List<IdeaTypeModel> categories = ideaService.getCategories();
		System.out.println(categories.size());
		return categories;
	}

	@DeleteMapping(path = "/category/{type}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@CrossOrigin(origins = "*")
	public Result deleteIdeaType(@PathVariable int type) {
		return Result.getResult(ideaService.deleteCategory(type), "");
	}

	@GetMapping("/{type}/designs")
	public List<IdeaDesignModel> getIdeaByType(@PathVariable(value = "type") int type) {
		return ideaService.getDesigns(type);
	}

	@GetMapping("/{type}")
	public String showIdeaPage(ModelMap model, @PathVariable Integer type,HttpSession session) {
		Boolean res = (Boolean)session.getAttribute(Utils.SESSION_LOGIN);
		if(res==null || !res) {
				return "redirect:/login";
		}
		model.put("page", 4);
		model.put("types", ideaService.getCategories());
		model.put("type", ideaService.getCategoryById(type));
		if (type == null) {
			type = 0;
		}
		model.put("ideas", ideaService.getDesigns(type));
		return "ideas";
	}
}
