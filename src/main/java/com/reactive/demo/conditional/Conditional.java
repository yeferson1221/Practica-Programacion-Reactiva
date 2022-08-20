package com.reactive.demo.conditional;

import com.reactive.demo.data.Data;
import com.reactive.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Conditional extends Data {

    // solo se mada el flujo de la list si no hay nada en el mono o flux
    public void defaultEmty(){
        Mono.empty()
                .defaultIfEmpty(new Person(0, "XXXXXMono", 99))
                .subscribe(person -> log.info(person.toString()));

        Flux.empty()
                .defaultIfEmpty(new Person(0, "XXXXXFlux", 99))
                .subscribe(person -> log.info(person.toString()));
    }

    //nos permite Emitir valores  desde la condicion empieza y nos lista solo la lista siguiente
    public void takaUntil(){
        Flux.fromIterable(listPerson())
                .takeUntil(person -> person.getAge() > 18)
                .subscribe(person -> log.info(person.toString()));
    }

    public void timeout() throws InterruptedException {
        Flux.fromIterable(listPerson())
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(person -> log.info(person.toString()));

        Thread.sleep(10000);
    }
}
