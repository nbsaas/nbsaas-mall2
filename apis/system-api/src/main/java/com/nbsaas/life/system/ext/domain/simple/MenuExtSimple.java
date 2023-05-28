package com.nbsaas.life.system.ext.domain.simple;

import com.nbsaas.life.system.api.domain.simple.MenuSimple;
import lombok.Data;

import java.util.List;

@Data
public class MenuExtSimple extends MenuSimple {

    private Long parentId;

}
