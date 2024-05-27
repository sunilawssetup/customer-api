package com.app.customer.dto;


import com.app.customer.util.AppConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        description = "It holds addressed information"
)
public class AddressDto {
    @Schema(description = "unique id ,example=1234")
    private Long addressId;
    @Schema(description = "address of with flat no and , example=flatno 111,newyork, ")
    private String add;
    @Schema(description = "street , example=road,landmark")
    private String street;

    @Schema(description = "street , example=road,landmark")
    @NotBlank(message = AppConstant.VALID_CITY_NAME_NOT_BLANK)
    @Size(min = 4, max = 10,message =AppConstant.VALID_CITY_NAME_SIZE )
    private String city;
    @Schema(description = "city , example=xyz")

    @Pattern(regexp = "^[1-9][0-9]{5}$",message = AppConstant.VALID_PIN_NUMBER)
    private String pin;
    @Schema(description = "pin , example=122334")
    private String state;
    @Schema(description = "active , example=true/false")
    private Boolean active;
}
