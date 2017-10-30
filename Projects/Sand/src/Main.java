
import java.io.*;

public class Main {

    static String reverse(String s){
        String reversed;
        //the reverse of string abcd is the reverse of this string d(abc)

        return reversed;
    }

    public static void main(String[] args) {
        int ans = fact(3);


    }

    public int fact(int num){

        if(num==0){
            return 1;
        }
        int factOfRest = fact(num-1);
        return num*factOfRest;
    }

}//class Main
