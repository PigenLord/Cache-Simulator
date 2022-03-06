import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*; 
import java.util.*;
import java.lang.*; 

public class UserCache 
{

   final static String outputFilePath = "E:/HashMapPrueba/CacheMemory.txt";

   String fileName = "MainMemory";
   public static void main(String[] args) throws IOException 
   {
      LRUCache<Integer> cache = new LRUCache<>(3);//HashMap for Cache
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Scanner input = new Scanner(System.in);
        
      int choice = 1,
          value,
          tiempoCache,
          tiempoMain,
          tiempoTranscurrido;
     
      String strRequired,
             strFound,//Hit o Miss Mensaje
             strStatus,//Mensaje del Status
             strPagina;//Va a tener el valor del Key para saber la Pagina
      boolean found = false;
      
      /*Cache HashMap
      cache.put(00,3);
      cache.put(01,2);
      cache.put(02,1);
      cache.put(03,0);*/
   
      
      while(choice != 0)
      { 
         System.out.println("1: Put\n2: Get\n0: Exit");
         choice = Integer.parseInt(br.readLine());
         String key;
         
                          
         for(int i = 0; i <= 4; i++)
         {
            //System.out.println("Enter key");
            key = Integer.toString(i);
            System.out.println("Enter value");
            value = Integer.parseInt(br.readLine());
            cache.put(key, value);
            System.out.println("Inserted\n");              
         }                
      
         switch (choice)
         {
         
            case 1://Create the key and value
               
               System.out.println("Tiempo acceso cache: ");
               System.out.println("Tiempo acceso main: ");
               System.out.println("Algoritmo reemplazo: LRU");
               System.out.println("Se requiere: ");//Pregunta al usuario que quiere buscar en el cache
               strRequired = input.nextLine();
            
               if(found == true)//Condicion para indicar si es un Hit/Miss
               {
                  strFound = "Hit";
               }
               else
               {
                  strFound = "Miss";
               }
               System.out.println("Resultado: " + strFound);//Detecta si es un Hit o un Miss
               System.out.println("Tiempo transcurrido: ");
               
               if(found == true)//Condicion para determinar el status del sistema
               {
                  strStatus = "No sustitucion";
               }
               else
               {
                  strStatus = "Escribir en pagina "; //+ strPagina;
                  //cache.put(key,required);
               }
               System.out.println("Status del sistema: ");//Avisa que se hara en el cache+
               
            
               break; 
         
            case 2://Posible cache memory. Search key and value
            
            //Access to the key and value
               System.out.println("Enter key");
               key = br.readLine();
               System.out.println("Value is: " + cache.get(key).toString() + "\n");
               
             /* returns the current value of the system timer, in nanoseconds
               double round;//Saves the nanosecond in a double variable
               System.out.println("Tiempo acceso cache = ");
               System.out.println(System.nanoTime());
               
               round = Math.ceil(System.nanoTime());//Rounds up the nanoseconds           
               String strNano = String.valueOf(round);
            
               round = System.nanoTime();//No borrar
               System.out.println("Tiempo acceso cache redonde = " + strNano);*/  
                             
               break;
                              
            case 0://Exist program
               System.out.println("Adios amigos!\n");
         }
      }
   }
}