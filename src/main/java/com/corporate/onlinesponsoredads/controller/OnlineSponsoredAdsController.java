package com.corporate.onlinesponsoredads.controller;

import com.corporate.onlinesponsoredads.dto.ProductDTO;
import com.corporate.onlinesponsoredads.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/online-sponsored-ads/api/v1")
public class OnlineSponsoredAdsController {
    // http://localhost:8080/online-sponsored-ads/api/v1/health

    @Autowired
    private ProductService productService;

    @GetMapping("/health")
    public String SayHello() {
        return "Backend is up!";
    }


    @PostMapping("/products")
    public ResponseEntity<ProductDTO> saveProperty(@RequestBody ProductDTO productDTO) {
        productDTO = productService.saveProduct(productDTO);
        ResponseEntity<ProductDTO> responseEntity = new ResponseEntity<>(productDTO , HttpStatus.CREATED);
        return responseEntity; // return 201
    }
}
