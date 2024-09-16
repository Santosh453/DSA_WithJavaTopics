package org.example.Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerial {

    public static void main(String[] args) {
        try{

            FileInputStream fis = new FileInputStream("ob.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student student = (Student) ois.readObject();
            student.displayName();




        }catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
