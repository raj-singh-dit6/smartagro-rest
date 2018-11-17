package gov.smartagro.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.smartagro.api.model.Crop;
import gov.smartagro.api.model.Seed;
import gov.smartagro.api.model.UserCrop;
import gov.smartagro.api.model.UserCropDto;
import gov.smartagro.api.repository.CropRepository;
import gov.smartagro.api.repository.SeedRepository;
import gov.smartagro.api.repository.UserCropRepository;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;
    
    @Autowired
    private UserCropRepository usercropRepository;
    
    @Autowired
    private SeedRepository seedRepository;

    private static final Logger logger = LoggerFactory.getLogger(CropService.class);

	public List<Crop> getCrops() {
		return cropRepository.findAll();
	}
	
	public UserCropDto getUserCrops(Long id) {
	
		UserCropDto s=new UserCropDto();
		
		UserCrop u=usercropRepository.findById(id).get();
		
		Long seedId=u.getSeedid();
		
		Long cropId=u.getCropid();
		
		Crop crop=cropRepository.findById(cropId).get();
		
		Seed seed=seedRepository.findById(seedId).get();
		
		s.setCrop(crop);

		s.setSeed(seed);
		return s;
		
		

	}
	
}
