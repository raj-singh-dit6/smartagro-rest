package gov.smartagro.api.model;

import lombok.Data;

@Data
public class UserCropRequestObject {

	private Long cropid;
	private Long seedid;
	private Long userid;

	public UserCrop toEntity() {
		UserCrop u = new UserCrop();

		u.setCropid(this.cropid);
		u.setSeedid(this.seedid);
		u.setUserid(this.userid);
		return u;
	}

}
