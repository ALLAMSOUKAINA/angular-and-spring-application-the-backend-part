package application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import application.model.Produit;
import application.model.User;

public interface UserDao extends JpaRepository<User, String> {
    public User save(User user);
    @Query("SELECT username FROM User u WHERE u.email like :em and u.password like :md")
    List<User> chercherUnutilisateur(@Param("em") String email,@Param("md") String password );
    User findByEmail(String email);
    User findByPassword(String password);


}
