package xcellWebService.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="setting")
public class Setting {
	
	@Id
	@Column(name = "phone", nullable = false)
	String phone;
	
	@NotEmpty
	@Column(name = "city_code", nullable = false)
	String cityCode;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

		
	
}
