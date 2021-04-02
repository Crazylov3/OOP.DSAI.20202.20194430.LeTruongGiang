package hust.soict.dsai.Lab01;

import java.util.Scanner; // import the Scanner class
class Ex2_2_6 {
  public static void main(String[] args) {
      System.out.print("Press 1 if you want to solve the first order, and 2 if want to solve second order: ");
      Scanner scan=new Scanner(System.in);
      int a= scan.nextInt();
      if (a==1){
          System.out.print("Enter the number of equation: ");
          int b= scan.nextInt();
          
          if (b==1){
              System.out.print("Enter a: ");
              float a1= scan.nextFloat();
              System.out.print("Enter b: ");
              float a2=scan.nextFloat();
              System.out.print("Enter c: ");
              float a3=scan.nextFloat();
              
              if (a1==0){
                  if (a2==a3){
                      System.out.println("The equation has infinitely many solutions");
                  }else {System.out.println("The root is: "+ a3/a2);}
                  
              }else{System.out.println("The root is: " + (a3-a2)/a1);}
                     
              }else if (b==2){
                  double[][] arr=new double[b][b+1];
                  for (int i =0; i<2;i++){
                      for (int j = 0; j<3;j++){
                          System.out.print("Enter a"+(i)+(j)+": ");
                          arr[i][j]=scan.nextDouble();
                      }
                  }
                  double d=arr[0][0]*arr[1][1]-arr[1][0]*arr[0][1];
                  double d1=arr[0][2]*arr[1][1]-arr[1][2]*arr[0][1];
                  double d2=arr[0][0]*arr[1][2]-arr[1][0]*arr[0][2];
                  if (d==0){
                      if (d1==0 && d2==0){
                      System.out.println("The equation has infinitely many solutions!");
                      }else{System.out.println("The equation doesnt have solution!");}
                      
                      
                  }else{
                        System.out.println("x: "+d1/d);
                        System.out.println("y: "+d2/d);
                       
                  }
              }
          }else{
            System.out.print("Enter a: ");
            float a_ = scan.nextFloat();

            System.out.print("Enter b: ");
            float b = scan.nextFloat();

            System.out.print("Enter c: ");
            float c = scan.nextFloat();

            float delta= b*b- 4*a_*c;

            if (delta < 0) {
                System.out.println("The quaratic equation doesnt have root");
            }else if (delta==0){
                System.out.println("The equation has a double root: " + -b/(2*a_));
            }else {
                double rdelta=Math.sqrt(delta);
                System.out.println("The equation has 2 distinct root.");
                System.out.println("X1: " + (-b+rdelta)/(2*a_));
                System.out.println("X2: " + (-b-rdelta)/(2*a_));
            } 
        
          
          }
          
      }
     
      
  }

