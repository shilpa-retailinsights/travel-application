package com.retailinsights.travelapp.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Packages;
import com.retailinsights.travelapp.entiry.Schools;
import com.retailinsights.travelapp.entiry.WishLists;
import com.retailinsights.travelapp.model.WishListFormDto;
import com.retailinsights.travelapp.model.WishListResponse;
import com.retailinsights.travelapp.repo.PackagesRepository;
import com.retailinsights.travelapp.repo.WishListsRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class WishListService {

	@Autowired
	private WishListsRepository wishListsRepository;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private PackagesRepository packagesRepository;
	
	public WishLists addWishLists(WishLists wishLists) {
		return wishListsRepository.save(wishLists);
	}
	
	public String saveWishLists(WishListFormDto wishListFormDto) {
		//convert the from DTO to WishList entity
		Set<Integer> packageIdList = wishListFormDto.getPackage_id();
		//convert set<integer> to set<string>
		Set<String> packageList = packageIdList.stream().map(String::valueOf).collect(Collectors.toSet()); 
		//convert set<String> to string values
		String packageStr = String.join(", ", packageList);

		//get the school object based on schoolId in the request
		Optional<Schools> school = schoolService.findSchoolById(wishListFormDto.getSchool_id());
		StringBuffer packageBuffer = new StringBuffer();
		String identifier = new RandomString().nextString();
		WishLists wishLists = new WishLists();
		for (Iterator<Integer> pkgIterator = packageIdList.iterator(); pkgIterator.hasNext();) {
			Integer pkgId = (Integer) pkgIterator.next();
			
			wishLists.setSchool(school.get());
			wishLists.setAvailability(wishListFormDto.getAvailability());
			wishLists.setImage(wishListFormDto.getImage());
			wishLists.setIdentifier(identifier);
			if(packageIdList.size() > 1) {
				if(pkgIterator.hasNext()) {
					packageBuffer.append(pkgId+",");
				}else {
					packageBuffer.append(pkgId);
					wishLists.setPackageIds(packageBuffer.toString());
				}
			}else { 
				packageBuffer.append(pkgId);
				wishLists.setPackageIds(packageBuffer.toString());
			}
			//wishLists.setPackage_id(pkgId);
		}
		wishLists.setPackageIds(packageStr);
		wishListsRepository.save(wishLists);
		return "Wishlist Addedd";
	}
	
	public List<WishLists> findAllWishLists(){
		return wishListsRepository.findAll();
	}
	
	public WishListResponse getWishListWithPackageData(UUID wishListId){
		Optional<WishLists> wishListsData = wishListsRepository.findById(wishListId);
		String packageString = wishListsData.get().getPackageIds();
		String[] pkgIds = packageString.split(",");

		List<Packages> packageData = new ArrayList<Packages>();
		for (int i = 0; i < pkgIds.length; i++) {
			Optional<Packages> pkg = packagesRepository.findById(Integer.valueOf(pkgIds[i]));
			packageData.add(pkg.get());
		}
		WishLists wishLists = wishListsData.get();
		WishListResponse wishListResponse = new WishListResponse(wishLists.getId(), wishLists.getImage(), wishLists.isAvailability(), wishLists.getPackageIds(), packageData,wishLists.getItinerary(), wishLists.getSchool());
		return wishListResponse;
	}
	
	public Optional<WishLists> findWishListById(UUID wishListId){
		Optional<WishLists> wishListsData = wishListsRepository.findById(wishListId);
		return wishListsData;
	}
	
	public void deleteWishList (UUID wishListId) {
		wishListsRepository.deleteById(wishListId);
	}
	
	public WishLists updateWishList(WishLists wishLists) {
		return wishListsRepository.save(wishLists);
	}
}
