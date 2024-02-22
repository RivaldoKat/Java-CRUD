package org.example;


import java.util.List;

public interface PersonRepository {
//    List<Person> getAllPeople();
    List<Person> getPeople();
    void savePerson(Person person);

    void updatePerson(Person person, String lastName);

    boolean deletePerson(Person person);

    Person getPerson(String id);
}


