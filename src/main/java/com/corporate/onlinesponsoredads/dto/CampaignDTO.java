package com.corporate.onlinesponsoredads.dto;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignDTO {
    private Long id;
    private String name;
    private Double bid;
    private Date startingDate;
}
