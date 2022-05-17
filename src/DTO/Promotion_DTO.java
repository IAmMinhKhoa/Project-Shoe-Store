package DTO;

import java.sql.Date;

public class Promotion_DTO {
	int PromotionID; //Mã km
	String PromotionName;  //tên km
	String PromotionForm; //hình thức km
	int Discount; //Mức giảm giá
	Date DateStart; //ngày bđ
	Date DateEnd; // ngày kt
	String PromotionDescribe; //Mô tả 
	
	public Promotion_DTO() {
	}

	public Promotion_DTO(int PromotionID, String PromotionName, String PromotionForm, int Discount, Date DateStart, Date DateEnd, String PromotionDescribe) {
		this.PromotionID = PromotionID;
		this.PromotionName = PromotionName;
		this.PromotionForm = PromotionForm;
		this.Discount = Discount;
		this.DateStart = DateStart;
		this.DateEnd = DateEnd;
		this.PromotionDescribe = PromotionDescribe;
	}

	public Promotion_DTO(Promotion_DTO prom) {
		this.PromotionID = prom.PromotionID;
		this.PromotionName = prom.PromotionName;
		this.PromotionForm = prom.PromotionForm;
		this.Discount = prom.Discount;
		this.DateStart = prom.DateStart;
		this.DateEnd = prom.DateEnd;
		this.PromotionDescribe = prom.PromotionDescribe;
	}

	public int getPromotionID() {
		return PromotionID;
	}

	public void setPromotionID(int promotionID) {
		PromotionID = promotionID;
	}

	public String getPromotionName() {
		return PromotionName;
	}

	public void setPromotionName(String promotionName) {
		PromotionName = promotionName;
	}

	public String getPromotionForm() {
		return PromotionForm;
	}

	public void setPromotionForm(String promotionForm) {
		PromotionForm = promotionForm;
	}

	public int getDiscount() {
		return Discount;
	}

	public void setDiscount(int discount) {
		Discount = discount;
	}

	public Date getDateStart() {
		return DateStart;
	}

	public void setDateStart(Date dateStart) {
		DateStart = dateStart;
	}

	public Date getDateEnd() {
		return DateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		DateEnd = dateEnd;
	}

	public String getPromotionDescribe() {
		return PromotionDescribe;
	}

	public void setPromotionDescribe(String promotionDescribe) {
		PromotionDescribe = promotionDescribe;
	}
	
}
