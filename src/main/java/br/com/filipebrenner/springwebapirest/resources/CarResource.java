package br.com.filipebrenner.springwebapirest.resources;

import br.com.filipebrenner.springwebapirest.exceptions.CarNotFoundException;
import br.com.filipebrenner.springwebapirest.model.Car;
import br.com.filipebrenner.springwebapirest.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CarResource {

    CarRepository carRepository;

    @GetMapping("/car")
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @PostMapping("/car")
    public Car saveCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable Long id) throws CarNotFoundException{
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) return car.get();
        throw new CarNotFoundException(id);
    }

    @DeleteMapping("car/{id}")
    public void deleteCar(@PathVariable Long id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) {
            carRepository.delete(car.get());
        } else throw new CarNotFoundException(id);
    }

    @PostMapping("/car/up/{id}")
    public Car updateCarById(@RequestBody Car newCar, @PathVariable Long id) throws CarNotFoundException {
        Optional<Car> oldCar = carRepository.findById(id);
        if(oldCar.isPresent()) {
            carRepository.delete(oldCar.get());
            newCar.setId(id);
            return carRepository.save(newCar);
        }
        else throw new CarNotFoundException(id);
    }

}
