package com.laboon.whitepaw.pawcommon.response;


import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ApiResponse extends RepresentationModel<ApiResponse> {
    protected String status;

}
