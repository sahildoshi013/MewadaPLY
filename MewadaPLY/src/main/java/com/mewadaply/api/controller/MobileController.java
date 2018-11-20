package com.mewadaply.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mewadaply.api.model.IdeaDesignModel;
import com.mewadaply.api.model.IdeaTypeModel;
import com.mewadaply.api.model.RedeemOffersModel;
import com.mewadaply.api.model.TransactionModel;
import com.mewadaply.api.model.UserModel;
import com.mewadaply.api.response.Result;
import com.mewadaply.api.service.IdeasService;
import com.mewadaply.api.service.RedeemOfferService;
import com.mewadaply.api.service.TransactionService;
import com.mewadaply.api.service.UserService;

@RestController
@RequestMapping("/mobile")
@CrossOrigin(origins = "*")
public class MobileController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RedeemOfferService redeemOfferService;
	
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private IdeasService ideasService;
	
	@GetMapping("/users/{number}")
	public Result getUser(@PathVariable String number) {
		
		UserModel user = userService.getUserByPhoneNumber(number);
		
		return Result.getResult(user!=null, user);
	}
	
	@GetMapping("/users/{userId}/transactions")
	public Result getUserTransaction(@PathVariable Integer userId) {
		
		List<TransactionModel> data = transactionService.getUserTransactionByUserId(userId);
		
		return Result.getResult(data!=null, data);
	}
	
	@PostMapping("/users")
	public Result updateUserData(@Nullable @RequestPart("file") MultipartFile file,
			@RequestPart("fname") String fname,
            @RequestPart("lname") String lname,
            @RequestPart("email") String email,
            @RequestPart("number") String number,
            @RequestPart("address1") String address1,
            @RequestPart("address2") String address2,
            @RequestPart("city") String city) {
		
		UserModel user = userService.updateUserData(file,fname,lname,email,number,address1,address2,city);
		return Result.getResult(true, user);
	}
	
	@GetMapping("/redeemOffers")
	public Result getRedeemOffer() {
		List<RedeemOffersModel> result = redeemOfferService.getAllActiveRedeemOffers();
		return Result.getResult(result!=null, result);
	}
	
	@GetMapping("/ideasType")
	public Result getIdeasType() {
		List<IdeaTypeModel> result = ideasService.getCategories();
		return Result.getResult(result!=null, result);
	}
	
	@GetMapping("/ideas/{id}")
	public Result getIdeas(@PathVariable int id) {
		List<IdeaDesignModel> result = ideasService.getDesigns(id);
		return Result.getResult(result!=null, result);
	}
	
	@PostMapping("/redeem")
	public Result addRedeemRequest(@RequestParam("offerId") Integer offerId,
									@RequestParam("userId") Integer userId) {
		boolean result = transactionService.addRedeemRequest(offerId,userId);
		return Result.getResult(result, userService.getUserById(userId));
	}
	
}
