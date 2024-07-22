package com.azrosk.inventory_service.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory")
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
