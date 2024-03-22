package space.springbok.breweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import space.springbok.breweryclient.web.model.BeerDTO;
import space.springbok.breweryclient.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "springbok.brewery", ignoreUnknownFields = false)
@Component
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer";
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDTO getCustomerById(UUID uuid) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customerDTO) {
        URI uri = restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDTO);
        return uri;
    }

    public void updateCustomer(UUID uuid, CustomerDTO customerrDTO) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), customerrDTO);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

}
