package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class PersonRepositoryImplementation implements PersonRepository {

    private final List<Person> allPeople = new ArrayList<>();
    private boolean maritalStatus = false;

    @Override
    public List<Person> getPeople(){
        return allPeople;
    }

    @Override
    public void savePerson(Person person) {
            allPeople.add(person);
    }
    @Override
    public boolean setMarriage(int type){
        Person getStatus = new Person();
        if(type == 1){
           return getStatus.isMarriageStatus();
        }
        return true;
    }

    @Override
    public void updatePerson(Person person, String lastName) {
        person.setLastName(lastName);
    }

    @Override
    public boolean deletePerson(Person person) {
            allPeople.remove(person);
            return true;
    }

    @Override
    public Person getPerson(String id) {
        AtomicReference<Person> person = new AtomicReference<>(new Person());
        Optional<Person> getID = getPeople().stream()
                .filter(personID -> personID.getId().equals(id)).findFirst();
        getID.ifPresent(person::set);
        return person.get();
    }
}
