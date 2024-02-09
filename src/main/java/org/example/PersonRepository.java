package org.example;


import java.util.HashMap;

public interface PersonRepository {
//    List<Person> getAllPeople();
    HashMap<String, Person> getPeople();
    void savePerson(Person person);

    void updatePerson(Person person, String lastName);

    boolean deletePerson(Person person);

    Person getPerson(String id);
}


