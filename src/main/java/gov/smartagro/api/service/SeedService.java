package gov.smartagro.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.smartagro.api.model.Seed;
import gov.smartagro.api.repository.SeedRepository;

@Service
public class SeedService {

    @Autowired
    private SeedRepository seedRepository;

    private static final Logger logger = LoggerFactory.getLogger(SeedService.class);

	public List<Seed> getSeeds() {
		return seedRepository.findAll();
	}

	public List<Seed> getSeedsByCropId(Long cropId) {
		return seedRepository.findByCropid(cropId);
	}
}

