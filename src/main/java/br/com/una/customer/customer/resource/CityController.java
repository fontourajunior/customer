package br.com.una.customer.customer.resource;

import br.com.una.customer.customer.dto.CityDTO;
import br.com.una.customer.customer.model.City;
import br.com.una.customer.customer.repository.CityRepository;
import br.com.una.customer.customer.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CityDTO cityDTO) {

        Integer id = cityService.create(cityDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDTO> findOne(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok().body(cityService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        return ResponseEntity.ok().body(cityService.findAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CityDTO cityDTO, @PathVariable Integer id) throws Exception {
        cityService.update(id, cityDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delet(@PathVariable Integer id) throws Exception {
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
