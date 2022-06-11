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

import ch.zhaw.springboot.entities.Menu;
import ch.zhaw.springboot.repositories.MenuRepository;

@RestController

public class MenuRestController {
	
	@Autowired
	private MenuRepository repository;
	
	@RequestMapping(value="/eatily/Menu", method=RequestMethod.GET)
	public ResponseEntity <List<Menu>> getMenu(){
		
		List<Menu> result = this.repository.findAll();
		
		if(result.isEmpty()) {
			return new ResponseEntity<List<Menu>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Menu>>(result, HttpStatus.OK);
	}
	

@RequestMapping(value = "/eatily/Menu/{id}", method = RequestMethod.GET)
public ResponseEntity <Menu> getMenu(@PathVariable("id") long id) {
	Optional<Menu> result = this.repository.findById(id);
	
	if(result.isEmpty()) {
		return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Menu>(result.get(), HttpStatus.OK);
}

@RequestMapping(value = "/eatily/menu", method = RequestMethod.POST)
public ResponseEntity<Menu> createPerson(@RequestBody Menu menu) {
Menu result = this.repository.save(menu);
return new ResponseEntity<Menu>(result, HttpStatus.OK);
}

@RequestMapping(value = "/eatily/Menu", method = RequestMethod.POST)
public ResponseEntity<Menu> createMenu(@RequestBody Menu Menu) {
Menu result = this.repository.save(Menu);
return new ResponseEntity<Menu>(result, HttpStatus.OK);
}

@RequestMapping(value = "/eatily/Menu/{id}", method = RequestMethod.PUT)
public ResponseEntity<Menu> updateMenu(@PathVariable(value = "id") Long id, @RequestBody Menu newMenu) {
Optional<Menu> Menu = this.repository.findById(id);

if (Menu.isPresent()) {
Menu me = Menu.get();
me.setName(newMenu.getName());
me.setPreis(newMenu.getPreis());
System.out.println(me);

Menu updatedMenu = this.repository.save(me);
return new ResponseEntity<Menu>((updatedMenu), HttpStatus.OK);
} else {
return ResponseEntity.notFound().build();
}
}

@RequestMapping(value = "/eatily/Menu/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Menu> deleteMenu(@PathVariable(value = "id") Long id) {
Optional<Menu> stani = this.repository.findById(id);
if (stani.isPresent()) {
this.repository.delete(stani.get());
return new ResponseEntity("Menu has been deleted successfully.", HttpStatus.OK);
} else {
return ResponseEntity.notFound().build();
}
}

}