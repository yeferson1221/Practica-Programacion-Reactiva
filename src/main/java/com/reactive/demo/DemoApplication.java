package com.reactive.demo;

import com.reactive.demo.combination.Combination;
import com.reactive.demo.conditional.Conditional;
import com.reactive.demo.data.Data;
import com.reactive.demo.error.ErrorOp;
import com.reactive.demo.filter.Filter;
import com.reactive.demo.mathematician.Mathematician;
import com.reactive.demo.model.Person;
import com.reactive.demo.operator.Create;
import com.reactive.demo.trasformation.Transformation;
import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	Data data = new Data();
	List listPerson = data.listPerson();
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void reactor(){
		Mono.just(new Person(1,"yefer",21))
				.doOnNext(person -> log.info(person + "doOnNext"))
		        .subscribe(person -> log.info(person + " rector"));
	}

	public void rxjava3(){
		Observable.just(new Person(1,"yefer",22))
				.subscribe(person -> log.info(person + " rxjava3"));
	}

	public void mono(){
		Mono.just(new Person(1,"yefer",22))
				.subscribe(person -> log.info("Mono: " + person));
	}

	public void flux(){

		Flux.fromIterable(listPerson)
				.subscribe(person -> log.info("Flux: "+person));
	}

	public void fluxMono(){

		Flux<Person> fx = Flux.fromIterable(listPerson);
		fx.collectList().subscribe(people -> log.info("Flux a Mono: "+people));
	}

	@Override
	public void run(String... args) throws Exception {
		//reactor();
		//rxjava3();
		//mono();
		//flux();
		//fluxMono();

		//Create create = new Create();
		//create.range();
		//create.repeat();

		//Transformation trasformation = new Transformation();
		//trasformation.map();
		//trasformation.map2();
		//trasformation.flatMap();
		//trasformation.groupBy();

		//Filter filter = new Filter();
		//filter.filter();
		//filter.distinct();
		//filter.take();
		//filter.takelast();

		//Combination combination = new Combination();
		//combination.merge();
		//combination.zip();
		//combination.zipWith();

		//ErrorOp error = new ErrorOp();
		//error.retry();
		//error.errorReturn();
		//error.errorResume();
		//error.errorMap();

		//Conditional conditional = new Conditional();
		//conditional.defaultEmty();
		//conditional.takaUntil();
		//conditional.timeout();

		Mathematician mathematician = new Mathematician();
		//mathematician.average();
		//mathematician.count();
		//mathematician.min();
		//mathematician.sum();
		mathematician.summarizing();
	}
}
