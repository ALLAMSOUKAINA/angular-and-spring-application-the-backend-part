package application.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;



//@JsonFilter("monFiltreDynamique")
@Entity
@ApiModel(description="Details about eatch product in the store")
@Table(name="produit")
public class Produit {
@Id
@Column(name="id" ,nullable = false)
@GeneratedValue
private int id;
//l'arg msg est facultatif pour personalisé le msg d'err c est on l'enleve on aura le msg d'err par defaut defini par spring pour ce type d'err
@Length(min=3, max=20, message = "Nom trop long ou trop court. Et oui messages sont plus stylés que ceux de Spring")
@Column(name="nom")
private String nom;
//@Min(value = 1)
@Column(name="prix")
private int prix;
@Column(name="quantity")
private int quantity;


public Produit() {
	
}



public Produit(int id, String nom, int prix, int quantity) {
    this.id = id;
    this.nom = nom;
    this.prix = prix;
    this.quantity = quantity;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
@Override
public String toString() {
	return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
}



public int getQuantity() {
	return quantity;
}



public void setQuantity(int quantity) {
	this.quantity = quantity;
}




}
