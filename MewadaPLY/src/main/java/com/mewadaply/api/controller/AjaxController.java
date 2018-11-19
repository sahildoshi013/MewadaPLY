package com.mewadaply.api.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mewadaply.api.model.RedeemOffersModel;
import com.mewadaply.api.model.RedeemRequestModel;
import com.mewadaply.api.model.Result;
import com.mewadaply.api.service.IdeasService;
import com.mewadaply.api.service.RedeemOfferService;
import com.mewadaply.api.service.RedeemRequestService;


@RestController
@RequestMapping("/admin")
public class AjaxController {

	@Autowired
	IdeasService ideasService;
	
	@Autowired
	RedeemOfferService redeemOfferService;
	
	@Autowired
	RedeemRequestService redeemRequestService;

	@DeleteMapping("/ideas/{type}")
	@CrossOrigin(origins = "*")
	public Result deleteIdea(@PathVariable(value = "type") int type) {
		System.out.println(type);

		return Result.getResult(ideasService.deleteDesign(type), "");
	}

	@PostMapping("/ideas")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> uploadFile(MultipartHttpServletRequest request, @RequestParam("type_id") int type) {

		try {
			Iterator<String> itr = request.getFileNames();
			while (itr.hasNext()) {
				String uploadedFile = itr.next();
				MultipartFile file = request.getFile(uploadedFile);
				ideasService.addDesign(type, file);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("{status : false , error : "+e.getMessage()+"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("{\"status\" : true}", HttpStatus.OK);
	}
	
	@PostMapping("/offers")
	@CrossOrigin(origins = "*")
	public Result addOffer(@RequestParam("offer_name") String offerName,
							@RequestParam("offer_description") String offerDescription,
							@RequestParam("offer_point") int offerPoint,
							@RequestParam("offer_image") MultipartFile offerImage) {
		boolean isAdded = false;
		RedeemOffersModel result;
		result = redeemOfferService.saveRedeemOffer(0,offerName,offerDescription,offerPoint,offerImage);
		isAdded = (result!=null) ? true : false;
		return Result.getResult(isAdded, result);
	}
	
	@GetMapping("/offers/{id}")
	@CrossOrigin(origins = "*")
	public Result getOfferById(@PathVariable int id) {
		RedeemOffersModel result = redeemOfferService.getRedeemOfferById(id);
 		return Result.getResult(result!=null, result);
	}
	
	@PutMapping("/offers")
	@CrossOrigin(origins = "*")
	public Result updateOffer(@RequestParam("offer_id") int id,
								@RequestParam("offer_name") String offerName,
								@RequestParam("offer_description") String offerDescription,
								@RequestParam("offer_point") int offerPoint,
								@RequestParam("offer_image") MultipartFile offerImage
								) {
		boolean isAdded = false;
		RedeemOffersModel result;
		result = redeemOfferService.saveRedeemOffer(id,offerName,offerDescription,offerPoint,offerImage);
		isAdded = (result!=null) ? true : false;
		return Result.getResult(isAdded, result);
	}
	
	@PutMapping("/offers/{id}/toggle_offer")
	@CrossOrigin(origins = "*")
	public Result toggleOffer(@PathVariable int id) {
		RedeemOffersModel result = redeemOfferService.toggleOfferVisiblity(id);
		return Result.getResult(result!=null, result);
	}
	
	@DeleteMapping("/offers/{id}")
	@CrossOrigin(origins = "*")
	public Result deleteOffer(@PathVariable int id) {
		return Result.getResult(redeemOfferService.deleteOffer(id), "Not Available");
	}
	
	@PutMapping(value="redeem/{id}/{status}")
	public Result putMethodName(@PathVariable Integer id, @PathVariable Integer status) {
		//TODO: process PUT request
		RedeemRequestModel result = redeemRequestService.changeStatus(id,status);
		
		return Result.getResult(result!=null, result);
	}
}
