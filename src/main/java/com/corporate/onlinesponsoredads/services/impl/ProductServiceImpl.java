package com.corporate.onlinesponsoredads.services.impl;

import com.corporate.onlinesponsoredads.converter.ProductConverter;
import com.corporate.onlinesponsoredads.dto.ProductDTO;
import com.corporate.onlinesponsoredads.entity.ProductEntity;
import com.corporate.onlinesponsoredads.repository.ProductRepository;
import com.corporate.onlinesponsoredads.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {


        ProductEntity pe = productConverter.convertDTOtoEntity(productDTO);
        pe = productRepository.save(pe);
        ProductDTO dto = productConverter.convertEntitytoDTO(pe);
        return dto;
    }
}
