package com.productsmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

    @Column(name = "start_date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date startDate = Date.from(java.time.ZonedDateTime.now().toInstant());

    @Column(name = "end_date")
    private Date endDate;

    @JsonIgnoreProperties("products")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
