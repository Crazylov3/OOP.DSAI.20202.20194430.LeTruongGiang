import java.util.Scanner;
public class Ex6_4{
    public static void main(String[]args){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the month: ");
        String m=sc.next();
        System.out.print("Year?: ");
        int y=sc.nextInt();
 
        if (m.equals("January") || m.equals("Jan.") || m.equals("Jan") || m.equals("1")){
            System.out.println("Days of month: 31");
        }else if (m.equals("February") || m.equals("Feb.") || m.equals("Feb") || m.equals("2")){
            if ((y%100)%4==0){
                System.out.println("Days of month: 29");
            }else{System.out.println("Days of month: 28");}
        }else if (m.equals("March") || m.equals("Mar.") || m.equals("Mar") || m.equals("3")){
            System.out.println("Days of month: 31");
        }else if (m.equals("April") || m.equals("Apr.") || m.equals("Apr") || m.equals("4")){
            System.out.println("Days of month: 30");
        }else if (m.equals("May") || m.equals("5")){
            System.out.println("Days of month: 31");
        }else if (m.equals("June") || m.equals("Jun") || m.equals("6")){
            System.out.println("Days of month: 30");
        }else if (m.equals("July") || m.equals("Jul") || m.equals("7")){
            System.out.println("Days of month: 31");
        }else if (m.equals("August") || m.equals("Aug.") || m.equals("Aug")||m.equals("8")){
            System.out.println("Days of month: 31");
        }else if (m.equals("September") || m.equals("Sep.")||m.equals("Sep")||m.equals("9")){
            System.out.println("Days of month: 30");
        }else if (m.equals("October") || m.equals("Oct.") || m.equals("Oct") || m.equals("10")){
            System.out.println("Days of month: 31");
        }else if (m.equals("November") || m.equals("Nov.") || m.equals("Nov") || m.equals("11")){
            System.out.println("Days of month: 30");
        }else if (m.equals("December") || m.equals("Dec.") || m.equals("Dec") || m.equals("12")){
            System.out.println("Days of month: 31");
        }
        
        
    }
}