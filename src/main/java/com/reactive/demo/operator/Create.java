package com.reactive.demo.operator;


import com.reactive.demo.data.Data;
import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Create extends Data {


    public void justFrom(){
        Mono.just(listPerson);
        //Flux.fromIterable(coleccion);  es flux es una coleccion de datos
        //Observable.just(item);
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range(){
        Flux.range(0,3)
                .doOnNext(person -> log.info("mirando como va la la lista: "+person))
                .subscribe();
    }

    public void repeat(){
        Flux.fromIterable(listPerson)
                .repeat(1)
                .subscribe(person -> log.info("Repitiendo datos Flux: "+ person));

        Mono.just(listPerson)
                .repeat(2)
                .subscribe(person -> log.info("Repitiendo datos Mono: "+ person));
    }

}
