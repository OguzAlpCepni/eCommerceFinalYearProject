package com.productservice.productservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="category")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryEntity {
    @Id
    @Column(name="categoryid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(name="categorytitle")
    private String categoryTitle;

    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> productEntities;


}
