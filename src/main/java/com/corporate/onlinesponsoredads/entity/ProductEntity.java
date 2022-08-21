package com.corporate.onlinesponsoredads.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.text.MessageFormat;

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
    public String toString() {
        return MessageFormat.format("Product details: Title: {0} , category: {1} , price: {2} , serialNumber:{3}", this.title , category , price , serialNumber);
    }
}
