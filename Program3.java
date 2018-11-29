// Madison Micklas
// CIS 2353 Data Structures
// Fall 2018
// Prof John P. Baugh

package program3;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Program3 {
    
    enum SortType { QUICK, INSERTION } // this is just for funsies i guess
    
    // Set your requirements for your round of testing here
    static int SET_SIZE = 250;
    static SortType SORT_TYPE = SortType.QUICK;
    static String fileName = "integers_b.txt";
    
    public static void main(String[] args) throws IOException {
        
        // Read integers from file
        Scanner s = new Scanner(new File(fileName));
        int[] intArray;
        intArray = new int[SET_SIZE];
        for (int i = 0; i < SET_SIZE; i++) {
            int tempInt = Integer.parseInt(s.nextLine());
            intArray[i] = tempInt;
        }
        
        // Debug purposes
        System.out.println("Printing intArray before sorting: (" + SET_SIZE + " elements)");
        printArray(intArray);      

        ////////////////// Time and report back //////////////////
        
        long startingTime = System.currentTimeMillis();     //ms
        long total = 0;                                     //ms
        long startTime = System.nanoTime();                     //ns   
        
        if(SORT_TYPE == SortType.QUICK) {
            //System.out.println("Quick sorting...");
            System.out.println("Using Arrays.sort...");
            Arrays.sort(intArray);
        } else {
            System.out.println("Insertion sorting...");
            insertionSort(intArray);
        }
        
        long elapsedNano = System.nanoTime() - startTime;       //ns   
        long stoppingTime = System.currentTimeMillis();     //ms
        long elapsedMilli = stoppingTime - startingTime;    //ms
        
        // Debug purposes
        System.out.println("Printing intArray after sorting: (" + SET_SIZE + " elements)");
        printArray(intArray);
        
        report(elapsedMilli, elapsedNano);
     
    }
    
    static void printArray(int arr[]) {
        for (int i = 0; i < SET_SIZE - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[SET_SIZE - 1]);
    }
    
    static void insertionSort(int arr[]) { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i-1; 
  
            while (j>=0 && arr[j] > key) { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    } 
    
    static void report(long elapsedMilli, long elapsedNano) {
        String sortMethod;
        switch (SORT_TYPE) {
            case QUICK:
                sortMethod = "Quick sort";
                break;
            case INSERTION:
                sortMethod = "Insertion sort";
                break;
            default:
                sortMethod = "Idk but I think something is borked";
                break;
        }
        
        System.out.println("Summary:" +
                "\nData set used: " + fileName + 
                "\nSort method: " + sortMethod +
                "\nElements: " + SET_SIZE +
                "\nElapsed time in ns: " + elapsedNano + " ns" +
                "\nElapsed time in ms: " + elapsedMilli + " ms"
                );
    }
      
}