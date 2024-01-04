package com.nbsaas.boot.order.ext.domain.simple;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderExt implements Serializable {

    private String note;

    private String remark;
}
