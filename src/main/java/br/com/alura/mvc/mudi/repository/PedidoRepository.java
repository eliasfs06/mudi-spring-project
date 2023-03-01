package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
		
	@Query(value = "SELECT p FROM Pedido p JOIN p.user u "
			+ "WHERE status = :status AND u.username = :username")
	List<Pedido> findByStatusAndUser(@Param("status") String status, @Param("username") String username);

	@Query(value = "SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
	List<Pedido> findAllByUser(@Param("username") String username);
	
	@Cacheable("pedidos")
	List<Pedido> findAllByStatus(StatusPedido status, Pageable pageable);
	
}
