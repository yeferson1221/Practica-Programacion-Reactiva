package com.reactive.demo.combination;

import com.reactive.demo.data.Data;
import com.reactive.demo.model.Person;
import com.reactive.demo.model.Sale;
import reactor.core.publisher.Flux;

public class Combination extends Data {
    public void merge(){

        Flux<Person> fx1 = Flux.fromIterable(listPerson());
        Flux<Person> fx2 = Flux.fromIterable(listPerson());
        Flux<Sale> fxSale = Flux.fromIterable(listSale());
        Flux.merge(fx1,fx2,fxSale)
                //.take(4) me mada el flujo por cantidad puesta
                //.filter(person -> person.getId() == 1) me filtra el flujo por id
                .subscribe(person -> log.info("juntar dos flujos de lista: " + person));
    }

    //comprime todo en un lista
    public void zip(){
        Flux<Person> fx1 = Flux.fromIterable(listPerson());
        Flux<Person> fx2 = Flux.fromIterable(listPerson());
        Flux<Sale> fxSale = Flux.fromIterable(listSale());
        //Flux.zip(fx1,fxSale, (person, sale) -> String.format("F1: " + person + " Venta: " + sale))
                //.subscribe(person -> log.info(""+person));
        Flux.zip(fx1,fx2,fxSale)
                .subscribe(person -> log.info(person.toString()));
    }

    public void zipWith(){
        Flux<Person> fx1 = Flux.fromIterable(listPerson());
        Flux<Person> fx2 = Flux.fromIterable(listPerson());
        Flux<Sale> fxSale = Flux.fromIterable(listSale());

        fx1.zipWith(fx2, (person, person2) -> String.format("F1: " + person + " Venta: " + person2))
        .subscribe(person -> log.info(""+person));
    }
}
