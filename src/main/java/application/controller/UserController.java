package application.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import application.dao.UserDao;
import application.model.Produit;
import application.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@CrossOrigin 

@RestController
@RequestMapping(value="/User")
public class UserController {
	 @Autowired
	  private UserDao userDao;
	 
	 @PostMapping(value = "/add")
	 @ApiOperation(value = "add a new user to the application ",
	 notes="provide a  name,email,password id witch is role of the user",
	 response=User.class)
	    public Void ajouterUser(@RequestBody User user) {
	         //productDao.save(product);
	    	 userDao.save(user);
			return null;
	
	      }
	 
	 
	@GetMapping(value = "/login/{email}/{password}")
	 @ApiOperation(value = "manage the authentification process",
	 notes="use the email and the password to verify the authentification",
	 response=User.class)
	   public User login(@ApiParam(value="email  value for the user",required=true) @PathVariable String email,@ApiParam(value="password  value for the user",required=true) @PathVariable String password ) {
	         User user= userDao.findByEmail(email);
	         //User userp=userDao.findByPassword(password);
	    	 if (user.getPassword().equals(password)) {
	    		 user.setActive("active");
	    	 }
			return user;
	
	      }
	  @GetMapping
	  @ApiOperation(value = "show all the users accounts in the database",
		 notes="",
		 response=User.class)
	    public List<User> listeUsers() {

		  return  userDao.findAll();

	        
	      
	    }
	  
	/* @GetMapping(value = "/login/{username}")
	    public List<User> listeUsersEmail(@PathVariable String username ) {

		 //List<User> u= userDao.findByUsername(username);

	        
		 return u;
	    }*/
	    

}
