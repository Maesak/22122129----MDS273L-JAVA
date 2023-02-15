import java.util.Arrays;
import java.util.Scanner;

public class lab3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
System.out.println("************************** \n    creating the Array");
System.out.println("**************************");       
System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("************************** \n    size of the array!");
        System.out.println("**************************"); 
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("**************************"); 
        System.out.println("  "+n+" sized array created!");
        System.out.println("************************** \n    Select an option:");
        System.out.println("**************************"); 

        System.out.println("1. Find the Mean Value");
        System.out.println("2. Find the Median Value");
        System.out.println("3. Find the Mode Value");
        System.out.println("**************************"); 
        int choice = scanner.nextInt();
        System.out.println("**************************"); 
        
        switch (choice) {
            case 1:
                double mean = findmean(array);
                System.out.println("     Mean value: " + mean);
                break;
            case 2:
                double median = findmedian(array);
                System.out.println("     Median value: " + median);
                break;
            case 3:
                int mode = findmode(array);
                System.out.println("     Mode value: " + mode);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        System.out.println("**************************"); 
        scanner.close();
    }

    public static double findmean(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
    
    public static double findmedian(int[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            int mid = array.length / 2;
            return (double) (array[mid - 1] + array[mid]) / 2;
        } else {
            int mid = array.length / 2;
            return array[mid];
        }
    }
    
    public static int findmode(int[] array) {
        int mode = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                mode = array[i];
                maxCount = count;
            }
        }
        return mode;
    }
}

