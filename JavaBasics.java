import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class JavaBasics{
    public static int inputArray [];//= new int[50];

    public static void main(String [] args){
        System.out.println("Hello World");                                  //Create Array of type int

        readFile();
        System.out.println("The unsorted array has values: \n"+inputArray);
        sortArrayAsc(inputArray);
        System.out.println("The Sorted array has values: \n"+inputArray);
    }
    
    public static void readFile(){
        try{
            String basepath = new File("").getAbsolutePath();
            //System.out.println(basepath);
            File input = new File(basepath+"\\input.txt");                  //Create readible File object
            

            InputStream reader = new FileInputStream(input);
            int i =0;
            inputArray = new int[reader.available()];

            System.out.println("The empty array has values: \n"+inputArray);
            while(reader.read()!=-1){
                inputArray[i] = reader.read();
                i++;
            }
            System.out.println("Successfully read data from file");
        }catch (Exception e){
            System.out.println("Could not read file because reason: "+ e);
        }
    }

    public static int[] sortArrayAsc(int inputArray[]){
        int val1=0;
        int val2=0;
        int length=inputArray.length;

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