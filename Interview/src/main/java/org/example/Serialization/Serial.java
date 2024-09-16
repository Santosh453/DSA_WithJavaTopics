package org.example.Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial {
    public static void main(String[] args) {

        try {

            // Create object of student
            Student student = new Student("Amit", "amit@gmail.com", 20, "Delhi");

            //Write data to File
            FileOutputStream fos = new FileOutputStream("ob.txt");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // how to serialize
            oos.writeObject(student);

            oos.close();
            fos.close();
            System.out.println("Object state is transfer to file ob");

        } catch (IOException exception){
            exception.printStackTrace();
        }



    }
}
