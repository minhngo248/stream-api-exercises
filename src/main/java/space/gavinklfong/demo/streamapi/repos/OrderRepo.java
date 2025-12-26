package space.gavinklfong.demo.streamapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {

	List<Order> findAll();

	@Query("Select o FROM Order o JOIN FETCH o.products p WHERE p.category ='Baby'")
	List<Order> exercise2();
}
