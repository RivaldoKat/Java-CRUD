package org.example;


import java.util.List;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PersonRepositoryImplementation personRepositoryImplementation = new PersonRepositoryImplementation();

        //Now we implement dependency injection

        PersonService personService = new PersonService(personRepositoryImplementation, scanner);

        commands(personService);

    }


    public static void commands(PersonService personService){

        System.out.println("Enter option " +
                "\n 1) List of People" +
                "\n 2) Create a person" +
                "\n 3) Get Person" +
                "\n 4) Update person" +
                "\n 5) Delete person");
        int opt = scanner.nextInt();

        switch (opt){
            case 1:
                // Get all people
                List<Person> people = personService.getAllPeople();
                for (Person person: people){
                    System.out.println(person);
                }
                commands(personService);
                break;
            case 2:
                Person person = personService.savePerson();
                
                System.out.println("Person " + person.getFirstName() +" With id " +
                        person.getId() +" is saved");
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