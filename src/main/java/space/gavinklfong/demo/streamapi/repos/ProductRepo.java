package space.gavinklfong.demo.streamapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import space.gavinklfong.demo.streamapi.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

	List<Product> findAll();

	@Query("SELECT p FROM Product p WHERE p.category = 'Books' and p.price > 100")
	List<Product> exercise1();

	@Modifying
	@Query("UPDATE FROM Product p SET p.price = 0.9*p.price WHERE p.category ='Toys'")
	List<Product> exercise3();

	@Query("SELECT DISTINCT p FROM Product p JOIN p.orders o WHERE o.customer.tier = 2 AND o.orderDate >= '2021-02-01' AND o.orderDate < '2021-04-01'")
	List<Product> exercise4();
}
