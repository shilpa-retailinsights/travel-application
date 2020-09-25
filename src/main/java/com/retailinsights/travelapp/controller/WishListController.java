package com.retailinsights.travelapp.controller;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailinsights.travelapp.entiry.WishLists;
import com.retailinsights.travelapp.model.WishListFormDto;
import com.retailinsights.travelapp.model.WishListResponse;
import com.retailinsights.travelapp.service.WishListService;

@RestController
public class WishListController {

	@Autowired
	private WishListService wishListService;
	
	@PostMapping("/api/v1/wishlists")
	public String addWishList(@RequestBody WishListFormDto wishlistDto) {
        wishListService.saveWishLists(wishlistDto);
		return "Added in WishList";
	}
	
	@GetMapping("/api/v1/wishlists")
	public List<WishLists> findAllWishLists(){
		List<WishLists> wishlistList =wishListService.findAllWishLists();
		return wishlistList;
	}
	
	@GetMapping("/api/v1/wishlists/{wishListId}/package/{packageAttr}")
	public WishListResponse findWiListsById (@PathVariable(name = "wishListId") UUID wishListId,
			@PathVariable(name = "packageAttr")String packageAttr) {
		WishListResponse wishListData = wishListService.getWishListWithPackageData(wishListId);
		return wishListData;
	}
	
	@DeleteMapping("/api/v1/wishlists/{wishListId}")
	public ResponseEntity<WishLists> deleteWishList(@PathVariable(name = "wishListId") UUID wishListId) {
	 wishListService.deleteWishList(wishListId);
		return new ResponseEntity<WishLists>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/v1/wishlists/{wishListId}")
	public WishLists updateWishlist(@RequestBody WishLists wishlist, @PathVariable(name = "wishListId") UUID wishListId) {
		Optional<WishLists> wishListData = wishListService.findWishListById(wishListId);
		wishListData.get().setImage(wishlist.getImage());
        WishLists updatedWishLists = wishListService.updateWishList(wishListData.get());
		return updatedWishLists;
	}
	
	@GetMapping("/api/v1/wishlists/{wishListId}")
	public WishLists findById(@PathVariable(name = "wishListId") UUID wishListId){
		Optional<WishLists> wishlistData = wishListService.findWishListById(wishListId);
		return wishlistData.get();
	}
}
