package com.nbsaas.life.user.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends AbstractEntity {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_info_attribute", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "name", length = 36)
    @Column(name = "attr", length = 100)
    private Map<String, String> attributes = new HashMap<>();

    private String avatar;

    private Integer catalog;

    @Column(length = 15)
    private String phone;

    private Integer loginSize = 0;

    @Column(length = 20)
    private String name;

    @Enumerated
    private StoreState storeState;
}

