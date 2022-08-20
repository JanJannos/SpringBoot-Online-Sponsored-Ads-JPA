package com.corporate.onlinesponsoredads.services;

import com.corporate.onlinesponsoredads.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
}
