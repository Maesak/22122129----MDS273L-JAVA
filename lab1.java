import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect basic details that fall into different data types and displays them.
        System.out.print("Enter your full name: ");
        String name = input.nextLine();
        
        System.out.print("Enter your current age: ");
        int age = input.nextInt();
        
        System.out.print("Enter your gender - *(m/f): ");
        char gender = input.next().charAt(0);
        
        System.out.print("Enter your region: ");
        input.nextLine();
        String state = input.nextLine();


        //details have been displayed
        System.out.println(" ");
        System.out.println(" ************************** \n   STudent  Details\n **************************");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        //conditions for gender ---> if , else condition!!!
        
        if (gender == 'm'){
            System.out.println("Gender: Male");
        }else if(gender == 'f'){
            System.out.println("Gender: Female");
        } else {
            System.out.println("invalid input");
        }
        
       //conditions for state  --> switch,case condition!!!
       switch(state) {
        case "kerala":
        case "tamilnadu":
        case "andra prathesh":
        case "karnataka":
            System.out.println("The student is from the southern states of India");
            break;
        case "maharastra":
        case "goa":
        case "luckno":
            System.out.println("The student is from the east states of India");
            break;
        case "bengal":
        case "kolkata":
        case "manipur":
            System.out.println("The student is from the west states of India");
            break;
        case "delhi":
        case "himachal pradesh":
        case "rajasthan":
        case "hydrabad":
            System.out.println("The student is from the north states of India");
            break;
       }
        
        
        

    }
}
