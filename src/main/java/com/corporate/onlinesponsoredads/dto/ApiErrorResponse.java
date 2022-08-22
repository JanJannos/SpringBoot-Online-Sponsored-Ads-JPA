package com.corporate.onlinesponsoredads.dto;

public class ApiErrorResponse extends Throwable {
    private final String error;
    public ApiErrorResponse(String error){
        this.error = error;
    }
    public String getError(){
        return this.error;
    }
}
