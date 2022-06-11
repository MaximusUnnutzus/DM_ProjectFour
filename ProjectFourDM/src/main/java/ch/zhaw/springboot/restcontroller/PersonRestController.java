/*package ch.zhaw.springboot.restcontroller;

import java.util.List;

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
public class PersonRestController {
	@Autowired
	private UserRepository repository;

	@RequestMapping(value = "pwo/persons", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getPersons() {
		List<User> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<User>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "pwo/users/{birthdate}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsersByBirthdate(@PathVariable("birthdate") long birthdate) {
		List<User> result = this.repository.findUsersByBirthdate(birthdate);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<User>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
	}
}*/
