package com.reactive.demo.trasformation;

import com.reactive.demo.data.Data;
import com.reactive.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Transformation extends Data {

    public void map(){

        Flux.fromIterable(listPerson())
                //.filter(person -> person.getName()=="Yeferson") me permite filtrar por la condicion que ponga
                .map( person-> {
                      person.setAge(person.getAge() - 10);
                      person.setName(person.getName() + " Yeferson");
                      return person;
                })
                .subscribe(person -> log.info("lista map " +person));
    }

    public void map2(){
        Flux<Integer> fx = Flux.range(0,10);
        Flux<Integer> fx2 = fx.map(x -> x +10);
        fx2.subscribe(x -> log.info("Otro Ejemplo Map: " + x));
    }

    // el flatMap a diferencia del map me retorna otro flujo ed datos y ya no tepide retornar
    //el objeto en si
    public void flatMap(){
        Flux.fromIterable(listPerson())
        .flatMap(person -> {
            person.setAge(person.getAge() + 5);
            return Mono.just(person);
        })
                .subscribe(person -> log.info("Esta es la lista FlatMap: " + person));
    }

    //agrupar por las conicidencias
    public void groupBy(){
        Flux.fromIterable(listPerson())
                //.groupBy(person -> person.getId());
                .groupBy(Person::getId)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }

}
