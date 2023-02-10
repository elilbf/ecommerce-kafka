package br.com.alura;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    private final String userId;
    private final String orderId;
    private final BigDecimal amount;
}
