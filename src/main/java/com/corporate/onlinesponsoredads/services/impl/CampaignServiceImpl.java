package com.corporate.onlinesponsoredads.services.impl;
import com.corporate.onlinesponsoredads.converter.CampaignConverter;
import com.corporate.onlinesponsoredads.dto.CampaignDTO;
import com.corporate.onlinesponsoredads.entity.CampaignEntity;
import com.corporate.onlinesponsoredads.repository.CampaignRepository;
import com.corporate.onlinesponsoredads.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignConverter campaignConverter;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public CampaignDTO saveCampaign(CampaignDTO campaignDTO) {
        Date  currentDateTime = new Date();
        campaignDTO.setStartingDate(currentDateTime);
        CampaignEntity campaignEntity = campaignConverter.convertDTOtoEntity(campaignDTO);
        campaignEntity = campaignRepository.save(campaignEntity);
        CampaignDTO dto = campaignConverter.convertEntitytoDTO(campaignEntity);
        return dto;
    }
}
