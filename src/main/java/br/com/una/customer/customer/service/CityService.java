package br.com.una.customer.customer.service;

import br.com.una.customer.customer.dto.CityDTO;
import br.com.una.customer.customer.exception.BusinessException;
import br.com.una.customer.customer.exception.NotFoundException;
import br.com.una.customer.customer.model.City;
import br.com.una.customer.customer.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    CityRepository repository;

    public Integer create(CityDTO cityDTO) {
        City city = new City(cityDTO.getName(), cityDTO.getState());

        return repository.save(city).getId();
    }

    public CityDTO findOne(Integer id) throws Exception {
        City city = findById(id);
        return new CityDTO(city.getId(), city.getName(), city.getState());
    }

    public List<CityDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(city -> new CityDTO(city.getId(), city.getName(), city.getState()))
                .collect(Collectors.toList());
    }

    public void update(Integer id, CityDTO cityDTO) throws Exception {
        City city = findById(id);
        city.setName(cityDTO.getName());
        city.setState(cityDTO.getState());
        repository.save(city);
    }

    public void delete(Integer id) throws NotFoundException, BusinessException {
        findById(id);
        repository.deleteById(id);
    }

    private City findById(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
