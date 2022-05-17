package BUS;

import java.util.Vector;

import DAO.PersonnelManagement_DAL;
import DTO.PersonnelManagement_DTO;

public class PersonnelManagement_BLL {
	PersonnelManagement_DAL perDAL = new PersonnelManagement_DAL();
	public Vector<PersonnelManagement_DTO> getAllPersonnel() {
		return perDAL.getAllPersonnel();
	}
	public String addPersonnel(PersonnelManagement_DTO per) {
		if (perDAL.hasPersonnelID(per.getPersonnelID()))
			return "Mã NV đã tồn tại!";
		if (perDAL.addPersonnel(per))
			return "Thêm thành công!";
		return "Thêm thất bại!";
	}
	public String deletePersonnel(int id) {
		if(perDAL.deletePersonnel(id))
			return "Xóa thành công!";
		return "Xóa thất bại!";
	}
	public String editPersonnel(PersonnelManagement_DTO per) {
		if (perDAL.editPersonnel(per))
			return "Sửa thành công!";
		return "Sửa thất bại!";
	}
}
