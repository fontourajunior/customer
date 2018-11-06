package br.com.una.customer.customer.service;

import br.com.una.customer.customer.dto.CityDTO;
import br.com.una.customer.customer.dto.CustomerDTO;
import br.com.una.customer.customer.exception.BusinessException;
import br.com.una.customer.customer.exception.NotFoundException;
import br.com.una.customer.customer.model.City;
import br.com.una.customer.customer.model.Customer;
import br.com.una.customer.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    CityService cityService;

    public Integer create(CustomerDTO customerDTO) throws Exception {
        City city = cityService.findById(customerDTO.getCityId());

        Customer customer = new Customer(customerDTO.getName(),
                                         city,
                                         customerDTO.getPhone(),
                                         customerDTO.getPublicPlace(),
                                         customerDTO.getNumber(),
                                         customerDTO.getNeighborhood(),
                                         customerDTO.getCep(),
                                         customerDTO.getCpf(),
                                         customerDTO.getEmail(),
                                         customerDTO.getGenre(),
                                         customerDTO.getBirth());

        return repository.save(customer).getId();
    }

    public CustomerDTO findOne(Integer id) throws Exception {
        Customer customer = findById(id);
        return buildToCustomerDTO(customer);
    }

    public List<CustomerDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::buildToCustomerDTO)
                .collect(Collectors.toList());
    }

    public void update(Integer id, CustomerDTO customerDTO) throws Exception {

        City city = cityService.findById(customerDTO.getCityId());

        Customer customer = findById(id);
        customer.setName(customerDTO.getName());
        customer.setBirth(customerDTO.getBirth());
        customer.setCep(customerDTO.getCep());
        customer.setCity(city);
        customer.setEmail(customerDTO.getEmail());
        customer.setGenre(customerDTO.getGenre());
        customer.setNeighborhood(customerDTO.getNeighborhood());
        customer.setNumber(customerDTO.getNumber());

        repository.save(customer);
    }

    public void delete(Integer id) throws NotFoundException, BusinessException {
        findById(id);
        repository.deleteById(id);
    }

    private CustomerDTO buildToCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getId(),
                               customer.getName(),
                               customer.getPhone(),
                               customer.getCity().getId(),
                               customer.getPublicPlace(),
                               customer.getNumber(),
                               customer.getNeighborhood(),
                               customer.getCep(),
                               customer.getCpf(),
                               customer.getEmail(),
                               customer.getGenre(),
                               customer.getBirth());
    }

    private Customer findById(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
