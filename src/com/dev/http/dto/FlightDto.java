package com.dev.http.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Value;

//@AllArgsConstructor
//@Getter
//@EqualsAndHashCode
//@ToString
//@Data

@Value
@Builder
public class FlightDto {

    Long id;
    String description;

}
