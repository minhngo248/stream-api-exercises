package space.gavinklfong.demo.streamapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Learn how to use Java 8 Stream API
 *
 * @author Minh Ngo
 */
@Component
@RequiredArgsConstructor
public class ExerciseStreamApi {
    private final CustomerRepo customerRepo;

    private final OrderRepo orderRepo;

    private final ProductRepo productRepo;

    public List<Product> exercise1() {
        // TODO: Obtain a list of product with category = "Books" and price > 100
    }

    public List<Product> exercise1a() {
        // TODO: Obtain a list of product with category = "Books" and 
        //  price > 100 (using Predicate chaining for filter)
    }

    public List<Product> exercise1b() {
        // TODO: Obtain a list of product with category = "Books" and price > 100 (using BiPredicate for filter)
    }

    public List<Order> exercise2() {
        // TODO: Obtain a list of order with product category = "Baby"
    }

    public List<Product> exercise3() {
        // TODO: Obtain a list of product with category = "Toys" and then apply 10% discount
    }

    public List<Product> exercise4() {
        // TODO: Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    }

    public List<Product> exercise5() {
        // TODO: Get the 3 cheapest products of "Books" category
    }

    public List<Order> exercise6() {
        // TODO: Get the 3 most recent placed order
    }

    public List<Product> exercise7() {
        // TODO: Get a list of products which was ordered on 15-Mar-2021
    }

    public Double exercise8() {
        // TODO: Calculate the total lump of all orders placed in Feb 2021
    }

    public Double exercise8a() {
        // TODO: Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)
    }

    public Double exercise9() {
        // TODO: Calculate the average price of all orders placed on 15-Mar-2021
    }

    public DoubleSummaryStatistics exercise10() {
        // TODO: Obtain statistics summary of all products belong to "Books" category
    }

    public Map<Long, Integer> exercise11() {
        // TODO: Obtain a mapping of order id and the order's product count
    }

    public void exercise12() {
        // TODO: Obtain a data map of customer and list of orders
    }

    public void exercise12a() {
        // TODO: Obtain a data map of customer_id and list of order_id(s)
    }

    public void exercise13() {
        // TODO: Obtain a data map with order and its total price
    }

    public void exercise13a() {
        // TODO: Obtain a data map with order and its total price (using reduce)
    }

    public void exercise14() {
        // TODO: Obtain a data map of product name by category
    }

    public void exercise15() {
        // TODO: Get the most expensive product per category
    }

    public void exercise15a() {
        // TODO: Get the most expensive product (by name) per category
    }
}