package org.example;

import java.io.*;

public class PersonFileHandler {

    public  void serialize(Object obj, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
            System.out.println("Info Saved");
        } catch (IOException e) {
            System.out.println("Error occurred during serialization.");
            e.printStackTrace();
        }
    }

    public  Object deserialize(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object obj = objectIn.readObject();
            System.out.println(obj);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred during deserialization.");
            e.printStackTrace();
            return null;
        }
    }
}
