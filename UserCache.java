import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;  

public class UserCache {
   public static void main(String[] args) throws IOException {
      LRUCache<Integer> cache = new LRUCache<>(3);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      
      int choice = 1; 
      while(choice != 0){ 
         System.out.println("1: Put\n2: Get\n0: Exit");
         choice = Integer.parseInt(br.readLine());
         String key;
         int value; 
         switch (choice){
            case 1: 
               System.out.println("Enter key");
               key = br.readLine();
               System.out.println("Enter value");
               value = Integer.parseInt(br.readLine());
               cache.put(key, value);
               System.out.println("Inserted\n");
               break; 
         
            case 2://Posible cache memory
            
            //Access to the key and value
               System.out.println("Enter key");
               key = br.readLine();
               System.out.println("Value is: " + cache.get(key).toString() + "\n");
               
             // returns the current value of the system timer, in nanoseconds
               double round;//Saves the nanosecond in a double variable
               System.out.println("Tiempo acceso cache = ");
               System.out.println(System.nanoTime());
               round = Math.ceil(System.nanoTime());//Rounds up the nanoseconds
             //String strNano = String.valueOf(round);
             break;
             
            case 0://Exist program
               System.out.println("Adios amigos!\n");
         }
      }
   }
}