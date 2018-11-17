package gov.smartagro.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.smartagro.api.model.Crop;
import gov.smartagro.api.repository.CropRepository;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    private static final Logger logger = LoggerFactory.getLogger(CropService.class);

	public List<Crop> getCrops() {
		return cropRepository.findAll();
	}
}
