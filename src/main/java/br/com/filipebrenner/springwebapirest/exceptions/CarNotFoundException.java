package br.com.filipebrenner.springwebapirest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car not found")
public class CarNotFoundException extends Exception {

    private final Long id;

    public CarNotFoundException(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarNotFoundException: There is no car with id: " + id + " ";
    }
}
