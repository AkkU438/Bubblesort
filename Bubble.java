import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Bubble {
    public static void main(String[] args){
        System.out.println("1: create a random array store it into a file, 2: take array from a file and sort");
        Scanner number = new Scanner(System.in);
        int lmao = number.nextInt();
        switch(lmao) {
            case 1: 
            System.out.println("Enter the length of the array");
        
            Scanner myObj = new Scanner(System.in);
            int arrayLength = myObj.nextInt();

            createRandomArray(arrayLength); 
            

            break;
            case 2:
            System.out.println("Please write out the name of the file");
            Scanner myName1 = new Scanner(System.in);
            String name1 = myName1.nextLine();
            
            int[] numbers = readFileToArray(name1);
            bubbleSort(numbers);
            System.out.println("Please write out the name of the file");
            Scanner myName2 = new Scanner(System.in);
            String name2 = myName2.nextLine();
            writeArrayToFile(numbers, name2);


            break;
            
            default:
            System.out.println("Do you want to array to file?");
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
    
            int[] arr = new int[size];
    
            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                arr[i] = scanner.nextInt();
            }
    
            System.out.println("The array elements are:");
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println("Please write out the name of the file");
            Scanner myName = new Scanner(System.in);
            String name = myName.nextLine();
            writeArrayToFile(arr, name);
            readFileToArray("filename.txt");
            break; 
        }


        




    }
//Ends of the main program
public static void createRandomArray(int arrayLength) {
    Random random = new Random();
    int[] randomArray = new int[arrayLength]; 

    for (int i = 0; i < arrayLength; i++) {  
     
        randomArray[i] = random.nextInt(100); 
        System.out.print(randomArray[i] + " ");
    }
    Scanner myObj1 = new Scanner(System.in);
    System.out.println("");
    System.out.println("What is the name of the file");
    String nameString = myObj1.nextLine();
    writeArrayToFile(randomArray, nameString);
}

//End of the create random array function (finished)
    public static void writeArrayToFile(int[] array, String filename){
        

        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
        
            for (int num : array) {
              bufferedWriter.write(Integer.toString(num));
              bufferedWriter.newLine(); // Add a newline character after each integer
            }
        
            bufferedWriter.close();
            System.out.println("Array written to file: " + filename);
          } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
          }
    }


    
//End of the write array to file function


    public static int[] readFileToArray(String filename) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    numbers.add(number);
                    System.out.print(number + " ");
                    System.out.println("");
                } catch (NumberFormatException e) {
                    System.err.println("Invalid integer format in line: " + line); // Log or handle invalid lines
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            return new int[0]; // Return an empty array on error
        }
        
        return numbers.stream().mapToInt(Integer::intValue).toArray(); // Efficient conversion to int array
    }


public static void bubbleSort(int[] array){
    int n = array.length;
    boolean swapped;
    do {
        swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                // Swap elements
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                swapped = true;
            }
        }
        // Optimization: Largest element is in place, so reduce the array size for next pass
        n--;
    } while (swapped);

}
//End of the bubble function


}
