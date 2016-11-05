package xcellWebService.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotEmpty
	@Column(name = "city_code", nullable = false)
	String cityCode;
	
	@NotEmpty
	@Column(name = "name", nullable = false)
	String name;
	
	@NotEmpty
	@Column(name = "person", nullable = false)
	String person;
	
	@NotEmpty
	@Column(name = "address", nullable = false)
	String address;
	
	@NotEmpty
	@Column(name = "phone", nullable = false)
	String phone;
	
	@NotNull
	@Column(name = "is_create", nullable = false,columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	boolean isCreate;
	
	@NotNull
	@Column(name = "is_resume", nullable = false,columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	boolean isResume;
	
	@NotNull
	@Column(name = "is_close", nullable = false,columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	boolean isClose;
	
	
	//getter and setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isCreate() {
		return isCreate;
	}

	public void setCreate(boolean isCreate) {
		this.isCreate = isCreate;
	}

	public boolean isResume() {
		return isResume;
	}

	public void setResume(boolean isResume) {
		this.isResume = isResume;
	}

	public boolean isClose() {
		return isClose;
	}

	public void setClose(boolean isClose) {
		this.isClose = isClose;
	}
	
}
