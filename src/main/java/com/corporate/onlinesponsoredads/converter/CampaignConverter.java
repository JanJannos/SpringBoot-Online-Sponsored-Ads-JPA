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
        CampaignEntity pe = new CampaignEntity();
        pe.setStartingDate(campaignDTO.getStartingDate());
        pe.setName(campaignDTO.getName());
        pe.setBid(campaignDTO.getBid());
        pe.setProducts(campaignDTO.getProducts());
        // find all entities from this list
        List<Long> parsedLongs = Arrays.asList(campaignDTO.getProducts().split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        List<ProductEntity> productsList = (List<ProductEntity>) productRepository.findAllById(parsedLongs);
        List<Long> filtered = productsList.stream().map(prod -> prod.getId()).collect(Collectors.toList());
        // set the entities
        String joinedFiltered = filtered.stream().map(String::valueOf).collect(Collectors.joining(","));
        pe.setProducts(joinedFiltered);
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
