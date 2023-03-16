package br.com.alura.ecommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Message<T> {

    private final CorrelationId id;
    private final T payload;

}
