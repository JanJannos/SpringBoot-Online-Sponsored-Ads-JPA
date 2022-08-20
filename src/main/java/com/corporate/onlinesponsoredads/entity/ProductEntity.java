package com.corporate.onlinesponsoredads.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // PK
    private String title;
    private String category;
    private Double price;
    private String serialNumber;
}
