package space.gavinklfong.demo.streamapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;

@DataJpaTest
public class RepositoriesTest {
    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void testOrderRepo() {
        System.out.println(orderRepo.findAll());
    }
}
