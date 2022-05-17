package DTO;

public class DetailsShoes_DTO {
	int ImportID;
	int ShoesID;
	int Quantity;
	long Price;
	
	public DetailsShoes_DTO() {
	}
	
	public DetailsShoes_DTO(int ImportID,int ShoesID,int Quantity,long Price) {
		this.ImportID = ImportID;
		this.ShoesID = ShoesID;
		this.Quantity = Quantity;
		this.Price = Price;
	}
	public DetailsShoes_DTO(DetailsShoes_DTO details) {
		this.ImportID = details.ImportID;
		this.ShoesID = details.ShoesID;
		this.Quantity = details.Quantity;
		this.Price = details.Price;
	}

	public int getImportID() {
		return ImportID;
	}

	public void setImportID(int importID) {
		ImportID = importID;
	}

	public int getShoesID() {
		return ShoesID;
	}

	public void setShoesID(int shoesID) {
		ShoesID = shoesID;
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
