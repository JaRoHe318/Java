
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i <1000000 ; i++) {
            list.add(0,i);
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);



    }



}//class Main
