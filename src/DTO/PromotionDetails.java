package DTO;

public class PromotionDetails {
	int PromotionID;
	int ShoesID;
	String ShoesName;
	
	public PromotionDetails() {
	}
	
	public PromotionDetails(int promotionID, int shoesID, String shoesName) {
		this.PromotionID = promotionID;
		this.ShoesID = shoesID;
		this.ShoesName = shoesName;
	}
	
	public PromotionDetails(PromotionDetails promDetails) {
		this.PromotionID = promDetails.PromotionID;
		this.ShoesID = promDetails.ShoesID;
		this.ShoesName = promDetails.ShoesName;
	}

	public int getPromotionID() {
		return PromotionID;
	}

	public void setPromotionID(int promotionID) {
		PromotionID = promotionID;
	}

	public int getShoesID() {
		return ShoesID;
	}

	public void setShoesID(int shoesID) {
		ShoesID = shoesID;
	}

	public String getShoesName() {
		return ShoesName;
	}

	public void setShoesName(String shoesName) {
		ShoesName = shoesName;
	}
	
}
