package com.jrvv.distributor.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long odrId;

    @ManyToOne
    @JoinColumn(name = "cli_id")
    private Client client;

    @Builder.Default
    private LocalDateTime odrDate = LocalDateTime.now();
    
    @Builder.Default
    private String odrStatus = "Pending";

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal odrTotal;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> details;
}