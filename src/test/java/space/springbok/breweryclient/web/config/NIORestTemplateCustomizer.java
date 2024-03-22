package space.springbok.breweryclient.web.config;


// TODO FIX this customizer

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

//@Component
public class NIORestTemplateCustomizer implements RestTemplateCustomizer {

//    public ClientHttpRequestFactory clientHttpRequestFactory() throws IOReactorShutdownException {
//        final DefaultConnectingIOReactor ioreactor = new DefaultConnectingIOReactor(IOReactorConfig.custom().
//              setSoTimeout(Timeout.ofMilliseconds(3000)).
//               // setConnectTimeout(3000).
//                setIoThreadCount(4).
//                setSoTimeout(3000).
//                build());
//
//        final PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(ioreactor);
//        connectionManager.setDefaultMaxPerRoute(100);
//        connectionManager.setMaxTotal(1000);
//
//        CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom()
//                .setConnectionManager(connectionManager)
//                .build();
//
//        return new HttpComponentsClientHttpRequestFactory();
//       // return new HttpComponentsAsyncClientHttpRequestFactory(httpAsyncClient);
//
//    }

    @Override
    public void customize(RestTemplate restTemplate) {
//        try {
//            restTemplate.setRequestFactory(clientHttpRequestFactory());
//        } catch (IOReactorException e) {
//            e.printStackTrace();
//        }
    }
}
