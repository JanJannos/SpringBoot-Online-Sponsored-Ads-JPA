package com.corporate.onlinesponsoredads.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String title;
    private String category;
    private Double price;
    private String serialNumber;
}
