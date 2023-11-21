package com.diplomado.ApiRestSpringBoot.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class RolDTO implements Serializable {
    private static final long serialVersionUID = 8799656478674712000L;
    private Integer id;
    private String name;

    public RolDTO() {
    }
}
