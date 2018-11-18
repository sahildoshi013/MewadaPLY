package com.mewadaply.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mewadaply.api.dao.IdeaDesignDao;
import com.mewadaply.api.dao.IdeaTypeDao;
import com.mewadaply.api.model.IdeaDesignModel;
import com.mewadaply.api.model.IdeaTypeModel;
import com.mewadaply.api.utils.FileUtils;

@Service
public class IdeasService {

	@Autowired
	IdeaTypeDao furnitureTypeDao;

	@Autowired
	IdeaDesignDao furnitureDesignDao;

	public List<IdeaTypeModel> getCategories() {
		return furnitureTypeDao.findAll();
	}

	public IdeaTypeModel getCategoryById(Integer id) {
		if (id == null)
			id = 1;
		return furnitureTypeDao.findById(id).get();
	}

	public List<IdeaDesignModel> getDesigns(Integer id) {
		if (id == 0) {
			return furnitureDesignDao.findAll();
		}

		return furnitureDesignDao.findBytblMpFurnitureType(getCategoryById(id));
	}

	public IdeaTypeModel addCategory(IdeaTypeModel category) {
		IdeaTypeModel result = furnitureTypeDao.save(category);
		return result;
	}

	public boolean deleteCategory(Integer id) {
		try {
			furnitureTypeDao.deleteById(id);
			return true;
		} catch (IllegalArgumentException i) {
			return false;
		}
	}

	public IdeaDesignModel addDesign(int type, MultipartFile image) {
		String filename = FileUtils.randomName(image);
		try {
			// Get the file and save it somewhere
			byte[] bytes = image.getBytes();
			Path path = Paths.get(FileUtils.UPLOAD_DESIGN_PATH + filename);
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		IdeaDesignModel design = new IdeaDesignModel();
		design.setTblMpFurnitureType(getCategoryById(type));
		design.setDesignImage(filename);
		design.setDesignVisiblity(true);
		design.setDesignTime(new Date());

		return furnitureDesignDao.save(design);
	}

	public boolean deleteDesign(Integer type) {
		System.out.println(type);
		try {
			furnitureDesignDao.deleteIdeaByID(type);
			// furnitureDesignDao.deleteById(type);
			return true;
		} catch (IllegalArgumentException i) {
			return false;
		}
	}

}
