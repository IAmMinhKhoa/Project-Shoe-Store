package BUS;

import java.util.ArrayList;
import java.util.Vector;

import DAO.ShoeDAO;
import DAO.PromotionDAO;
import DAO.PromotionDetailsDAO;
import DTO.PromotionDetails;
import DTO.Promotion_DTO;
import DTO.ShoeDTO;

public class PromotionBLL {
	PromotionDAO promDAO = new PromotionDAO();
	PromotionDetailsDAO promDDAO = new PromotionDetailsDAO();
	ShoeDAO shoesDAO = new ShoeDAO();
	public Vector<Promotion_DTO> getAllPromotion() {
		return promDAO.getAllPromtion();
	}
	public Vector<PromotionDetails> getAllShoesPromotion(int id) {
		return promDDAO.getAllShoes(id);
	}
	public Vector<PromotionDetails> getAllPromotionDetails() {
		return promDDAO.getAllPromotionDetails();
	}
	public ArrayList<ShoeDTO> getAllShoes() {
		return shoesDAO.getAllShoe();
	}
	public String addPromotion(Promotion_DTO prom, Vector<PromotionDetails> arr) {
		if (promDAO.hasPromotionID(prom.getPromotionID()))
			return "Mã KM đã tồn tại!";
		if(promDDAO.addPromotionDetails(arr)!=true) {
			return "Cần chọn sản phẩm giảm giá!";
		} else if(promDAO.addPromotion(prom)) 
			return "Thêm thành công!";
		return "Thêm thất bại!";
	}
	public String deletePromotion(int idPromtion) {
		if(promDAO.deletePromtion(idPromtion) && promDDAO.deletePromtionDetails(idPromtion))
			return "Xóa thành công!";
		return "Xóa thất bại!";
	}
	public String editPromotion(int id, Promotion_DTO prom, Vector<PromotionDetails> arr) {
		promDAO.deletePromtion(id); 
		promDDAO.deletePromtionDetails(id);
		if(promDDAO.addPromotionDetails(arr)!=true) {
			return "Cần chọn sản phẩm giảm giá!";
		} else if(promDAO.addPromotion(prom)) 
			return "Sửa thành công!";
		return "Sửa thất bại!";
	}
}
