package br.com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.User;


@Repository
public interface UserRepositoy extends JpaRepository<User, String> {

	@Query(value = "SELECT u FROM User u WHERE u.username = :username")
	User findUserByName(@Param("username") String username);

}
