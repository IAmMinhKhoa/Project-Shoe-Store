package BUS;

import java.util.ArrayList;
import java.util.Vector;

import DAO.DetailsAccessory_DAL;
import DAO.DetailsShoes_DAL;
import DAO.Import_DAL;
import DTO.DetailsAccessory_DTO;
import DTO.DetailsShoes_DTO;
import DTO.Import_DTO;
import DAO.AccessoryDAO;
import DTO.AccessoryDTO;
import DAO.ShoeDAO;
import DTO.ShoeDTO;



public class Import_BLL {
	Import_DAL imp = new Import_DAL();
	DetailsAccessory_DAL acc = new DetailsAccessory_DAL();
	DetailsShoes_DAL shoes = new DetailsShoes_DAL();
	ShoeDAO shoesDAO = new ShoeDAO();
	AccessoryDAO accDAO = new AccessoryDAO();
	public ArrayList<ShoeDTO> getAllShoes() {
		return shoesDAO.getAllShoe();
	}
	public ArrayList<Import_DTO> getAllImport() {
		return imp.getAllImport();
	}
	public ArrayList<DetailsShoes_DTO> getAllDetailsShoes() {
		return shoes.getAllDetailsShoes();
	}
	public ArrayList<DetailsAccessory_DTO> getAllDetailsAccessory() {
		return acc.getAllDetailsAccessory();
	}
	public Boolean addImport1(Import_DTO impp) {
		if(imp.addImport(impp))
			return true;
		return false;
	}
	public Boolean addImportShoes(ArrayList<DetailsShoes_DTO> arr) {
		if(shoes.addDetailsShoes(arr))
			return true;
		return false;
	}
	public Boolean addImportAccessory(ArrayList<DetailsAccessory_DTO> arr) {
		if(acc.addDetailsAccessory(arr))
			return true;
		return false;
	}
	public Boolean addImportBoth(ArrayList<DetailsShoes_DTO> arr,ArrayList<DetailsAccessory_DTO> arr1) {
		if(shoes.addDetailsShoes(arr) && acc.addDetailsAccessory(arr1))
			return true;
		return false;
	}
	public Boolean updateSLGIAY(ArrayList<DetailsShoes_DTO> arr) {
		ArrayList<ShoeDTO> arrshoes = new ArrayList<ShoeDTO>();
		arrshoes = getAllShoes();
		int flag = 0;
		for(int i=0; i<arr.size();i++) {
			for(int j=0;j<arrshoes.size();j++) {
				if(arr.get(i).getShoesID()==arrshoes.get(j).getMaSP()) {
					int slnew = arr.get(i).getQuantity() + arrshoes.get(j).getSl();
					//System.out.println(slnew+" ");
					if(shoes.updateSLGIAY(arrshoes.get(j), slnew))
						flag = 1;
				}
			}
		}
		if(flag == 1) 
			return true;
		else
			return false;
	}
	public Boolean updateSLPK(ArrayList<DetailsAccessory_DTO> arr) {
		ArrayList<AccessoryDTO> arracc = new ArrayList<AccessoryDTO>();
		arracc = accDAO.getAllAS();
		int flag = 0;
		for(int i=0; i<arr.size();i++) {
			for(int j=0;j<arracc.size();j++) {
				if(arr.get(i).getAccessoryID()==arracc.get(j).getMaSP()) {
					int slnew = arr.get(i).getQuantity() + arracc.get(j).getSl();
					//System.out.println(slnew+" ");
					if(acc.updateSLPK(arracc.get(j), slnew))
						flag = 1;
				}
			}
		}
		if(flag == 1) 
			return true;
		else
			return false;
	}
}
