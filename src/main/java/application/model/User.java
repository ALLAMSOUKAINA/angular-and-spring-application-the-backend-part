package application.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity
@ApiModel(description="Details about the user")
public class User implements Serializable {
	@ApiModelProperty(notes="the id of the user")
	@Id
	private String id; 

private String username;
	private String email;
private String password;
@ApiModelProperty(notes="set to identify if the user is successfully login or not")
private String active;
@ManyToMany
@JoinTable(name="USERS_ROLES")
private Collection<Role> role;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Collection<Role> getRole() {
	return role;
}
public void setRole(Collection<Role> role) {
	this.role = role;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String id,String username,String email, String password,String active, Collection<Role> role) {
	super();
	this.id=id;
	this.username = username;
	this.email=email;
	this.password = password;
	this.active=active;
	
	this.role = role;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getActive() {
	return active;
}
public void setActive(String active) {
	this.active = active;
}

	
}
