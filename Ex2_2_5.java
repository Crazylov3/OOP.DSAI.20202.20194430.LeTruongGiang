import java.util.Scanner; // import the Scanner class
class Main {
  public static void main(String[] args) {
      
      Scanner scan=new Scanner(System.in);
      
      System.out.print("Enter a: ");
      float a = scan.nextFloat();
     
      System.out.print("Enter b: ");
      float b = scan.nextFloat();
      
      System.out.println("Sum: "+ (a+b));
      System.out.println("Difference:" + (a-b));
      System.out.println("Product:" + a*b);
      if (b==0){
          System.out.println("Divisor equals zero.");}
      else {
          System.out.println("Quotient:"+a/b);}
      } 
 
}     
