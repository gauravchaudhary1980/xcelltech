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

import xcellWebService.Dao.TourDao;
import xcellWebService.Modal.Tour;

@RestController
public class TourController {
	@Autowired
	TourDao tourDAO;	
	
	@GetMapping("/tours")
	public List<Tour> getAll() {
		return tourDAO.findAll();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/tour/{id}")
	public ResponseEntity get(@PathVariable("id") String activityId) {
		Tour tour = tourDAO.findByCode(activityId);
		if (tour == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(tour, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/tour")
	public ResponseEntity create(@RequestBody Tour tour) {
		if(tourDAO.isExist(tour))
		{
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		else
		{
			tourDAO.save(tour);
		}
		return new ResponseEntity(tour, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/tour")
	public ResponseEntity delete(@RequestBody Tour tour) {

		if(tourDAO.isExist(tour))
		{
			tourDAO.delete(tour);			
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(tour, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/tour")
	public ResponseEntity update(@RequestBody Tour tour) {

		if(tourDAO.isExist(tour))
		{
			tourDAO.update(tour);
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(tour, HttpStatus.OK);
	}
}
