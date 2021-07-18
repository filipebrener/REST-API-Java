package br.com.filipebrenner.springwebapirest.resources;

import br.com.filipebrenner.springwebapirest.exceptions.CarNotFoundException;
import br.com.filipebrenner.springwebapirest.model.Car;
import br.com.filipebrenner.springwebapirest.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarResource {

    CarService service;

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/car")
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        service.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) throws CarNotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("car/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id) throws CarNotFoundException {
        Car car = service.findById(id);
        service.delete(car);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/car")
    public ResponseEntity<Car> updateCarById(@RequestBody Car newCar) throws CarNotFoundException {
        Car car = service.findById(newCar.getId());
        return ResponseEntity.ok(service.save(newCar));
    }

}
