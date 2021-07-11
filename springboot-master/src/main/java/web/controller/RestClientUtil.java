package web.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import web.model.Book;
import web.model.Customer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class RestClientUtil {

    public void getBookDemoABC() throws URISyntaxException {
        URI uri = new URI("http://localhost:8081/bookABC");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book[]> resEntity = restTemplate.getForEntity(uri, Book[].class);
        System.out.println(resEntity.getStatusCode());
        for (Book b : resEntity.getBody()) {
            System.out.println(b);
        }
    }

    public void getBookDemoXYZ() throws URISyntaxException {
        URI uri = new URI("http://localhost:8081/bookXYZ");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        RequestEntity<List<Book>> reqEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ParameterizedTypeReference<List<Book>> typeRef = new ParameterizedTypeReference<List<Book>>() {
        };
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Book>> resEntity = restTemplate.exchange(reqEntity, typeRef);
        System.out.println(resEntity.getStatusCode());
        for (Book b : resEntity.getBody()) {
            System.out.println(b);
        }
    }

    public static void main(String args[]) throws URISyntaxException {
        RestClientUtil util = new RestClientUtil();
        util.getBookDemoABC();
        util.getBookDemoXYZ();
    }
}