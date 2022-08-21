package com.corporate.onlinesponsoredads.repository;

import com.corporate.onlinesponsoredads.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity findFirstByCategoryAndId(String category , Long id);
}
