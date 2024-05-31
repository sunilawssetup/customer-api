package com.app.customer.controller;

import com.app.customer.dto.*;
import com.app.customer.service.ICustomer;
import com.app.customer.util.AppConstant;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CUSTOMER-API",
        description = "Customer api can help to the register on swiggy"

)
@RestController
@RequestMapping("/customer")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ICustomer serviceCustomer;


    @Operation(
            summary = "CREATE CUSTOMER",
            description = "adding customer this service"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http status Created"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)

                    )

            )
    }
    )
    @PostMapping("/save")
    public CustomerDto saveCustomer(@Valid @RequestBody CustomerDto customerDto) {
        logger.info("customer Dto{}", customerDto);
        return serviceCustomer.saveCustomer(customerDto);
    }

    @Operation(
            summary = "VIEW CUSTOMER",
            description = "view the customer detail on based on passing id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status is Ok",
            content = @Content(
                    schema = @Schema(implementation = CustomerDto.class)
            )
    )
    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable("customerId") Long customerId) {
        return serviceCustomer.getCustomer(customerId);

    }


    @Operation(
            summary = "UPDATE  CUSTOMER",
            description = "adding customer this service"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status Ok"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status internal server error",
                    content = @Content(

                    )

            )
    }
    )

    @PutMapping("/update")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
        return serviceCustomer.updateCustomer(customerDto);
    }

    @PostMapping("login/")
    @CircuitBreaker(name="listHotel",fallbackMethod = "loginFallback")
    public List<HotelDto> login(LoginDto loginDto){
       return serviceCustomer.loginUser(loginDto);
    }

    public List<HotelDto> loginFallback(LoginDto loginDto,Exception exception){

        return List.of(HotelDto.builder().
                hotelId(11L)
                        .hotelName("Dumy Hotel Name")
                        .description("is a dummy description")
                        .items(List.of(MenuDto.builder()
                                        .type(false)
                                        .price(200d)
                                        .menueId(12L)
                                        .description("i is dummy menu")
                                        .name("dummy menu name")
                                .build()))
                        .build()
                );
    }


}
