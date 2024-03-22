package space.springbok.breweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import space.springbok.breweryclient.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDTO dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        // Given
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("John Spangenberg")
                .build();
        URI uri = client.saveNewCustomer(customerDTO);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("John Spangenberg")
                .build();
        client.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}
