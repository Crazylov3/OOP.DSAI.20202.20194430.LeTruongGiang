/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.globalict.garbage;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.Scanner; 
/**
 *
 * @author dell
 */
public class ConcatenationInLoops {
    public static void main(String[]args) throws FileNotFoundException {
        long startTime,endTime;
        String inpuString = "";
        StringBuilder oStringBuilder = new StringBuilder();
        StringBuffer oStringBuffer = new StringBuffer();
        
        File myObj = new File("C:/Users/dell/Desktop/LTGiang/MSV-20194430/OOP/Exercises_Lab/Lab02/OtherProjects/src/hust/soict/globalict/garbage/test.txt");
        Scanner myReader = new Scanner(myObj);

        startTime = System.currentTimeMillis();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            inpuString +=data;
        }
        endTime = System.currentTimeMillis();
        System.out.println("'+' Operator: "+(endTime - startTime));

        Scanner reader = new Scanner(myObj);


        startTime = System.currentTimeMillis();
        while (reader.hasNextLine()) {
            
            String data  = reader.nextLine();
            
            oStringBuilder.append(data);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder: "+(endTime-startTime));

        Scanner reader1 = new Scanner(myObj);


        startTime = System.currentTimeMillis();
        while (reader1.hasNextLine()) {
            
            String data  = reader1.nextLine();
            
            oStringBuffer.append(data);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer: "+(endTime-startTime));
     
    }
    
}
