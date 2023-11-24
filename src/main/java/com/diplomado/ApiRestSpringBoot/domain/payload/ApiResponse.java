package com.diplomado.ApiRestSpringBoot.domain.payload;

import lombok.Data;

import java.util.Date;
@Data
public class ApiResponse {
    private Date timestamp = new Date();
    private String message;
    private String url;

    public ApiResponse(String message, String url) {
        this.message = message;
        this.url = url.replace("uri=","");
    }
}
