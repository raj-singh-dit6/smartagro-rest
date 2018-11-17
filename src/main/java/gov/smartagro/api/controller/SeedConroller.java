package gov.smartagro.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gov.smartagro.api.model.Crop;
import gov.smartagro.api.model.Seed;
import gov.smartagro.api.response.Response;
import gov.smartagro.api.service.SeedService;

@RestController
public class SeedConroller {

	@Autowired
	private SeedService seedService;

	@GetMapping("/seeds")
	public Response<Seed> getSeeds() {
		Response<Seed> resp = new Response<>();
		List<Seed> result = null;
		try {
			result = seedService.getSeeds();

		} catch (Exception e) {
			resp.setSuccess(true);
			return resp;
		}
		resp.setData((ArrayList<Seed>) result);
		resp.setSuccess(true);
		return resp;
	}
	
	@GetMapping("/seeds/{cropId}")
	public Response<Seed> getSeedsByCropId(@PathVariable("cropId") Long cropId) {
		Response<Seed> resp = new Response<>();
		List<Seed> result = null;
		try {
			result = seedService.getSeedsByCropId(cropId);

		} catch (Exception e) {
			resp.setSuccess(true);
			return resp;
		}
		resp.setData((ArrayList<Seed>) result);
		resp.setSuccess(true);
		return resp;
	}

}
