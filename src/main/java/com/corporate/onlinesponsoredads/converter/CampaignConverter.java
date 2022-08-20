package com.corporate.onlinesponsoredads.converter;

import com.corporate.onlinesponsoredads.dto.CampaignDTO;
import com.corporate.onlinesponsoredads.dto.ProductDTO;
import com.corporate.onlinesponsoredads.entity.CampaignEntity;
import com.corporate.onlinesponsoredads.entity.ProductEntity;
import com.corporate.onlinesponsoredads.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampaignConverter {
    @Autowired
    private ProductRepository productRepository;

    public CampaignEntity convertDTOtoEntity(CampaignDTO campaignDTO) {
        // Below is Adapter Design Pattern
        CampaignEntity pe = new CampaignEntity();
        pe.setStartingDate(campaignDTO.getStartingDate());
        pe.setName(campaignDTO.getName());
        pe.setBid(campaignDTO.getBid());
        // list of ids
        List<Long> items = campaignDTO.getProducts();

        // find all entities from this list
        List<ProductEntity> productsList = (List<ProductEntity>) productRepository.findAllById(items);
        System.out.println(productsList);

        // set the entities
         pe.setProducts(productsList);
        return pe;
    }

        public CampaignDTO convertEntitytoDTO(CampaignEntity campaignEntity) {
            // Below is Adapter Design Pattern
            CampaignDTO campaignDTO = new CampaignDTO();
            campaignDTO.setId(campaignEntity.getId());
            campaignDTO.setBid(campaignEntity.getBid());
            campaignDTO.setName(campaignEntity.getName());
            campaignDTO.setStartingDate(campaignEntity.getStartingDate());
            // campaignDTO.setSerialNumber(campaignEntity.getSerialNumber());
            return campaignDTO;
        }
}
