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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"odr_id", "prd_id"})})
public class OrderDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dtlId;

    @ManyToOne
    @JoinColumn(name = "odr_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "prd_id")
    private Product product;

    @Min(1)
    private Integer dtlQuantity;

    @DecimalMin("0.00")
    private BigDecimal dtlUnitPrice;
}
