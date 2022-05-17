package DTO;

public class DetailsAccessory_DTO {
	int ImportID;
	int AccessoryID;
	int Quantity;
	long Price;
	
	public DetailsAccessory_DTO() {
	}
	
	public DetailsAccessory_DTO(int ImportID,int AccessoryID,int Quantity,long Price) {
		this.ImportID = ImportID;
		this.AccessoryID = AccessoryID;
		this.Quantity = Quantity;
		this.Price = Price;
	}
	public DetailsAccessory_DTO(DetailsAccessory_DTO details) {
		this.ImportID = details.ImportID;
		this.AccessoryID = details.AccessoryID;
		this.Quantity = details.Quantity;
		this.Price = details.Price;
	}

	public int getImportID() {
		return ImportID;
	}

	public void setImportID(int importID) {
		ImportID = importID;
	}

	public int getAccessoryID() {
		return AccessoryID;
	}

	public void setShoesID(int accessoryID) {
		AccessoryID = accessoryID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}
}
