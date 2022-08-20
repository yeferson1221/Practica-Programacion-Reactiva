package com.reactive.demo.conditional;

import com.reactive.demo.data.Data;
import com.reactive.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Conditional extends Data {
    public void defaultEmty(){
        Mono.empty()
                .defaultIfEmpty(new Person(0, "XXXXXMono", 99))
                .subscribe(person -> log.info(person.toString()));

        Flux.empty()
                .defaultIfEmpty(new Person(0, "XXXXXFlux", 99))
                .subscribe(person -> log.info(person.toString()));
    }
}
