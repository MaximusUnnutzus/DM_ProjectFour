package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Standort;
import ch.zhaw.springboot.repositories.StandortRepository;

@RestController

public class StandortRestController {
	
	@Autowired
	private StandortRepository repository;
	
	@RequestMapping(value="sta/Standort", method=RequestMethod.GET)
	public ResponseEntity <List<Standort>> getStandort(){
		
		List<Standort> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity<List<Standort>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Standort>>(result, HttpStatus.OK);
	}
	

@RequestMapping(value = "sta/Standort/{id}", method = RequestMethod.GET)
public ResponseEntity <Standort> getStandort(@PathVariable("id") long id) {
	Optional<Standort> result = this.repository.findById(id);
	
	if(result.isEmpty()) {
		return new ResponseEntity<Standort>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Standort>(result.get(), HttpStatus.OK);
}
}