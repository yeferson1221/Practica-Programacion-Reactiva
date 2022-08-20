package com.reactive.demo.error;

import com.reactive.demo.data.Data;
import com.reactive.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorOp extends Data {

    //me muestra el error
    public void retry(){
        Flux.fromIterable(listPerson())
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))  // simula un error
                .retry(1)
                .doOnNext(person -> log.info(person.toString()))    // doOnNext recordar permite saber hata ese momento como va el flujo
                .subscribe();

    }

    //me permite controlar el error y cambiarlo por lo que quiera
    public void errorReturn(){
        Flux.fromIterable(listPerson())
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))  // simula un error
                .onErrorReturn(new Person(0,"ERROR",9 ) )
                .subscribe(person -> log.info(person + "Aqui se Controla el error y se cambia por este Objetos y texto"));
    }

    //
    public void errorResume(){
        Flux.fromIterable(listPerson())
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))  // simula un error
                .onErrorResume(error -> Mono.just(new Person(0,"ERROR2",999)))
                .subscribe(person -> log.info(person + " ERROR"));
    }

    // me permite controlar el error creando una nueva exepcion
    public void errorMap(){
        Flux.fromIterable(listPerson())
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))  // simula un error
                .onErrorMap(error -> new InterruptedException( error.getMessage()))
                .subscribe(person -> log.info(person + "ERROR3"));
    }
}
