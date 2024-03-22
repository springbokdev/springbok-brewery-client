package space.springbok.breweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import space.springbok.breweryclient.web.model.BeerDTO;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "springbok.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + "/" + uuid.toString(), BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO) {
        URI uri = restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDTO);
        return uri;
    }

    public void updateBeer(UUID uuid, BeerDTO beerDTO) {
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid.toString(), beerDTO);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
