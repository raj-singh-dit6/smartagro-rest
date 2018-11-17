package gov.smartagro.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.smartagro.api.model.Crop;
import gov.smartagro.api.response.Response;
import gov.smartagro.api.service.CropService;

@RestController
public class CropConroller {

	@Autowired
	private CropService cropService;

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

}
