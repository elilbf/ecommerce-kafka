package br.com.alura;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
public class Order {

    private final String userId;
    private final String orderId;
    private final BigDecimal amount;
}
