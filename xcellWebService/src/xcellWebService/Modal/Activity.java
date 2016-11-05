package xcellWebService.Modal;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="activity")
public class Activity {
	@Id	
	@Column(name="activity_id",nullable=false)
	String activityId;
	
	@NotEmpty
	@Column(name="activity_type",nullable=false)
	String activityType;
	
	@NotEmpty
	@Column(name="user_id",nullable=false)
	String userId;
	
	@NotNull
	@JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name="start_date_time",nullable=false)
	Date  startDate;
	
	@Column(name="end_date_time",nullable=true)
	@JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
	Date  endDate;
	
	@NotEmpty
	@Column(name="created_by",nullable=false)
	String createdBy;
	
	@NotEmpty
	@Column(name="modified_by",nullable=false)
	String modifiedBy;
	
	@NotEmpty
	@Column(name="status",nullable=false)
	String status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="activity_id")
	Tour tour;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}
	

}
