package com.reactive.demo.data;

import com.reactive.demo.DemoApplication;
import com.reactive.demo.model.Person;
import com.reactive.demo.model.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Data {

    protected static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
  public List<Person> listPerson(){
      List<Person> persons = new ArrayList<>();
      persons.add(new Person(1,"Yeferson",18));
      persons.add(new Person(2,"Alejandro",19));
      persons.add(new Person(1,"Valencia",21));
      persons.add(new Person(3,"Garzon",20));

      return persons;
  }
   protected List listPerson = listPerson();

    public List<Sale> listSale(){
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1,"Celular"));
        sales.add(new Sale(2,"Moto"));
        sales.add(new Sale(1,"Pc"));
        sales.add(new Sale(3,"Ram"));

        return sales;
    }
}
