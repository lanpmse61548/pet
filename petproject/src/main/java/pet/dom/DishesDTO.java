package pet.dom;

public class DishesDTO {
private Long dis_id;
	
	private String dis_name;
	private String description;
	private String dis_type;
	private String main_ingredient ;
	private Long price;

	private String unit  ;
	private long version;
	public Long getDis_id() {
		return dis_id;
	}
	public void setDis_id(Long dis_id) {
		this.dis_id = dis_id;
	}
	public String getDis_name() {
		return dis_name;
	}
	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDis_type() {
		return dis_type;
	}
	public void setDis_type(String dis_type) {
		this.dis_type = dis_type;
	}
	public String getMain_ingredient() {
		return main_ingredient;
	}
	public void setMain_ingredient(String main_ingredient) {
		this.main_ingredient = main_ingredient;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	
	
}
