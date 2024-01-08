package com.crs.carrentalsystem.rental.controller;
import com.crs.carrentalsystem.rental.controller.assembler.RentalAssembller;
import com.crs.carrentalsystem.rental.controller.dto.RentalDto;
import com.crs.carrentalsystem.rental.controller.dto.RentalSearchDto;
import com.crs.carrentalsystem.rental.entity.Rental;
import com.crs.carrentalsystem.rental.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/rentals")
public class RentalController {
        private final RentalService rentalService;
        private final RentalAssembller rentalAssembler;
        @ResponseStatus(HttpStatus.OK)
        @PostMapping
        public RentalDto create(@RequestBody  RentalDto rentalDto){
            return rentalAssembler.torentalDto(rentalService.create(rentalDto));
        }
        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public  RentalDto getById(@PathVariable long id) {

            return rentalAssembler.torentalDto(rentalService.getById(id));
        }
        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public  RentalDto update(@PathVariable long id, @RequestBody  @Valid  RentalDto request) {
            if (id != request.getId()) {
                throw new RuntimeException("Path ID does not match DTO value");
            }
            Rental updatedRentals = rentalService.Update(request);
            return rentalAssembler.torentalDto(updatedRentals);

        }
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable("id") long id) {
            rentalService.delete(id);
        }
        @PostMapping ("/search")
        @ResponseStatus(HttpStatus.OK)
        public Page<RentalDto> search(@RequestBody RentalSearchDto  rentalSearchDto, Pageable pageable) {
            return rentalService.search(rentalSearchDto, pageable)
                    .map(rentalAssembler::torentalDto);
        }
}
