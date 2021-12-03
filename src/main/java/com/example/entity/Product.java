package com.example.entity;

import com.example.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
//spring jpa annotations
@Entity
@Table(name = "product")
//spring annotation
@Component
public class Product extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "product_name", nullable = false)
    String productName;
    String material;
    String price;
    @Column(name = "promotion_code")
    String promotionCode;

}
