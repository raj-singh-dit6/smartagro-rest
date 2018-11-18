package gov.smartagro.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gov.smartagro.api.model.Crop;
import gov.smartagro.api.model.Soilhealthcard;
import gov.smartagro.api.model.Soiltocrop;
import gov.smartagro.api.model.UserCropDto;
import gov.smartagro.api.model.UserCropRequestObject;
import gov.smartagro.api.repository.SoilCropRepository;
import gov.smartagro.api.repository.SoilHealthRepository;
import gov.smartagro.api.response.Response;
import gov.smartagro.api.response.SingleResponse;
import gov.smartagro.api.service.CropService;

@RestController
public class CropConroller {

	@Autowired
	private CropService cropService;
	
	@Autowired
	private SoilHealthRepository soilHealthRepository;
	
	@Autowired
	private SoilCropRepository soilCropRepository;
	
	

	@GetMapping("/crops")
	public Response<Crop> getCrops() {
		Response<Crop> resp = new Response<>();
		List<Crop> result = null;
		try {
			result = cropService.getCrops();

		} catch (Exception e) {
			resp.setSuccess(true);
			return resp;
		}
		resp.setData((ArrayList<Crop>) result);
		resp.setSuccess(true);
		return resp;
	}

	@GetMapping("/crops/{userId}")
	public SingleResponse<UserCropDto> getUserCrop(@PathVariable("userId") Long userId) {
		SingleResponse<UserCropDto> resp = new SingleResponse<>();
		UserCropDto result = null;
		try {
			result = cropService.getUserCrops(userId);

		} catch (Exception e) {
			resp.setSuccess(true);
			return resp;
		}
		resp.setData(result);
		resp.setSuccess(true);
		return resp;
	}

	@PostMapping("/usercrop")
	public SingleResponse<UserCropDto> saveUserCrop(@RequestBody UserCropRequestObject data) {
		SingleResponse<UserCropDto> resp = new SingleResponse<>();
		UserCropDto result = null;
		try {

			cropService.saveUserCrop(data);

		} catch (Exception e) {
			resp.setSuccess(true);
			return resp;
		}
		resp.setData(result);
		resp.setSuccess(true);
		return resp;
	}
	
	@GetMapping("/prediction/{id}")
	public SingleResponse<Integer> getSoilInfo(@PathVariable("id") Long id) {
		SingleResponse<Integer> resp = new SingleResponse<>();
		List<Crop> result = null;
		Integer match = 0;
		try {
			
			Soilhealthcard soil= soilHealthRepository.findByCardnumber(id).get();
			
			List<Soiltocrop> stc=soilCropRepository.findAll();
			
			Integer N=soil.getN().intValue();
			Integer P=soil.getP().intValue();
			Integer K=soil.getK().intValue();
			

			double diff=20000;
		
			
			for(int x=0;x<stc.size()-1;x++){
				
				Soiltocrop s1=stc.get(x);
				Soiltocrop s2=stc.get(x+1);
				
				Integer N1=s1.getNvalue();
				Integer P1=s1.getPvlaue();
				Integer K1=s1.getKvalue();
				
				Integer N2=s2.getNvalue();
				Integer P2=s2.getPvlaue();
				Integer K2=s2.getKvalue();
				
				double a=Math.pow((N2-N1), 2);
				double b=Math.pow((P2-P1), 2);
				double c=Math.pow((K2-K1), 2);
				
				double res=Math.sqrt(a+b+c);
				
				if(res<diff){
					match=s1.getSoiltocropid();
					diff=res;
				}
				
			}
			
			

		} catch (Exception e) {
			resp.setSuccess(false);
			return resp;
		}
		resp.setData(match);
		resp.setSuccess(true);
		return resp;
	}

}
