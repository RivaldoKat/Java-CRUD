package org.example;



import java.util.List;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PersonRepository personRepositoryImplementation = new PersonRepositoryImplementation();

        //Now we implement dependency injection

        PersonService personService = new PersonService(personRepositoryImplementation, scanner);

        personService.commands(personService);

    }


}