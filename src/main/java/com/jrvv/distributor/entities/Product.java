package com.jrvv.distributor.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdId;

    @NotBlank
    @Size(max = 100)
    private String prdName;

    private String prdDescription;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal prdPrice;

    @Builder.Default
    private Integer prdStock = 0;

    private String prdCategory;
    
    @Builder.Default
    private Boolean prdActive = true;
}