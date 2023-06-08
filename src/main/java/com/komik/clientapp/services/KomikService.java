package com.komik.clientapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.komik.clientapp.models.Komik;

@Service
public class KomikService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.baseUrl}/komik")
    private String url;

    public List<Komik> getAll() {
        return restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Komik>>() {
                }).getBody();
    }

    public Komik getById(int id) {
        return restTemplate.exchange(
                url.concat("/" + id), HttpMethod.GET, null, new ParameterizedTypeReference<Komik>() {
                }).getBody();
    }

    public Komik create(Komik komik) {
        return restTemplate.exchange(
                url, HttpMethod.POST, new HttpEntity(komik), Komik.class).getBody();
    }

    public Komik update(int id, Komik komik) {
        return restTemplate.exchange(
                url.concat("/" + id), HttpMethod.PUT, new HttpEntity(komik), Komik.class).getBody();
    }

    public Komik delete(int id) {
        return restTemplate.exchange(url.concat("/" + id), HttpMethod.DELETE, null, Komik.class).getBody();
    }
}
