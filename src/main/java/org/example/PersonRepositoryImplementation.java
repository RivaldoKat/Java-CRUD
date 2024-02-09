package org.example;

import java.util.HashMap;

public class PersonRepositoryImplementation implements PersonRepository {

    private final HashMap<String, Person> allPeople = new HashMap<>();

    @Override
    public HashMap<String, Person> getPeople(){
        return allPeople;
    }

    @Override
    public void savePerson(Person person) {
            allPeople.put(person.getId(),person);
    }

    @Override
    public void updatePerson(Person person, String lastName) {
        person.setLastName(lastName);
    }

    @Override
    public boolean deletePerson(Person person) {
            allPeople.remove(person.getId());
            return true;
    }

    @Override
    public Person getPerson(String id) {
        if (getPeople().get(id) != null){
            return getPeople().get(id);
        }
        return null;
    }
}
