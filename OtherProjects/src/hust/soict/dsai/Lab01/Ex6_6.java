package hust.soict.dsai.Lab01;
import java.util.Scanner;
public class Ex6_6 {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int m  = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int n  = sc.nextInt();
        double[][] arr =new double[m][n];
        double[][] arr2= new double[m][n];
        for (int i = 0; i<m ;i++){
            for (int j =0; j<n;j++){
                System.out.print("Enter the element A"+(i)+(j) +" of matrice A:");
                arr[i][j]=sc.nextDouble();
            }
        }
        for (int i = 0; i<m ;i++){
            for (int j =0; j<n;j++){
                System.out.print("Enter the element B"+(i)+(j) +" of matrice B:");
                arr2[i][j]=sc.nextDouble();
            }
        }
        for (int i = 0; i<m ;i++){
            for (int j =0; j<n;j++){
                arr[i][j]+=arr2[i][j];
            }
        }
        for (int i = 0; i<m ;i++){
            for (int j =0; j<n;j++){
                System.out.print(arr[i][j]+" ");    
            }
            System.out.println(" ");
        }
            
             
        
        
        }   
}