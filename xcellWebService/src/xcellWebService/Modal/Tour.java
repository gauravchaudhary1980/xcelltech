package xcellWebService.Modal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tour")
public class Tour {
	@Id
	@Column(name="activity_id",nullable=false)
	String activityId;
	
	@NotEmpty
	@Column(name="customer_code",nullable=false)
	String customerCode;
	
	@NotEmpty
	@Column(name="pan_number",nullable=false)
	String panNumber;
	
	@NotEmpty
	@Column(name="quantity",nullable=false)
	String quantity;
	
	@NotEmpty
	@Column(name="vehicle_number",nullable=false)
	String vehicleNumber;
	
	@NotEmpty
	@Column(name="driver_number",nullable=false)
	String driverNumber;
	
	@NotEmpty
	@Column(name="gr_number",nullable=false)
	String grNumber;
	
	@Column(name="note")
	String note;
	
	
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getDriverNumber() {
		return driverNumber;
	}

	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}

	public String getGrNumber() {
		return grNumber;
	}

	public void setGrNumber(String grNumber) {
		this.grNumber = grNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
