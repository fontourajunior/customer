package br.com.una.customer.customer.repository;

import br.com.una.customer.customer.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
