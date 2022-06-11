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

import ch.zhaw.springboot.entities.Login;
import ch.zhaw.springboot.entities.User;
import ch.zhaw.springboot.entities.restaurants;
import ch.zhaw.springboot.repositories.RestaurantRepository;

@RestController

public class restaurantsRestController {
	
	@Autowired
	private RestaurantRepository repository;
	
	@RequestMapping(value="cbp/restaurants", method=RequestMethod.GET)
	public ResponseEntity <List<restaurants>> getRestaurants(){
		
		List<restaurants> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity<List<restaurants>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<restaurants>>(result, HttpStatus.OK);
	}
	

@RequestMapping(value = "pwo/restaurants/{id}", method = RequestMethod.GET)
public ResponseEntity <restaurants> getRestaurant(@PathVariable("id") long id) {
	Optional<restaurants> result = this.repository.findById(id);
	
	if(result.isEmpty()) {
		return new ResponseEntity<restaurants>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<restaurants>(result.get(), HttpStatus.OK);
}

@RequestMapping(value = "eatily/restaurant", method = RequestMethod.POST)
public ResponseEntity<restaurants> createRestaurant(@RequestBody restaurants restaurant) {
	restaurants result = this.repository.save(restaurant);
	return new ResponseEntity<restaurants>(result, HttpStatus.OK);
}

@RequestMapping(value = "eatily/restaurant/{id}", method = RequestMethod.PUT)
public ResponseEntity<restaurants> updateRestaurant(@PathVariable(value = "id") Long id, @RequestBody restaurants newRestaurant) {
Optional<restaurants> restaurant = this.repository.findById(id);

if (restaurant.isPresent()) {
restaurants res = restaurant.get();
res.setName(newRestaurant.getName());
res.setVertragsStart(newRestaurant.getVertragsStart());
res.setVertragsEnde(newRestaurant.getVertragsEnde());

restaurants updatedRestaurant = this.repository.save(res);
return new ResponseEntity<restaurants>((updatedRestaurant), HttpStatus.OK);
} else {
return ResponseEntity.notFound().build();
}
}

 @RequestMapping(value = "/eatily/users/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<restaurants> deleteRestaurant(@PathVariable(value = "id") Long id) {
  Optional<restaurants> restaurant = this.repository.findById(id);
  if (restaurant.isPresent()) {
   this.repository.delete(restaurant.get());
   return new ResponseEntity("Restaurant has been deleted successfully.", HttpStatus.OK);
  } else {
   return ResponseEntity.notFound().build();
  }
 }

}
