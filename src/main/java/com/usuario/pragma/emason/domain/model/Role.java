package com.usuario.pragma.emason.domain.model;

public class Role {
    private Long id;
    private String name;
    private String description;


    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Role(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
