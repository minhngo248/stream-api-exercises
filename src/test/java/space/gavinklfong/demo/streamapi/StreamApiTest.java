package space.gavinklfong.demo.streamapi;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import javax.persistence.criteria.CriteriaBuilder;

@Slf4j
@DataJpaTest
public class StreamApiTest {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	private ExerciseStreamApi exerciseStreamApi;

	@BeforeEach
	void setUp() {
		exerciseStreamApi = new ExerciseStreamApi(customerRepo,
				orderRepo, productRepo);
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise1() {
		List<Product> expected = productRepo.exercise1();
		System.out.println(expected);
		List<Product> result = exerciseStreamApi.exercise1();
		System.out.println(result);
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
	public void exercise1a() {
		List<Product> expected = productRepo.exercise1();
		List<Product> result = exerciseStreamApi.exercise1a();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
	public void exercise1b() {
		List<Product> expected = productRepo.exercise1();
		List<Product> result = exerciseStreamApi.exercise1b();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Obtain a list of order with product category = \"Baby\"")
	public void exercise2() {
		List<Order> expected = orderRepo.exercise2();
		List<Order> result = exerciseStreamApi.exercise2();
		Assertions.assertEquals(expected.size(), result.size());
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
	public void exercise3() {
		List<Product> expected = productRepo.exercise3();
		List<Product> result = exerciseStreamApi.exercise3();
		Assertions.assertEquals(expected.size(), result.size());
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
	public void exercise4() {
		List<Product> expected = productRepo.exercise4();
		List<Product> result = exerciseStreamApi.exercise4();
		Assertions.assertEquals(expected.size(), result.size());
		expected.forEach(p ->
				Assertions.assertTrue(result.contains(p))
		);
	}

	@Test
	@DisplayName("Get the 3 cheapest products of \"Books\" category")
	public void exercise5() {
		List<Product> expected = productRepo.exercise5().stream().limit(3).collect(Collectors.toList());
		List<Product> result = exerciseStreamApi.exercise5();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Get the 3 most recent placed order")
	public void exercise6() {
		List<Order> expected = orderRepo.exercise6().stream().limit(3).collect(Collectors.toList());
		List<Order> result = exerciseStreamApi.exercise6();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Get a list of products which was ordered on 15-Mar-2021")
	public void exercise7() {
		List<Product> expected = productRepo.exercise7();
		List<Product> result = exerciseStreamApi.exercise7();
		Assertions.assertEquals(expected.size(), result.size());
		expected.forEach(p ->
			Assertions.assertTrue(result.contains(p))
		);
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021")
	public void exercise8() {
		Double expected = orderRepo.exercise8();
		Double result = exerciseStreamApi.exercise8();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)")
	public void exercise8a() {
		Double expected = orderRepo.exercise8();
		Double result = exerciseStreamApi.exercise8a();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
	public void exercise9() {
		Double expected = orderRepo.exercise9();
		Double result = exerciseStreamApi.exercise9();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
	public void exercise10() {
		Integer count = productRepo.exercise10Count();
		Double sum = productRepo.exercise10Sum();
		Double min = productRepo.exercise10Min();
		Double max = productRepo.exercise10Max();
		DoubleSummaryStatistics expected = new DoubleSummaryStatistics(count, min, max, sum);
		DoubleSummaryStatistics result = exerciseStreamApi.exercise10();
		Assertions.assertEquals(expected.toString(), result.toString());
	}

	@Test
	@DisplayName("Obtain a mapping of order id and the order's product count")
	public void exercise11() {
		Map<Long, Integer> expected = orderRepo.exercise11().stream()
				.collect(Collectors.toMap(
						row -> (Long) row[0],
						row -> ((Long) row[1]).intValue()
				));
		Map<Long, Integer> result = exerciseStreamApi.exercise11();
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Obtain a data map of customer and list of orders")
	public void exercise12() {
	}

	@Test
	@DisplayName("Obtain a data map of customer_id and list of order_id(s)")
	public void exercise12a() {
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price")
	public void exercise13() {
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price (using reduce)")
	public void exercise13a() {
	}

	@Test
	@DisplayName("Obtain a data map of product name by category")
	public void exercise14() {
	}

	@Test
	@DisplayName("Get the most expensive product per category")
	void exercise15() {
	}

	@Test
	@DisplayName("Get the most expensive product (by name) per category")
	void exercise15a() {
	}

}