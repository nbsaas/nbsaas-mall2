package com.nbsaas.boot.common.data.entity;


import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import lombok.Data;

import javax.persistence.*;

@DiscriminatorValue("0")
@DiscriminatorColumn(name="userType", discriminatorType=DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@FormAnnotation(title = "用户管理")
@Entity
@Table(name = "user_info")
public class AbstractUser extends LongEntity {
}
