package br.com.alura.ecommerce.ecommerce;

import lombok.ToString;

import java.util.UUID;

@ToString
public class CorrelationId {

    private final String id;


    public CorrelationId() {
        this.id = UUID.randomUUID().toString();
    }
}
