package com.laboon.whitepaw.pawcommon.response;

import com.laboon.whitepaw.pawcommon.config.Constants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse extends ApiResponse {
    private Object data;

    public ApiErrorResponse() {
        this.status = Constants.API_ERROR_STATUS;
    }

    public static <T> ApiErrorResponse of(T data) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setData(data);
        return response;
    }
}
