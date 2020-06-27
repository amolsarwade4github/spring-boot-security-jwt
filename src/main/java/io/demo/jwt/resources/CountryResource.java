package io.demo.jwt.resources;

import io.demo.jwt.model.Country;
import io.demo.jwt.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryResource {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Country> countries =  countryService.getCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") int id) {
        Country country = countryService.getCountry(id);
        return ResponseEntity.ok(country);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Country country) {
        Country country1 = countryService.add(country);
        return ResponseEntity.ok(country1);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> modify(@PathVariable("id") int id, @RequestBody Country country) {
        Country country1 = countryService.getCountry(id);
        if (country1 != null) {
            Country country2 = countryService.update(id, country);
            return ResponseEntity.ok(country2);
        }
        return null;
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Country country = countryService.delete(id);
        return ResponseEntity.ok(country);
    }


}
