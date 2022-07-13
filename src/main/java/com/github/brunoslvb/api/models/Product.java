package com.github.brunoslvb.api.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
public class Product extends PanacheEntity {

    public String name;

    public BigDecimal price;

    @CreationTimestamp
    public Date createdAt;

    @UpdateTimestamp
    public Date UpdatedAt;

}
