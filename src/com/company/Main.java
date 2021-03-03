package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//Déclarer les variables du ticket

        //Variable Plat
        String plat;

        //Variable Quantité
        int quantite;

        //Variable prix
        float prix_unitaire;

        //Variable Total de l'adition
        float total_ticket=0;

        //Utilisation d'un tavleau de type liste
        ArrayList<String> plats = new ArrayList<String>();
        ArrayList<Integer> quantites = new ArrayList<Integer>();
        ArrayList<Float> prix_unitaires = new ArrayList<Float>();

        //Ajout de la ligne d'entête
        //plats.add("Quantité | Produit  | Prix total");
        //plats.add("-----------------------------------------------");

        //Lancement du nouveau Ticket de caisse
        System.out.println("Nouveau Ticket de caisse.");

        // On déclare un scanner pour lire les entrées de la console
        Scanner sc = new Scanner(System.in);


        //On lance un boucle permettant de saisir plusieurs plat
        //Dans cette boucle on va demander l'intitulé du plat, la quantité et la prix unitaire
        //Une fois les informations stockées, on calcul le prix total du plat
        //Cette information est additionnée à la variable total_ticket
        //on stocke également les différentes occurences de plats pour affichage final

        int i = 0;
        while (i >= 0) {
            //Tant que le nombre de plat n'est pas atteint, on demande la saisie d'un nouveau plat
            System.out.println("Entrez l'intitulé du plat: ");
            plats.add(sc.nextLine());
            if (plats.get(i).equals("")) {
                break;
            }

            //Saisie de la quantité
            System.out.println("entrez la quantité commandée: ");
            quantites.add(sc.nextInt());
            sc.nextLine();

            //Saisie du prix unitaire
            System.out.println("Entrez le prix unitaire: ");
            prix_unitaires.add(sc.nextFloat());
            sc.nextLine();

            //Stockage de la liste des produits
            //produits = produits + "\n X" + quantite + "   " + plat + "   " + (prix_unitaire * quantite) + " €";
            //plats.add("X" + quantite + "   " + plat + "   " + (prix_unitaire * quantite) + " €");
            prix_unitaires.set(i, prix_unitaires.get(i) * quantites.get(i));
            //Calcul du total
            total_ticket = total_ticket + prix_unitaires.get(i);

            ++i;

        }

        //Test du contenu du ticket
        if (total_ticket == 0){
            System.out.println("Le Ticket est vide, abandon de l'impression");
        }
        else {
            System.out.println("Ticket détaillé:\n-----------------------------------");
            //affichage de la liste
            for (int j = 0; j < quantites.size(); j++) {
                System.out.print("X" + quantites.get(j) + " ");
                System.out.printf("%-20s", plats.get(j));
                System.out.printf("%10s %n", String.format("%.2f", prix_unitaires.get(j)) + "€");
            }
            //Affichage du total de la commande
            System.out.println("----------------------------------- \nTotal de la commande: " + String.format("%.2f", total_ticket) + " €");
        }

        // On ferme le scanner
        sc.close();
    }
}
