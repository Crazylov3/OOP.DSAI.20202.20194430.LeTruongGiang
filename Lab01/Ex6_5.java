import java.util.Scanner;
public class Ex6_5 {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of elements of the array: ");
        int n  = sc.nextInt();
        double[] arr =new double[n];
        for (int i = 0; i<n ;i++){
            System.out.print("Enter the element "+i+"-th: ");
            arr[i]=sc.nextDouble();    
        }
        for (int i = 1; i<n ;i++){
            for(int j=i-1;j>=0;j--){
                if (arr[j] > arr[j+1]){
                   double temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;  
                }else break;

            } 
        }
        double sum=0;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+", ");
            sum+=arr[i];
        }
        System.out.println("Sum: "+sum);
        System.out.println("Average value: "+sum/n);

    }
}
