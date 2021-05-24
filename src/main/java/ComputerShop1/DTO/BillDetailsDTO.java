package ComputerShop1.DTO;

public class BillDetailsDTO {
	private long id;
	private long id_bill;
	private long id_product;
	private String product;
	private int amount;
	private double price;

	public BillDetailsDTO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public long getId_bill() {
		return id_bill;
	}

	public void setId_bill(long id_bill) {
		this.id_bill = id_bill;
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
