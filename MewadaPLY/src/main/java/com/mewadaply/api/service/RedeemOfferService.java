package com.mewadaply.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mewadaply.api.dao.RedeemOfferDao;
import com.mewadaply.api.model.RedeemOffersModel;
import com.mewadaply.api.utils.Utils;

@Service
public class RedeemOfferService {
	
	@Autowired
	RedeemOfferDao redeemOfferDao;
	
	public Iterable<RedeemOffersModel> getAllRedeemOffers() {
		return redeemOfferDao.findAll();
	}

	public RedeemOffersModel saveRedeemOffer(int id, String offerName, String offerDescription, int offerPoint,
			MultipartFile offerImage) {
		
		RedeemOffersModel redeemOffersModel = new RedeemOffersModel();
		if(id!=0) {
			redeemOffersModel = redeemOfferDao.findById(id).get();
		}
		if(!offerImage.isEmpty()) {
			String filename = Utils.randomName(offerImage);
			try {
				// Get the file and save it somewhere
				byte[] bytes = offerImage.getBytes();
				Path path = Paths.get(Utils.UPLOAD_OFFER_PATH + filename);
				Files.write(path, bytes);

				redeemOffersModel.setOfferImage(filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		redeemOffersModel.setOfferActive(true);
		redeemOffersModel.setOfferName(offerName);
		redeemOffersModel.setOfferDescription(offerDescription);
		redeemOffersModel.setOfferPoint(offerPoint);
		
		try {
			redeemOfferDao.save(redeemOffersModel);
		}catch(Exception e) {
			return null;
		}
		return redeemOffersModel;
	}

	public RedeemOffersModel toggleOfferVisiblity(int id) {
		RedeemOffersModel result;
		try {
			result = redeemOfferDao.findById(id).get();
			result.setOfferActive((result.isOfferActive())? false : true);
			redeemOfferDao.save(result);
		}catch(Exception e) {
			return null;
		}
		return result;
	}

	public boolean deleteOffer(int id) {
		try {
			redeemOfferDao.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public RedeemOffersModel getRedeemOfferById(int id) {
		return redeemOfferDao.findById(id).get();
	}
}
