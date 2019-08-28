package application.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; 
import org.springframework.stereotype.Repository;

import application.model.Produit;
@Repository
//jparepository prend deux generique type la classe entité sur la quel s'applique les methode et le type de id de la classe
//jparepository provide des fctionalité de crudrepository et autre fctionalité
public interface ProductDao extends JpaRepository<Produit, Integer>{

	public List<Produit> findAll();
    public Produit findById(int id);
    
    public Produit save(Produit product);
    List<Produit> findByPrixGreaterThan(int prixLimit);
    List<Produit> findByNom(String nom);
    
    @Query("SELECT id , nom , prix AS prix FROM Produit p WHERE p.prix > :prixLimit")
    List<Produit>  chercherUnProduitCher(@Param("prixLimit") int prix);
  //  @Query("update nom , prix ,prix_achat FROM Produit p WHERE p.id like :idp ")
   // public Produit update(@Param("idp") int id);
}
