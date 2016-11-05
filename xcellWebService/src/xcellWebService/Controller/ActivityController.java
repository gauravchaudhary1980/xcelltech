package xcellWebService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xcellWebService.EmailUtil;
import xcellWebService.Dao.ActivityDao;
import xcellWebService.Dao.CityDao;
import xcellWebService.Dao.CustomerDao;
import xcellWebService.Dao.UserDao;
import xcellWebService.Modal.Activity;
import xcellWebService.Modal.City;
import xcellWebService.Modal.Customer;
import xcellWebService.Modal.User;

@RestController
public class ActivityController {
	@Autowired
	ActivityDao activityDAO;
	
	@Autowired
	CustomerDao customerDAO;
	
	@Autowired
	UserDao userDAO;
	
	@Autowired
	CityDao cityDAO;	
	
	@GetMapping("/activities")
	public List<Activity> getAll() {
		return activityDAO.findAll();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/activity/{id}")
	public ResponseEntity get(@PathVariable("id") String activityId) {
		Activity activity = activityDAO.findByCode(activityId);
		if (activity == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(activity, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/activity")
	public ResponseEntity create(@RequestBody Activity activity) {
		if(activityDAO.isExist(activity))
		{
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		else
		{
			activityDAO.save(activity);
			
			//Get From Details
			User user=userDAO.findByCode(activity.getCreatedBy());
			String cityCodeFrom=user.getSetting().getCityCode();
			City cityFrom=cityDAO.findByCode(cityCodeFrom);
			
			//Get To Details
			String customerCode = activity.getTour().getCustomerCode();
			Customer customer = customerDAO.findByCode(customerCode);
			
			String subject ="MKT : Vehicle DEPARTURE information";
			String body="Dear "+ customer.getName() + " ("+ activity.getTour().getCustomerCode() +"),\n" +
					     "Vehicle No " + activity.getTour().getVehicleNumber()+ " has been started from " + cityFrom.getName() + " ("+cityFrom.getCityCode()+")" + " for " + customer.getCity() + ".\n" +
					     "Driver Contact No : " + activity.getTour().getDriverNumber() + "\n" +
					     "Regards, \n" +
					     "MKT\n" + 
					     "8396878710";
			sendMail(activity,subject,body,customer.getEmail1(),customer.getEmail2());
		}
		return new ResponseEntity(activity, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/activity")
	public ResponseEntity delete(@RequestBody Activity activity) {

		if(activityDAO.isExist(activity))
		{
			activityDAO.delete(activity);			
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(activity, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/activity")
	public ResponseEntity update(@RequestBody Activity activity) {

		if(activityDAO.isExist(activity))
		{
			activityDAO.update(activity);
			String subject="";
			String body="";
			//Get From Details
			User user=userDAO.findByCode(activity.getCreatedBy());
			String cityCodeFrom=user.getSetting().getCityCode();
			City cityFrom=cityDAO.findByCode(cityCodeFrom);
			
			//Get To Details
			String customerCode = activity.getTour().getCustomerCode();
			Customer customer = customerDAO.findByCode(customerCode);
			
			if(activity.getStatus().equalsIgnoreCase("COMPLETE"))
			{
				subject ="MKT : Vehicle ARRIVAL information";
				body="Dear "+ customer.getName() + " ("+ activity.getTour().getCustomerCode() +"),\n" +
				     "Vehicle No " + activity.getTour().getVehicleNumber() + " has been arrived at " + customer.getCity() + ".\n" +
				     "Driver Contact No : " + activity.getTour().getDriverNumber() + "\n" +
				     "Regards, \n" +
				     "MKT\n" + 
				     "8396878710";
			}
			else
			{
				subject ="MKT : Vehicle "+activity.getStatus()+" information";
				body="Dear "+ customer.getName() + " ("+ activity.getTour().getCustomerCode() +"),\n" +
					 "Status for \n" + 	
				     "Vehicle No " + activity.getTour().getVehicleNumber()+ " started from " + cityFrom.getName() + " ("+cityFrom.getCityCode()+")" + " for " + customer.getCity() + ".\n" +
				     "Driver Contact No : " + activity.getTour().getDriverNumber() + "\n" +
				     "Regards, \n" +
				     "MKT\n" + 
				     "8396878710";
			}
			
			sendMail(activity,subject,body,customer.getEmail1(),customer.getEmail2());
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(activity, HttpStatus.OK);
	}
	
	private void sendMail(Activity activity,String subject,String body,String toEmail1,String toEmail2)
	{
		if(activity!=null)
		 {
			if(!toEmail1.equals(""))
			 {
				
				 EmailUtil.sendEmail(toEmail1,subject, body);	
			 }
			 
			 if(!toEmail2.equals(""))
			 {
				 EmailUtil.sendEmail(toEmail2,subject, body);	
			 }
			
		 }
		 
	}
}
