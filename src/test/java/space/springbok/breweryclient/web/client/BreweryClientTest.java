package space.springbok.breweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import space.springbok.breweryclient.web.model.BeerDTO;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;
    @Test
    void getBeerById() {
        BeerDTO dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }
    @Test
    void testSaveNewBeer() {
        // Given
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("New Beer")
                .build();
        URI uri = client.saveNewBeer(beerDTO);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("New Beer")
                .build();
        client.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}