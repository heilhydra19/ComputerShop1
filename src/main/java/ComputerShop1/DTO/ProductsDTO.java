package ComputerShop1.DTO;

import java.sql.Date;

public class ProductsDTO {
	private long id;
	private long id_category;
	private long id_brand;
	private String img;
	private String name;
	private int amount;
	private double price;
	private String detail;
	private Date created_at;
	private Date updated_at;
	private String category;
	private String brand;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public ProductsDTO() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_category() {
		return id_category;
	}
	public void setId_category(long id_category) {
		this.id_category = id_category;
	}
	public long getId_brand() {
		return id_brand;
	}
	public void setId_brand(long id_brand) {
		this.id_brand = id_brand;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}
