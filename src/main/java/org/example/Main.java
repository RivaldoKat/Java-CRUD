package org.example;


import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PersonRepository personRepositoryImplementation = new PersonRepositoryImplementation();

        //Now we implement dependency injection

        PersonService personService = new PersonService(personRepositoryImplementation, scanner);

        commands(personService);

    }


    public static void commands(PersonService personService) {

        System.out.println("""
                Enter option\s
                 1) List of People
                 2) Create a person
                 3) Get Person
                 4) Update person
                 5) Delete person""");
        int opt = scanner.nextInt();

        switch (opt){
            case 1:
                // Get all people
//                List<Person> people = personService.getAllPeople();
                HashMap<String, Person> people = personService.getPeople();

                    System.out.println(people);

                
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
            default:
                commands(personService);
        }
    }
}