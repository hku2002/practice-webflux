package com.example.operator.error;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Book {

    private int id;
    private String name;
    private int price;

    @Builder
    public Book(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
