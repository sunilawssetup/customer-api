package com.app.customer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Schema(
        description = "Holds Error Data"
)
@Builder
public class ErrorResponseDto {
    @Schema(description = "error path,example=/xyz/demo")
    private  String errorPath;
    @Schema(description = "api status,example=like,200,201,")
    private HttpStatus status;
    @Schema(description = "error description example when we get message from exactly faceing error/or exception")
    private String errorDescription;
    @Schema(description = "date time example when we get exception occure will recorded time ")
    private LocalDateTime localDateTime;
}
