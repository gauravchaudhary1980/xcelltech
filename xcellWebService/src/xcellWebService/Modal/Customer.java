package xcellWebService.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="customer_code",nullable=false)
	String customerCode;
	
	@NotEmpty
	@Column(name="name",nullable=false)
	String name;
	
	@NotEmpty
	@Column(name="address1",nullable=false)
	String address1;
		
	@Column(name="address2",nullable=true)
	String address2;
	
	@NotEmpty
	@Column(name="city",nullable=false)
	String city;
	
	@NotEmpty
	@Column(name="phone1",nullable=false)
	String phone1;
	
	@Column(name="phone2",nullable=true)
	String phone2;
	
	@NotEmpty
	@Column(name="email1",nullable=false)
	String email1;
	
	@Column(name="email2",nullable=true)
	String email2;

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customer_code) {
		this.customerCode = customer_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	
}
