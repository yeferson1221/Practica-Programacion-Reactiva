package com.reactive.demo.mathematician;

import com.reactive.demo.data.Data;
import com.reactive.demo.model.Person;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Mathematician extends Data {

    // me saca el promededio del flujo
    public void average(){
        Flux.fromIterable(listPerson())
                .collect(Collectors.averagingInt(Person::getAge))
                .subscribe(person -> log.info(person.toString()));
    }

    //me cuenta el numero de objetos del flujo
    public void  count(){
        Flux.fromIterable(listPerson())
                .count()
                .subscribe(person -> log.info(person.toString()));
    }

    // me imprime el menor
    public void min(){
        Flux.fromIterable(listPerson())
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
                .subscribe(person -> log.info(person.get().toString()));  // get para quitar el opcional
    }

    //la suma de todos los valores
    public void sum(){
        Flux.fromIterable(listPerson())
                .collect(Collectors.summingInt(Person::getAge))
                .subscribe(person -> log.info(person.toString()));
    }

    public void summarizing(){
        Flux.fromIterable(listPerson())
                .collect(Collectors.summarizingInt(Person::getAge))
                .subscribe(person -> log.info(person.toString()));
    }
}
