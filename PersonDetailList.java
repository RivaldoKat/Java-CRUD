import java.util.Iterator;
import java.util.ArrayList;
// import java.util.LinkedList;
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
        Iterator<Person> thatId = Iterator();
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
        
               
    }
}
