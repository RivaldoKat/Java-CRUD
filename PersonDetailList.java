import java.util.Iterator;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Person{
    public String firstName;
    public String lastName;
    public int age;
    public int id;
    public String contact;
    public String marriageStatus;

    public Person(String firstName, String lastName, int age, int id, String contact, String marriageStatus){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.id = id;
            this.contact = contact;
            this.marriageStatus = marriageStatus;
    }

    public int getId(){
        return this.id;
    }

    public String getName(String firstName){
        return this.firstName=firstName;
    } 
    
    
    public String getSurname(){
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact(String contact){
        return this.contact = contact;
    }

    public String getMarriageStatus(String marriageStatus){
        return this.marriageStatus = marriageStatus;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + age + "|" + contact + "|" + marriageStatus + "|" + id;
    }

    
}

class PersonList{
    List<Person> people;

    public PersonList() {
        this.people = new ArrayList<>();
    }

    public Person create(String firstName, String lastName, int age, int id, String contact, String marriageStatusString){
        Person person = new Person(firstName, lastName, age, id, contact, marriageStatusString);
        people.add(person);
        return person;
    }

    public List<Person> getList(){
        return people;
    }

    public Person searchId(int idNumber){
        for(Person findMyId: people){
            if(findMyId.getId() == idNumber){
                return findMyId;
            }
        }
        return null;
    }

    public Person updateSurname(int idNumber, String newSurname){
        for(Person findMyId: people){
            if(findMyId.getId() == idNumber){
                findMyId.setLastName(newSurname);
                return findMyId;
            }
        }
        return null;
    }

    public boolean deletePerson(int idNumber){
        Iterator<Person> thatId = people.iterator();
        while(thatId.hasNext()){
            Person thatPersonId = thatId.next();
            if(thatPersonId.getId() == idNumber){
                thatId.remove();
                return true;
            }
        }
        return false;
    }
    

    public void display(int idNumber){
        System.out.println(searchId(idNumber));          
    }


}


public class PersonDetailList {
    public static void main(String[] args){
       Scanner inputDetails = new Scanner(System.in);
       
       PersonList myPersonDetailObj = new PersonList();


       while(true){
            System.out.println("1. Add Person ");
            System.out.println("2. Search Person by ID ");
            System.out.println("3. Delete Person by ID");
            System.out.println("4. Update Surname ");
            System.out.println("5. Exit program ");
            System.out.println("Select option ");

            int switchControl = inputDetails.nextInt();

            switch (switchControl) {
                case 1:
                    System.out.println("Enter Personal details");
                    System.out.println("Name: ");
                    
                    String firstName = inputDetails.next();
                    System.out.println("Surname: ");           
                    String lastName = inputDetails.nextLine();
                    System.out.println("Age: ");           
                    int age = inputDetails.nextInt();
                    System.out.println("ID: ");
                    try{
                        int id = inputDetails.nextInt();
                    }
                    catch(InputMismatchException e){
                        e.printStackTrace();
                    }
                    System.out.println("Contact: ");
                   
                    String contact = inputDetails.nextLine();
                    System.out.println("Marital Status");
                    
                    String marital =inputDetails.nextLine();
                    myPersonDetailObj.create(firstName, lastName, age, id, contact, marital);                  
                    System.out.println("Information Captured!!!");
                    break;
                case 2:
                    System.out.println("Enter the existing ID to search");
                    int idNumber = inputDetails.nextInt();
                    while(true){
                        myPersonDetailObj.display(idNumber);
                    }
                
                case 3:
                    System.out.println("Enter the existing ID to delete an individual info");
                    int deleteRecord = inputDetails.nextInt();
                    myPersonDetailObj.deletePerson(deleteRecord);
                    System.out.println("Task Successful");
                    break;
                case 4:
                    System.out.println("Enter the ID to update Surname");
                    int updateID = inputDetails.nextInt();
                    System.out.println("Update surname");
                    String updateSurnameerror = inputDetails.nextLine();
                    String updateSurname = inputDetails.nextLine();
                    myPersonDetailObj.updateSurname(updateID, updateSurname);
                    if(myPersonDetailObj.updateSurname(updateID, updateSurname) != null){
                        myPersonDetailObj.display(updateID);
                        System.out.println("Task complete!!! surname updated");
                    }
                    else{
                        System.out.println("Task failed");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    inputDetails.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid !!!Please enter a valid option.");
            }
       }
               
    }
}
