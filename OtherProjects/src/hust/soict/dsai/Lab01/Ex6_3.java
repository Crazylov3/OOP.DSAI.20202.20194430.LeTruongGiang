package hust.soict.dsai.Lab01;
import java.util.Scanner;
public class Ex6_3 {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter n: ");
        int n  = sc.nextInt();
        int num = 1;
        for (int i =0; i<n; i++){
            for (int j = 0; j < n-i-1 ; j++){
                System.out.print(" ");
            }
            for (int k=0 ; k< num ; k++){
                System.out.print("*");
            }
            System.out.println("");
            num+=2;
        }
             
        
        
    }   
}