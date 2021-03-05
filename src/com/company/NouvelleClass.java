package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NouvelleClass {
    public static double calcul(double nombre){
        //Première fonction
        double resultat = nombre * 0.394;
        return resultat;
    }
    public static void main(String[] Args){
        System.out.println("test");
        System.out.println(Arrays.toString(Args));

        System.out.println(calcul(17));
    }
}
