package org.example;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class PersonService {

    // This will be our variables for Dependency Injection
    private PersonRepository personRepository;
    private Scanner scanner;

    // This is where we do the business logic


    public HashMap<String, Person> getPeople(){
        return personRepository.getPeople();
    }



    public void savePerson(){
        Person person = new Person();

        System.out.println("Enter First name :");
        String firstName = scanner.next();
        person.setFirstName(firstName);
        System.out.println("Enter Last name :");
        String lastName = scanner.next();
        person.setLastName(lastName);
        System.out.println("Enter Age :");
        boolean loopHolder;
        do{
            loopHolder = false;
            try{
            person.setAge(scanner.nextInt());
        }
        catch(InputMismatchException e){
            System.out.println("Enter the right value:");
            loopHolder = true;
            scanner.next();
        }

        }while(loopHolder);
        System.out.println("Enter Contact details :");
        person.setContact(scanner.next());
        System.out.println("Enter Person Identity number :");
        String id = scanner.next();
        person.setId(id);
        System.out.println("Enter Person Marital Status :");
        person.setMarriageStatus(scanner.next());

        if(getPeople().get(id) == null){
            personRepository.savePerson(person);
            System.out.println("Person " + person.getFirstName() +" With ID " +
                        person.getId() +" is saved");
        }else {
            System.out.println("The user already exists in the database");
        }


    }

    public Person getPerson(){
        //We get a person by their id number

        System.out.println("Enter the Id number of a person");
        String person_id = scanner.next();

        Person person;

            if (getPeople().get(person_id) != null){
                 person = personRepository.getPerson(person_id);

            }else {
                person = null;
            }



        return person;
    }

    public void updatePerson(){
        Person person = getPerson();

        System.out.println("Enter surname");
        String lastName = scanner.next();
        if(getPeople().containsKey(person.getId())){
            personRepository.updatePerson(person,lastName);
            System.out.println("Person Updated");
        }else {
            System.out.println("Person Not Found");
        }

    }

    public void deletePerson(){
        Person person = getPerson();

       if(personRepository.deletePerson(person)){
           System.out.println("Person Deleted");
       }else {
           System.out.println("Person was not found");
       }
    }

}
