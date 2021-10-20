import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class JavaBasics{
    public static int[] arr;
    public static int length; 
    // public static int arr[] = {25,65,85,9,6,25,656,6456,156,65,46,9,23,6,456};

    public static void main(String [] args){
        System.out.println("Enter your Name:");
        Scanner in = new Scanner(System.in);                //Scanner for input
        String name = in.nextLine();

        
        System.out.println("Hello "+ name);                                  
        readFile();
        System.out.println("The unsorted array has values: ");
        for(int i =0; i<length; i++){
            System.out.println(arr[i]);                     //print all values in array
        }
        sortArrayAsc(arr);
        System.out.println("The Sorted array has values: ");
        for(int i =0; i<length; i++){
            System.out.println(arr[i]);                     //print all values in array
        }
        writeFile();
    }
    
    public static void readFile(){
        try{
            String basepath = new File("").getAbsolutePath();   //Get Absolute path to parent dir
            System.out.println(basepath);
            FileInputStream reader = new FileInputStream(basepath+"\\input.txt");   //add filename to dir, pass to FileInputStream Object

            int i =0;
            length=reader.available()/4;                        //Get amount of ints in the file
            arr= new int[length];                               //Set length of array to match incoming data
            System.out.println(length);                         //Display number of Ints in file, 4Byte sized spaces
            Scanner scnr = new Scanner(reader);                 //initialise scanner
            System.out.println("The empty array has values:");
            for(i =0; i<length; i++){
                System.out.println(arr[i]);
            }
            i =0;
            while(scnr.hasNext()){                              //As long as there are more values, read
                arr[i] = scnr.nextInt();
                i++;
            }
            System.out.println("Successfully read data from file");
            scnr.close();
        }catch (Exception e){
            System.out.println("Could not read file because reason: "+ e);
            
        }
    }

    public static void writeFile(){
        try{
            String basepath = new File("").getAbsolutePath();
            FileWriter writer = new FileWriter(basepath+"\\output.txt");

            int i=0;
            for(i =0; i<length; i++){
                writer.append(arr[i]+"\n");                 //Append to output file
            }
            writer.close();
        }catch (Exception  e){
            System.out.println("Writing Failed due to reason: "+e);
        }
    }

    public static int[] sortArrayAsc(int inputArray[]){
        int val1=0;
        int val2=0;
        int length=inputArray.length;
        //Bubble sort
        for(int i=0;i+1<=length;i++){
            for(int j=i+1;j+1<=length;j++){
                if(inputArray[j]<inputArray[i]){
                    val1= inputArray[j];
                    val2 = inputArray[i];
                    inputArray[j]=val2;
                    inputArray[i]= val1;
                }
            }
        }
        return inputArray;
    }
    
}