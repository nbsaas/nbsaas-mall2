package com.nbsaas.life.area.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "area")
public class Area extends CatalogEntity {


    private Float lng;


    private Float lat;
}
