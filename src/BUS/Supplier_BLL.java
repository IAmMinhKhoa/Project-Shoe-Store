package BUS;

import java.util.Vector;

import DAO.Supplier_DAL;
import DTO.Supplier;
public class Supplier_BLL {
	Supplier_DAL suppDAL = new Supplier_DAL();
	public Vector<Supplier> getAllSupplier() {
		return suppDAL.getAllSupplier();
	}
	public String addSupplier(Supplier supp) {
		if (suppDAL.hasSupplierID(supp.getSupplierID()))
			return "Mã NV đã tồn tại!";
		if (suppDAL.addSupplier(supp))
			return "Thêm thành công!";
		return "Thêm thất bại!";
	}
	public String deleteSupplier(int id) {
		if(suppDAL.deleteSupplier(id))
			return "Xóa thành công!";
		return "Xóa thất bại!";
	}
	public String editSupplier(Supplier supp) {
		if (suppDAL.editSupplier(supp))
			return "Sửa thành công!";
		return "Sửa thất bại!";
	}
}
