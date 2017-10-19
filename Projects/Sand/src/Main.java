
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        Scanner kb = new Scanner(in);

        out.print("Enter a number: ");
        int num = kb.nextInt();
        int factors = 0;
        int h =0;


        for (int i = 1; i<=num ; ++i){
            h = num%i;
            System.out.println(num+"%"+i+" = "+h);
            if(num%i==0){
                factors++;
                System.out.println("\n\nfactors:"+factors);
            }

        }

        if (factors==2){
            out.println("Prime!");
        }else{
            out.println("Not P");
        }



    }

}//class Main
