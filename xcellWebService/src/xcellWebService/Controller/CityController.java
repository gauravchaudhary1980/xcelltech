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

import xcellWebService.Dao.CityDao;
import xcellWebService.Modal.City;


@RestController
public class CityController {

	@Autowired
	CityDao cityDAO;	
	
	@GetMapping("/cities")
	public List<City> getAll() {
		return cityDAO.findAll();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/city/{id}")
	public ResponseEntity get(@PathVariable("id") String cityCode) {
		City city = cityDAO.findByCode(cityCode);
		if (city == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(city, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/city")
	public ResponseEntity create(@RequestBody City city) {
		if(cityDAO.isExist(city))
		{
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		else
		{
			cityDAO.save(city);
		}
		return new ResponseEntity(city, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/city")
	public ResponseEntity delete(@RequestBody City city) {

		if(cityDAO.isExist(city))
		{
			cityDAO.delete(city);			
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(city, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/city")
	public ResponseEntity update(@RequestBody City city) {

		if(cityDAO.isExist(city))
		{
			cityDAO.update(city);
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(city, HttpStatus.OK);
	}

}
