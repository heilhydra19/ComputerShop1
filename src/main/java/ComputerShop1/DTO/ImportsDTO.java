package ComputerShop1.DTO;

import java.util.Date;

public class ImportsDTO {
	private long id;
	private long id_supplier;
	private String supplier;
	private Date created_at;
	public ImportsDTO() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_supplier() {
		return id_supplier;
	}
	public void setId_supplier(long id_supplier) {
		this.id_supplier = id_supplier;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}
