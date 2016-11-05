package xcellWebService.Modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="phone",nullable=false)
	String phone;
	
	@NotEmpty
	@Column(name="name" , nullable=false)
	String name;
		
	@NotEmpty
	@Column(name="email",nullable=false)
	String email;
	
	@NotEmpty
	@Column(name="password",nullable=false)
	String password;
	
	@NotNull
	@Column(name="is_active",nullable=false,columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	boolean isActive;	
		
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="phone")
	Setting setting;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}
	
	
}
