package com.example.lab02.repositories;

import com.example.lab02.models.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    List<Person> mainListPerson;


    public PersonRepository(){
        mainListPerson = new ArrayList<>();
        mainListPerson.add(new Person(1,"Raul", "Ramirez", 25, "r.ramirez@gmail.com" ));
        mainListPerson.add(new Person(2,"Melida", "Perez", 27, "mely.perez@gmail.com" ));
        mainListPerson.add(new Person(3,"Vanessa", "Ramirez", 24, "v.ramirez@gmail.com" ));
        mainListPerson.add(new Person(4,"Ricardo", "Acevedo", 28, "richacevedo@gmail.com" ));
    }

    public List<Person> getAllListPerson(){
        return this.mainListPerson;
    }
    public Person getPersonById(int idMainObject){
        //return this.mainListPerson.stream().filter(person -> person.getIdPersona() == idMainObject).findFirst();
        for (Person person : mainListPerson) {
            if (person.getIdPersona() == idMainObject) {
                return person;
            }
        }
        return null;
    }

    public boolean AddPerson(Person mainObject) {
        int tmpId = mainListPerson.size() + 1;
        mainObject.setIdPersona(tmpId);
        return this.mainListPerson.add(mainObject);
    }

    public boolean EditPerson(Person mainObject) {

        for (int i = 0; i < mainListPerson.size(); i++) {
            Person person = mainListPerson.get(i);
            if (person.getIdPersona() == mainObject.getIdPersona()) {
                mainListPerson.set(i, mainObject);
                return true;
            }
        }
        return false;
    }

    public boolean DeletePerson(int idMainObject){
        Person objectToDelete = getPersonById(idMainObject);
        if (objectToDelete != null) {
            mainListPerson.remove(objectToDelete);
            return true;
        }
        return false;
    }


}
