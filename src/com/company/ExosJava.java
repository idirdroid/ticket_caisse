package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExosJava {

    public static void main(String[] Args){

        //déclaration du scanner global
        Scanner scan = new Scanner(System.in);

        //On affiche le menu pour la première fois
        boolean isFirstLaunch = true;
        afficheMenu(scan, isFirstLaunch);

    }


    private static void afficheMenu(Scanner scan, boolean isFirstLaunch) {
        boolean programEnd = false;
        do {
            if(isFirstLaunch != true){
                System.out.println("Taper \"Entrer\" pour continuer");
                scan.nextLine();
                //Ce ne sera plus le premier lancement pour la suite

            }
            isFirstLaunch = false;
            //Gestion de l'affichage du menu'
            System.out.println("Choisissez votre Programme");
            System.out.println("--------------------------");
            System.out.println("1. - Nombre premier");
            System.out.println("2. - Annee bissextile");
            System.out.println("3. - Factoriel d'un nombre");
            System.out.println("4. - Quitter le programme");
            System.out.println("--------------------------");

            //Lecture de l'entier avec vérification

            int choise = getInput(scan,"Votre choix? ");

            switch (choise){
                case 1: {
                    System.out.println("Lancement du test Nombre Premier");
                    //Appel de la fonction
                    isPrime(scan);
                    break;
                }
                case 2: {
                    System.out.println("Lancement de Test année Bissextile");
                    //Appel de la fonction
                    isBisextile(scan);
                    break;
                }
                case 3: {
                    System.out.println("Lancement du factoriel d'un nombre");
                    //Appel de la fonction
                    isFactoriel(scan);
                    break;
                }
                default: programEnd = true;
            }
        } while(!programEnd);

    }

    private static int getInput(Scanner scan, String message) {
        boolean state = false;
        int numberInput = -1;
        do{
            System.out.println(message);
            if(scan.hasNextInt()){
                state = true;
                numberInput = scan.nextInt();
            }else{
                System.err.println("Error - you must provide an integer");
                scan.nextLine();
            }
        } while(!state);

        return numberInput;
    }

    private static void isFactoriel(Scanner scan) {
        int number = getInput(scan, "Entrer le nombre a factoriser: ");

        int factorielResult = 1;
        String printResult = "";
        for (int i =1; i<= number; i++){
            printResult = printResult + i + " * ";
            factorielResult = factorielResult * i;
        }

        System.out.println("Le factoriel de "+ number + " est " + factorielResult);
        System.out.println("Décomposition: "+ printResult);
    }

    private static void isBisextile(Scanner scan) {
        System.out.println("Entrer l'année a tester: ");
        int annee = scan.nextInt();
        scan.nextLine();

        if((annee % 400 == 0) || ((annee % 4 == 0) && (annee % 100 != 0))){
            System.out.println("L'annee " + annee + " est bissextile");
        }
        else{
            System.out.println("L'annee " + annee + " n'est pas bissextile");
        }
    }

    private static void isPrime(Scanner scan){
        //Fonction nombre premier
        boolean result = true;

        System.out.println("Entrer le nombre entier a tester: ");
        int nb = scan.nextInt();
        scan.nextLine();

        for(int i=2; i <= (nb/2) && result; i++) {
            //nombre est divisible par lui-meme
            int reste = nb % i;

            //si le reste est 0.
            if (reste == 0) {
                result = false;
            }
        }

        //Test du resultat
        if (result){
            System.out.println(nb + " est un nombre premier");
        }
        else {
            System.out.println(nb + " n'est PAS un nombre premier");
        }



    }


}
