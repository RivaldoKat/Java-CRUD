package org.example;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class PersonService {

    // This will be our variables for Dependency Injection
    private PersonRepository personRepository;
    private Scanner scanner;

    // This is where we do the business logic


    public List<Person> getPeople(){
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

       Optional<Person> getID = getPeople().stream().filter(
               personID -> personID.equals(personRepository.getPerson(id))
       ).findFirst();
       getID.ifPresentOrElse(
               r -> System.out.println(r.getFirstName() + " " + r.getLastName() + " exist ID: " + r.getId()),
               () -> personRepository.savePerson(person)
       );



    }

    public Person getPerson(){
        //We get a person by their id number
        Person person;
        System.out.println("Enter the Id number of a person");
        String person_id = scanner.next();
        person = personRepository.getPerson(person_id);

        return person;
    }

    public void updatePerson(){
        Person person = getPerson();

        System.out.println("Enter surname");
        String lastName = scanner.next();
        Optional<Person> getID = getPeople().stream().filter(
                personID -> personID.equals(person)
        ).findFirst();
        getID.ifPresent(
                r -> personRepository.updatePerson(person,lastName)
        );
        System.out.println(person);
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
