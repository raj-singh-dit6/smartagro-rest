package gov.smartagro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gov.smartagro.api.model.Userstatus;
import gov.smartagro.api.repository.UserStatusReporsitory;
import gov.smartagro.api.response.SingleResponse;

@RestController
public class NotificationController {

	@Autowired
	private UserStatusReporsitory userstatusRepository;

	@GetMapping("/userstatus/{userId}")
	public String getUserStatus(@PathVariable("userId") Long userId) {
		String notify = "";

		try {

			Userstatus users = userstatusRepository.findByUserid(userId);
				
			if(users!=null){
				
				if(users.getNval()!=null &&users.getNval()){
					notify= "N increased!";
				}else if(users.getKval()!=null && users.getKval()){
					notify= "K increased!";
				}else if(users.getPval()!=null &&users.getPval()){
					notify= "P increased!";
				}else if(users.getH()!=null && users.getH()){
					notify= "Humidity increased!";
				}else if(users.getSm()!=null && users.getSm()){
					notify= "Soil moisture is more!";
				}else if(users.getT()!=null && users.getT()){
					notify= "Tempreture is more!";
				}
				
				users.setH(false);
				users.setKval(false);
				users.setSm(false);
				users.setT(false);
				users.setNval(false);
				users.setPval(false);
				userstatusRepository.save(users);
				
			}

		} catch (Exception e) {

		}

		return notify;
	}
	
	
	@PostMapping("/userstatus/{userId}")
	public SingleResponse<Userstatus> getUserStatus(@PathVariable("userId") Long userId, @RequestBody() Userstatus users) {
		
		SingleResponse<Userstatus> resp=new SingleResponse<>();
		
		try {

			Userstatus userstatus=userstatusRepository.findByUserid(userId);
			if(userstatus!=null){
				users.setUserid(userstatus.getUserid());
				users=userstatusRepository.save(users);
			}else {
				users=userstatusRepository.save(users);
			}
		

		} catch (Exception e) {
			resp.setSuccess(false);
			return resp;
		}
		resp.setData(users);
		resp.setSuccess(true);

		return resp;
	}
	

}
