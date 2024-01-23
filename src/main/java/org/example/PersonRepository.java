package org.example;

import java.util.List;

public interface PersonRepository {
    List<Person> getAllPeople();
    void savePerson(Person person);

    boolean updatePerson(Person person,String lastName);

    boolean deletePerson(Person person);

    Person getPerson(String id,Person person);
}


