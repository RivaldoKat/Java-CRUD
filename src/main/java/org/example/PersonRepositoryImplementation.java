package org.example;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImplementation implements PersonRepository {

    private List<Person> people = new ArrayList<>();

    @Override
    public List<Person> getAllPeople() {

        return people;
    }

    @Override
    public void savePerson(Person person) {
        people.add(person);
    }

    @Override
    public boolean updatePerson( Person person, String lastName) {
        person.setLastName(lastName);
        return true;
    }

    @Override
    public boolean deletePerson(Person person) {
            people.remove(person);
            return true;
    }

    @Override
    public Person getPerson(String id,Person person) {
        if (person.getId().equals(id)){
            return person;
        }
        return null;
    }
}
