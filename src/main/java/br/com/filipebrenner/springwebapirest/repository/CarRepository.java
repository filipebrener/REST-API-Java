package br.com.filipebrenner.springwebapirest.repository;

import br.com.filipebrenner.springwebapirest.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository  extends JpaRepository<Car,Long> {

}
