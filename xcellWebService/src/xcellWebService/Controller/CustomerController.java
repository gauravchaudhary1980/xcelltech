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

import xcellWebService.Dao.CustomerDao;
import xcellWebService.Modal.Customer;

@RestController
public class CustomerController {
	@Autowired
	CustomerDao customerDAO;
	
	@GetMapping("/customers")
	public List<Customer> getAll() {
		return customerDAO.findAll();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/customer/{id}")
	public ResponseEntity get(@PathVariable("id") String customerCode) {
		Customer customer = customerDAO.findByCode(customerCode);
		if (customer == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/customer")
	public ResponseEntity create(@RequestBody Customer customer) {
		if(customerDAO.isExist(customer))
		{
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		else
		{
			customerDAO.save(customer);
		}
		return new ResponseEntity(customer, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/customer")
	public ResponseEntity delete(@RequestBody Customer customer) {

		if(customerDAO.isExist(customer))
		{
			customerDAO.delete(customer);			
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/customer")
	public ResponseEntity update(@RequestBody Customer customer) {

		if(customerDAO.isExist(customer))
		{
			customerDAO.update(customer);
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(customer, HttpStatus.OK);
	}
}
