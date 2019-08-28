package application.controller;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import application.dao.ProductDao;
import application.exceptions.ProduitIntrouvableException;
import application.model.Produit;
import application.model.User;
import io.swagger.annotations.ApiOperation;
//lorsqu'on tente d'acceder à la page d'acceuil c'est cette methode qui va etre executer
	//@GetMapping("/")
	//pour  dire au serveur d'afficher le contenu de la methode comme contenu du page et non pas chercher une page html avec le nom hello!!
	//@ResponseBody
//annotation spring mvc replace @cotroller et @ResponseBody et permet d   indiquer que cette classe est un cotrolleur qui revoit des reponses json et non pas des vues car c'est un api 
@CrossOrigin 
@RestController
public class ProductController {
	//Spring se charge d'en fabriquer une instance inject une instance de l'interface dao
	 @Autowired
	  private ProductDao productDao;
	 
	
    @RequestMapping(value="/Produits", method=RequestMethod.GET)
    @ApiOperation(value = "show all the products  in the database",
	 notes="",
	 response=Produit.class)
    public List<Produit> listeProduits() {

        List<Produit> produits = productDao.findAll();

      

        return produits;
    }
    
    /*public List<Produit> listeProduits() {
        return productDao.findAll() ;
    }*/
    
   @GetMapping(value="/Produits/{id}")
   @ApiOperation(value = "show  the product witch the id was specified",
	 notes="provide the id or the matricule of the product you want to show",
	 response=Produit.class)
    public Produit getProduitById(@PathVariable int id) {

    	 
    			Produit produit =productDao.findById(id); 
    			 if(produit==null) throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");

    		       return produit;
    }
   

 @GetMapping(value = "/FindProduits/{nom}")
 @ApiOperation(value = "show  the product witch the name was specified",
 notes="provide the nameor the matricule of the product you want to show",
 response=Produit.class)
   public List<Produit> getProduitByName(@PathVariable ("nom") String nom) {
      
    		   List<Produit> produit =productDao.findByNom(nom);
    		   return produit;
   }
 


 
 
  //ajouter un produit
   @PostMapping(value = "/Produits")
   @ApiOperation(value = "add a product to the database",
	 notes="provide the name,prix and the quantity  of the product you want to add",
	 response=Produit.class)
    public ResponseEntity<Void> ajouterProduit(@Valid  @RequestBody Produit product) {
         //productDao.save(product);
    	  Produit productAdded =  productDao.save(product);

          if (productAdded == null)
              return ResponseEntity.noContent().build();

          URI location = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(productAdded.getId())
                  .toUri();

          return ResponseEntity.created(location).build();
      }
   
   @DeleteMapping (value = "/Produits/{id}")
   @ApiOperation(value = "delete the product witch the id was specified",
	 notes="provide the id or the matricule of the product you want to delete",
	 response=Produit.class)
   public void supprimerProduit(@PathVariable int id) {

       productDao.delete(id);
   }
   
   @PutMapping (value = "/EditProduits")
   @ApiOperation(value = "update the product witch the id was specified",
	 notes="provide the id or the matricule of the product you want to update",
	 response=Produit.class)
   public Produit updateProduit(@RequestBody Produit product) {

       Produit p=productDao.save(product);
       return p;
   }
   
   
 
  @GetMapping(value = "test/produits/{prix}")
  @ApiOperation(value = "show  the product witch the prix greater thant the number you specified",
	 notes="provide the prix you want to sorte by it ",
	 response=Produit.class)
   public List<Produit> chercherProduitPrixPlusGrand(@PathVariable int prix){
	return productDao.chercherUnProduitCher(prix);
  } 
  //fait la meme chose que la precedente sauf que la 2 eme est autogenerée par spring data et la 1 ere execute   une requette personalisé dans dao
  /* @GetMapping(value = "test/produits/{prixLimit}")
  public List<Produit> getProduitPrixPlusGrand(@PathVariable int prixLimit) {
      return productDao.findByPrixGreaterThan(prixLimit);
  }
   */

   

}
