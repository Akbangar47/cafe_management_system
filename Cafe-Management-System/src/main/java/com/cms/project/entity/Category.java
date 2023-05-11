package com.cms.project.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.io.Serializable;

@NamedQuery(name = "Category.getAllCategory",query = "select c from Category c")
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


}
