package org.example;

import lombok.AllArgsConstructor;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class PersonService {

    // This will be our variables for Dependency Injection
    private PersonRepository personRepository;
    private Scanner scanner;


    // This is where we do the business logic

    public List<Person> getAllPeople(){
        return personRepository.getAllPeople();
    }

    public Person savePerson(){
        Person person = new Person();

        System.out.println("Enter First name :");
        person.setFirstName(scanner.next());
        System.out.println("Enter Last name :");
        person.setLastName(scanner.next());
        System.out.println("Enter Age :");
        boolean loopHolder = true;
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
        
        boolean found =false;
        for(Person person1:getAllPeople()){
            if(person1.getId() == id){
                found = true;
                break;
            }
        }

        if(!found){
            personRepository.savePerson(person);
            System.out.println("Person " + person.getFirstName() +" With id " +
                        person.getId() +" is saved");
        }else {
            System.out.println("The user already exists in the database");
        }
        return person;


    }

    public Person getPerson(){
        //We get a person by their id number
        System.out.println("Enter the Id number of a person");
        String person_id = scanner.next();

        Person person = new Person();

        //get all people
        for(Person person_inList:getAllPeople()){

            if (personRepository.getPerson(person_id,person_inList) != null){
                 person = personRepository.getPerson(person_id,person_inList);
                 break;
            }else {
                person = null;
            }
        }

        return person;
    }

    public Person updatePerson(){
        Person person = new Person();

        person = getPerson();

        System.out.println("Enter surname");
        String lastName = scanner.next();
        if(personRepository.updatePerson(person,lastName)){
            System.out.println("Person Updated");
        }else {
            System.out.println("Person Not Found");
        };

        return person;
    }

    public void deletePerson(){
        Person person = new Person();

        person = getPerson();

       if(personRepository.deletePerson(person)){
           System.out.println("Person Deleted");
       }else {
           System.out.println("Person was not found");
       }
    }

}
