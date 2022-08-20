package com.reactive.demo.filter;

import com.reactive.demo.data.Data;
import reactor.core.publisher.Flux;

public class Filter extends Data {

    public void filter(){
        Flux.fromIterable(listPerson())
                .filter(person -> person.getAge() > 20)
                .subscribe(person -> log.info(person.toString()));
    }

    public void distinct(){
        Flux.fromIterable(listPerson())
                .distinct()
                .subscribe(person -> log.info("no iguales: " + person));
    }

    // toma el elemento desde el inicio toma la cantidad que se ponga en el take
    public void take(){
        Flux.fromIterable(listPerson())
                .take(2)
                .subscribe(person -> log.info("" + person));
    }
    // toma el elemento desde el final toma la cantidad que se ponga en el take
    public void takelast(){
        Flux.fromIterable(listPerson())
                .takeLast(2)
                .subscribe(person -> log.info("" + person));
    }
}
