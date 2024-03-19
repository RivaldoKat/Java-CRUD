package org.example;




import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        PersonRepository personRepositoryImplementation = new PersonRepositoryImplementation();
        Person person = new Person();
        //Now we implement dependency injection

        PersonService personService = new PersonService(personRepositoryImplementation, scanner);
        PersonFileHandler handlFile = new PersonFileHandler();


        personService.commands(personService);

    }

}