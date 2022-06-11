package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Oeffnungszeit;
import ch.zhaw.springboot.repositories.OeffnungszeitRepository;

@RestController

public class OeffnungszeitRestController {
	@Autowired
	private OeffnungszeitRepository repository;
	
	@RequestMapping(value="cbp/oeffnungszeit", method=RequestMethod.GET)
	public ResponseEntity <List<Oeffnungszeit>> getOeffnungszeiten() {
		
		List<Oeffnungszeit> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity <List<Oeffnungszeit>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Oeffnungszeit>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "pwo/oeffnungszeiten/{id}", method = RequestMethod.GET)
	public ResponseEntity <Oeffnungszeit> getOeffnungszeit(@PathVariable("id") long id) {
		Optional<Oeffnungszeit> result = this.repository.findById(id);
		
		if(result.isEmpty()) {
			return new ResponseEntity<Oeffnungszeit>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Oeffnungszeit>(result.get(), HttpStatus.OK);
	}

	 @RequestMapping(value = "eatily/oeffnungszeit", method = RequestMethod.POST)
	    public ResponseEntity<Oeffnungszeit> createPerson(@RequestBody Oeffnungszeit oeffnungszeit) {
	    Oeffnungszeit result = this.repository.save(oeffnungszeit);
	    return new ResponseEntity<Oeffnungszeit>(result, HttpStatus.OK);
	    }

}
