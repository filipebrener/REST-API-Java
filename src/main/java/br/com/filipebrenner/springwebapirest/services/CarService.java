package br.com.filipebrenner.springwebapirest.services;

import br.com.filipebrenner.springwebapirest.exceptions.CarNotFoundException;
import br.com.filipebrenner.springwebapirest.model.Car;
import br.com.filipebrenner.springwebapirest.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {

    CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Long id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) return car.get();
        throw new CarNotFoundException(id);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

}
