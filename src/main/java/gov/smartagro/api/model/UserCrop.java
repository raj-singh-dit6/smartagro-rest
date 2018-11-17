package gov.smartagro.api.model;

public class UserCrop {

	private Long userCropId; 
	private Long cropId;
	private Long userId;
	
	
	public UserCrop() {
		// TODO Auto-generated constructor stub
	}
	
	public UserCrop(Long userCropId, Long cropId, Long userId) {
		super();
		this.userCropId = userCropId;
		this.cropId = cropId;
		this.userId = userId;
	}
	/**
	 * @return the userCropId
	 */
	public Long getUserCropId() {
		return userCropId;
	}
	/**
	 * @param userCropId the userCropId to set
	 */
	public void setUserCropId(Long userCropId) {
		this.userCropId = userCropId;
	}
	/**
	 * @return the cropId
	 */
	public Long getCropId() {
		return cropId;
	}
	/**
	 * @param cropId the cropId to set
	 */
	public void setCropId(Long cropId) {
		this.cropId = cropId;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
}
