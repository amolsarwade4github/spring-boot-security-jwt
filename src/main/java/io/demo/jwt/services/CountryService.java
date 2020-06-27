package io.demo.jwt.services;

import io.demo.jwt.model.Country;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final Map<Integer, Country> COUNTRY_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        Country country = new Country();
        country.setId(1);
        country.setName("India");
        country.setCapital("Delhi");
        country.setPopulation(12400000);
        COUNTRY_MAP.put(country.getId(), country);
    }

    public Country getCountry(int id) {
        return COUNTRY_MAP.get(id);
    }

    public List<Country> getCountries() {
         return COUNTRY_MAP
                 .values()
                 .stream()
                 .collect(Collectors.toList());
    }

    public Country add(Country country) {
        country.setId(COUNTRY_MAP.size()+1);
        return COUNTRY_MAP.put(country.getId(), country);
    }

    public Country update(int id, Country country) {
        return COUNTRY_MAP.put(id, country);
    }

    public Country delete(int id) {
        return COUNTRY_MAP.remove(id);
    }
}
