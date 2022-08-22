package com.corporate.onlinesponsoredads.dto;

public class ApiErrorResponse extends Throwable {
    private final String error;
    //Any addtional info you might later want to add to it
    public ApiErrorResponse(String error){
        this.error = error;
    }

    public String getError(){
        return this.error;
    }
}
