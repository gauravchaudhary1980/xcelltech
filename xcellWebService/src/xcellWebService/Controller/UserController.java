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
/*import xcellWebService.SendMailTLS;*/
import xcellWebService.Dao.CityDao;
import xcellWebService.Dao.UserDao;
import xcellWebService.Modal.City;
import xcellWebService.Modal.Setting;
import xcellWebService.Modal.User;
import xcellWebService.Modal.UserDetails;

/*import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;*/

@RestController
public class UserController {
	@Autowired
	UserDao userDAO;
	
	@Autowired
	CityDao cityDAO;
	
	@GetMapping("/users")
	public List<User> getAll() {
		return userDAO.findAll();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/user/{id}")
	public ResponseEntity get(@PathVariable("id") String phone) {
		User user = userDAO.findByCode(phone);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/userdetails/{id}")
	public ResponseEntity getDetails(@PathVariable("id") String phone) {
		User user = userDAO.findByCode(phone);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		Setting setting =user.getSetting();
		City city = cityDAO.findByCode(setting.getCityCode());	
		UserDetails userDetails= new UserDetails();
		userDetails.setPhone(user.getPhone());
		userDetails.setName(user.getName());
		userDetails.setEmail(user.getEmail());
		userDetails.setPassword(user.getPassword());
		userDetails.setActive(true);		
		userDetails.setSetting(setting);
		userDetails.setCity(city);
		
		return new ResponseEntity(userDetails, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/user")
	public ResponseEntity create(@RequestBody User user) {
		if(userDAO.isExist(user))
		{
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		else
		{
			userDAO.save(user);
		}
		return new ResponseEntity(user, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/user")
	public ResponseEntity delete(@RequestBody User user) {

		if(userDAO.isExist(user))
		{
			userDAO.delete(user);			
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/user")
	public ResponseEntity update(@RequestBody User user) {

		if(userDAO.isExist(user))
		{
			userDAO.update(user);
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}
	
	@GetMapping("/send")
	public String send() {		
		final String toEmail = "gaurav.chaudhary.22.7.1978@gmail.com"; // can be any email id 
		EmailUtil.sendEmail(toEmail,"My Testing Subject", "My Testing Body");	
		return "sent..";
	}
}
