package com.reactive.demo.model;

public class Sale {

    private Integer id;
    private String name;

    public Sale(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sale(Integer id) {
        this.id = id;
    }

    public Sale(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
