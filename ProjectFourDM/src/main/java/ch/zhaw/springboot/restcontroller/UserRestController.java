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

import ch.zhaw.springboot.entities.User;
import ch.zhaw.springboot.repositories.UserRepository;

@RestController

public class UserRestController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(value="cbp/user", method=RequestMethod.GET)
	public ResponseEntity <List<User>> getUsers() {
		
		List<User> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity <List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value ="pwo/users/{id}", method = RequestMethod.GET)
	public ResponseEntity <User> getUser(@PathVariable("id") long id) {
		Optional<User> result = this.repository.findById(id);
		
		if(result.isEmpty()) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(result.get(), HttpStatus.OK);
	}

}
