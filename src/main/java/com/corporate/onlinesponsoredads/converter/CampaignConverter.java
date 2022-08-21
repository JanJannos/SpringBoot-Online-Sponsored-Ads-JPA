package com.corporate.onlinesponsoredads.converter;

import com.corporate.onlinesponsoredads.dto.CampaignDTO;
import com.corporate.onlinesponsoredads.entity.CampaignEntity;
import com.corporate.onlinesponsoredads.entity.ProductEntity;
import com.corporate.onlinesponsoredads.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampaignConverter {
    @Autowired
    private ProductRepository productRepository;

    public CampaignEntity convertDTOtoEntity(CampaignDTO campaignDTO) {
        // Below is Adapter Design Pattern
        CampaignEntity campaginEntity = new CampaignEntity();
        campaginEntity.setStartingDate(campaignDTO.getStartingDate());
        campaginEntity.setName(campaignDTO.getName());
        campaginEntity.setBid(campaignDTO.getBid());

        String commaSeparated = campaignDTO.getProducts();
        if(commaSeparated != null && !commaSeparated.trim().isEmpty()) {
            // find all entities from this list
            List<Long> parsedLongs = Arrays.asList(commaSeparated.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            List<ProductEntity> productsList = (List<ProductEntity>) productRepository.findAllById(parsedLongs);
            List<Long> filtered = productsList.stream().map(prod -> prod.getId()).collect(Collectors.toList());
            // set the entities
            String joinedFiltered = filtered.stream().map(String::valueOf).collect(Collectors.joining(","));
            campaginEntity.setProducts(joinedFiltered);
            return campaginEntity;
        }
        return campaginEntity;
    }

        public CampaignDTO convertEntitytoDTO(CampaignEntity campaignEntity) {
            // Below is Adapter Design Pattern
            CampaignDTO campaignDTO = new CampaignDTO();
            campaignDTO.setId(campaignEntity.getId());
            campaignDTO.setBid(campaignEntity.getBid());
            campaignDTO.setName(campaignEntity.getName());
            campaignDTO.setProductCodes(campaignEntity.getProducts());
            campaignDTO.setStartingDate(campaignEntity.getStartingDate());
            // get products list as a string
            List<Long> parsedLongs = Arrays.asList(campaignEntity.getProducts().split(","))
                                           .stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            List<ProductEntity> productsList = (List<ProductEntity>) productRepository.findAllById(parsedLongs);
            campaignDTO.setProducts(productsList.toString());
            return campaignDTO;
        }
}
