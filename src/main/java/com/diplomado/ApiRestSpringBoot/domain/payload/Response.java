package com.diplomado.ApiRestSpringBoot.domain.payload;

import lombok.Data;

import java.util.Date;
@Data
public class Response {
    private String massege;
    private Date timestamp;
    private String details;
    private String httpCodeMessage;

    public Response(String massege, Date timestamp, String details, String httpCodeMessage) {
        super();
        this.massege = massege;
        this.timestamp = timestamp;
        this.details = details;
        this.httpCodeMessage = httpCodeMessage;
    }
}
