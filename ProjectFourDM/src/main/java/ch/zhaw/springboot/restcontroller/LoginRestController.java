package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Login;
import ch.zhaw.springboot.repositories.LoginRepository;

@RestController

public class LoginRestController {
	
	@Autowired
	private LoginRepository repository;
	
	@CrossOrigin(origins = "*")
	
	@RequestMapping(value="eatily/logins", method=RequestMethod.GET)
	public ResponseEntity <List<Login>> getLogins() {
		
		List<Login> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity <List<Login>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Login>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "eatily/login/{id}", method = RequestMethod.GET)
	public ResponseEntity <Login> getLogin(@PathVariable("id") long id) {
		Optional<Login> result = this.repository.findById(id);
		
		if(result.isEmpty()) {
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Login>(result.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "eatily/login", method = RequestMethod.POST)
	public ResponseEntity<Login> createLogin(@RequestBody Login login) {
		Login result = this.repository.save(login);
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}
	
	@RequestMapping(value = "eatily/login/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Login> updateLogin(@PathVariable(value = "id") Long id, @RequestBody Login newLogin) {
	Optional<Login> login = this.repository.findById(id);
	
	if (login.isPresent()) {
	Login log = login.get();
	log.setEmail(newLogin.getEmail());
	log.setPasswort(newLogin.getPasswort());

	Login updatedLogin = this.repository.save(log);
	return new ResponseEntity<Login>((updatedLogin), HttpStatus.OK);
	} else {
	return ResponseEntity.notFound().build();
	}
	}
	
	 @RequestMapping(value = "/eatily/login/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Login> deleteLogin(@PathVariable(value = "id") Long id) {
	  Optional<Login> login = this.repository.findById(id);
	  if (login.isPresent()) {
	   this.repository.delete(login.get());
	   return new ResponseEntity("Login has been deleted successfully.", HttpStatus.OK);
	  } else {
	   return ResponseEntity.notFound().build();
	  }
	 }


}
