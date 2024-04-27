package com.productservice.productservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="category")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @Column(name="categoryid")
    private int categoryId;
    @Column(name="categorytitle")
    private String categoryTitle;
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities;
}
