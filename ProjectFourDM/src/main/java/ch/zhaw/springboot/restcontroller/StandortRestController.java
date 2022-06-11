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

import ch.zhaw.springboot.entities.Standort;
import ch.zhaw.springboot.repositories.StandortRepository;

@RestController

public class StandortRestController {
	
	@Autowired
	private StandortRepository repository;
	
	@RequestMapping(value="/eatily/Standort", method=RequestMethod.GET)
	public ResponseEntity <List<Standort>> getStandort(){
		
		List<Standort> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity<List<Standort>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Standort>>(result, HttpStatus.OK);
	}
	

@RequestMapping(value = "/eatily/Standort/{id}", method = RequestMethod.GET)
public ResponseEntity <Standort> getStandort(@PathVariable("id") long id) {
	Optional<Standort> result = this.repository.findById(id);
	
	if(result.isEmpty()) {
		return new ResponseEntity<Standort>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Standort>(result.get(), HttpStatus.OK);
}

@RequestMapping(value = "/eatily/Standort", method = RequestMethod.POST)
public ResponseEntity<Standort> createStandort(@RequestBody Standort standort) {
Standort result = this.repository.save(standort);
return new ResponseEntity<Standort>(result, HttpStatus.OK);
}


@RequestMapping(value = "/eatily/Standort/{id}", method = RequestMethod.PUT)
public ResponseEntity<Standort> updateStandort(@PathVariable(value = "id") Long id, @RequestBody Standort newStandort) {
Optional<Standort> Standort = this.repository.findById(id);

if (Standort.isPresent()) {
Standort st = Standort.get();
st.setStrasse(newStandort.getStrasse());
st.setPLZ(newStandort.getPLZ());
st.setStadt(newStandort.getStadt());

Standort updatedStandort = this.repository.save(st);
return new ResponseEntity<Standort>((updatedStandort), HttpStatus.OK);
} else {
return ResponseEntity.notFound().build();
}
}

@RequestMapping(value = "/eatily/Standort/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Standort> deleteUser(@PathVariable(value = "id") Long id) {
Optional<Standort> stani = this.repository.findById(id);
if (stani.isPresent()) {
this.repository.delete(stani.get());
return new ResponseEntity("Standort has been deleted successfully.", HttpStatus.OK);
} else {
return ResponseEntity.notFound().build();
}
}


}