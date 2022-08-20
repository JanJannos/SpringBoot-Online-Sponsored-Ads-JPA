package com.corporate.onlinesponsoredads.converter;

import com.corporate.onlinesponsoredads.dto.ProductDTO;
import com.corporate.onlinesponsoredads.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductEntity convertDTOtoEntity(ProductDTO productDTO) {
        // Below is Adapter Design Pattern
        ProductEntity pe = new ProductEntity();
        pe.setTitle(productDTO.getTitle());
        pe.setCategory(productDTO.getCategory());
        pe.setPrice(productDTO.getPrice());
        pe.setSerialNumber(productDTO.getSerialNumber());
        return pe;
    }

    public ProductDTO convertEntitytoDTO(ProductEntity productEntity) {
        // Below is Adapter Design Pattern
        ProductDTO prop = new ProductDTO();
        prop.setId(productEntity.getId());
        prop.setPrice(productEntity.getPrice());
        prop.setTitle(productEntity.getTitle());
        prop.setCategory(productEntity.getCategory());
        prop.setSerialNumber(productEntity.getSerialNumber());
        return prop;
    }
}
