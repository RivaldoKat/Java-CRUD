package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Here we are using <Encapsulation> for information hiding
 * That is the reason we use all of our attributes are of access modifier of private
 */

// This is a low-level module that will represent our person

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person{
    private String firstName;
    private String lastName;
    private int age;
    private String id;
    private String contact;
    private boolean marriageStatus;

    @Override
    public String toString() {
        return "Person:" +
                " FirstName = '" + firstName + '\'' +
                ", LastName = '" + lastName + '\'' +
                ", Age = " + age +
                ", ID = '" + id + '\'' +
                ", Contact = '" + contact + '\'' +
                ", MarriageStatus = '" + (marriageStatus ? "Married" : "Single") + '\'';
    }
}

