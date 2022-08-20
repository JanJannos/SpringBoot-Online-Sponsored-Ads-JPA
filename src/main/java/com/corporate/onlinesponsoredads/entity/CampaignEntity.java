package com.corporate.onlinesponsoredads.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CAMPAIGNS_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // PK
    private String name;
    private Double bid;
    private Date startingDate;
    private String products;
}
