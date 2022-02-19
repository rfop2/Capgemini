import static org.junit.Assert.assertEquals;

import java.io.*;
 

public class Pyramide
{

    public static void printStars(int n)
    {
        int i, j;
        
        // numero de linhas n
        for(i=1; i<=n; i++)
        {
 
            // loop para produzir os espacos
            // os valores mudam de acordo com n
            for(j=i; j<(n*2)-n; j++)
            {
                
                System.out.print(" ");
            }
            
            //  loop para produzir o numero de colunas
            //  os valores aumenta de acordo com o loop maior
            for(j=1; j<=i; j++)
            {
                // printing stars
                System.out.print("*");
            }
             
            
            System.out.println();
        }
    }
 
    public static void main(String args[])
    {
        int n = 6;
        printStars(n);
    }
}