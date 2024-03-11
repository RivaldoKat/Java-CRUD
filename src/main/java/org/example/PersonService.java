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

    public void commands(PersonService personService) {

        System.out.println("""
                Enter option\s
                 1) List of People
                 2) Create a person
                 3) Get Person
                 4) Update person
                 5) Delete person
                 6) Exit""");

        int opt = scanner.nextInt();
        switch (opt){
            case 1:
                // Get all people
                List<Person> people = personService.getPeople();
                people.forEach(
                        System.out::println
                );


                commands(personService);
                break;
            case 2:
                personService.savePerson();


                commands(personService);
                break;
            case 3:

                System.out.println(personService.getPerson());
                commands(personService);
                break;
            case 4:
                //update

                personService.updatePerson();
                commands(personService);
                break;
            case 5:
                //delete
                personService.deletePerson();
                commands(personService);
                break;
            case 6:
                System.out.println("Goodbye!!!");
                System.exit(0);
            default:
                commands(personService);
        }
    }
    public void savePerson(){
        Person person = new Person();
        PersonRepositoryImplementation getStatus = new PersonRepositoryImplementation();

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
        System.out.print("Press 1.Single or 2.Married :");
        int status = scanner.nextInt();
        person.setMarriageStatus(getStatus.setMarriage(status));

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
