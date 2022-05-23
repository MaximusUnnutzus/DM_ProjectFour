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

import ch.zhaw.springboot.entities.Login;
import ch.zhaw.springboot.repositories.LoginRepository;

@RestController

public class LoginRestController {
	
	@Autowired
	private LoginRepository repository;
	
	@RequestMapping(value="cbp/login", method=RequestMethod.GET)
	public ResponseEntity <List<Login>> getLogins() {
		
		List<Login> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity <List<Login>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Login>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "pwo/logins/{id}", method = RequestMethod.GET)
	public ResponseEntity <Login> getLogin(@PathVariable("id") long id) {
		Optional<Login> result = this.repository.findById(id);
		
		if(result.isEmpty()) {
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Login>(result.get(), HttpStatus.OK);
	}

}
