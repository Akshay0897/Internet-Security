import java.io.*;
import java.lang.*;
// Main operations
      public class SimplifiedDES
      {
       
        public static void main( String args[]) throws Exception
        {
         DataInputStream inp=new DataInputStream(System.in);
         System.out.println("Enter the 10 Bit Key :");
          int K = Integer.parseInt(inp.readLine(),2);
          SDES A = new SDES(K);
          System.out.print("\nKey K1: ");
          SDES.printData( A.K1, 8);
          System.out.print("\nKey K2: ");
          SDES.printData( A.K2, 8);

     }
       
 }