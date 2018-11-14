package com.mewadaply.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mewadaply.api.dao.FurnitureDesignDao;
import com.mewadaply.api.dao.FurnitureTypeDao;
import com.mewadaply.api.model.TblMpFurnitureDesign;
import com.mewadaply.api.model.TblMpFurnitureType;
import com.mewadaply.api.utils.FileUtils;

@Service
public class IdeasServiceImpl{
	
	@Autowired
	FurnitureTypeDao furnitureTypeDao;
	
	@Autowired
	FurnitureDesignDao furnitureDesignDao;
	
	public List<TblMpFurnitureType> getCategories(){
		return furnitureTypeDao.findAll();
	}
	
	public TblMpFurnitureType getCategoryById(Integer id) {
		return furnitureTypeDao.findById(id).get();
	}
	
	public List<TblMpFurnitureDesign> getDesigns(Integer id){
		if(id==0) {
			return furnitureDesignDao.findAll();
		}
		
		return furnitureDesignDao.findBytblMpFurnitureType(getCategoryById(id));
	}

	public TblMpFurnitureType addCategory(TblMpFurnitureType category) {
		TblMpFurnitureType result = furnitureTypeDao.save(category);
		return result;
	}
	
	public boolean deleteCategory(Integer id) {
		try{
			furnitureTypeDao.deleteById(id);
			return true;
		}catch(IllegalArgumentException i) {
			return false;
		}
	}

	public TblMpFurnitureDesign addDesign(int type, MultipartFile image) {
		String filename = FileUtils.randomName(image); 
		try {
            // Get the file and save it somewhere
            byte[] bytes = image.getBytes();
            Path path = Paths.get(FileUtils.UPLOAD_DESIGN_PATH + filename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

		
		TblMpFurnitureDesign design = new TblMpFurnitureDesign();
		design.setTblMpFurnitureType(getCategoryById(type));
		design.setDesignImage(filename);
		design.setDesignVisiblity(true);
		design.setDesignTime(new Date());
		
		return furnitureDesignDao.save(design);
	}
	
}
