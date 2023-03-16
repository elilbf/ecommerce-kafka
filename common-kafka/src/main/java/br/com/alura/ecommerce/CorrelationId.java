package br.com.alura.ecommerce;

import lombok.ToString;

import java.util.UUID;

@ToString
public class CorrelationId {

    private final String id;


    public CorrelationId(String title) {
        this.id = title + "(" + UUID.randomUUID() + ")";
    }

    public CorrelationId continueWith(String title) {
        return new CorrelationId(id + "-" + title);
    }
}
