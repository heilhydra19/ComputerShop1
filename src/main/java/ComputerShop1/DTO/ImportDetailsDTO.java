package ComputerShop1.DTO;

public class ImportDetailsDTO {
	private long id;
	private long id_import;
	private long id_product;
	private String product;
	private int amount;
	private double price;

	public ImportDetailsDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_import() {
		return id_import;
	}

	public void setId_import(long id_import) {
		this.id_import = id_import;
	}

	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
