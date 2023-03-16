package br.com.alura.ecommerce.consumer;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
public class ServiceProvider<T> implements Callable<Void> {

    private final ServiceFactory<T> factory;

    public Void call() throws ExecutionException, InterruptedException {
        var myService = factory.create();

        try (var service = new KafkaService(myService.getConsumerGroup(),
                myService.getTopic(),
                myService::parse,
                new HashMap<>())) {
            service.run();
        }
        return null;
    }
}
