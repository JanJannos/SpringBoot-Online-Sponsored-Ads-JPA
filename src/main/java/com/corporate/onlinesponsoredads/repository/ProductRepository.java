package com.corporate.onlinesponsoredads.repository;

import com.corporate.onlinesponsoredads.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity findFirstByCategoryAndId(String category , Long id);
}
