package com.laboon.whitepaw.pawcommon.response;

import com.laboon.whitepaw.pawcommon.constants.Constants;
import lombok.Data;


@Data
public class ApiSuccessResponse extends ApiResponse {
    private Object data;

    public ApiSuccessResponse() {
        this.status = Constants.API_SUCCESS_STATUS;
    }

    public static <T> ApiResponse of (T data) {
        ApiSuccessResponse response = new ApiSuccessResponse();
        response.setData(data);
        return response;
    }
}