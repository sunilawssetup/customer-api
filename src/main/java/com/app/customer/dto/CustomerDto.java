package com.app.customer.dto;

import com.app.customer.util.AppConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Schema(
        description = "Holds customer data"
)
@Data
@ToString
public class CustomerDto {

    @Schema(description = "Customer id ,example=123")
    private Long customerId;

    @Pattern(regexp = "(^$|[0-9]{10})",message = AppConstant.VALID_MOBILE_NUMBER)
    @Schema(description = "mobile number ,example=9999999999")
    private String mobile;
    @Schema(description = "first name ,example=abc")

    @NotBlank(message = AppConstant.VALID_FIRST_NAME_NOT_BLANK)
    @Size(min = 4,max = 10,message = AppConstant.VALID_FIRST_NAME_SIZE)
    private String fName;

    @NotBlank(message = AppConstant.VALID_LAST_NAME_NOT_BLANK)
    @Size(min = 4,max = 10,message = AppConstant.VALID_LAST_NAME_SIZE)
    @Schema(description = "last name ,example=xyz")
    private String lName;


    @Size(min = 1,max = 1,message = "")
    @Schema(description = "gender ,example=male/female")
    private String gender;

    List<AddressDto>addressDtos;

}
