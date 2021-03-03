package com.company;

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

        //Variable des plats/Qté/Prix pour affichage du ticket
        String produits = "Produit | Quantité | Prix total";

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
        while (i == 0) {
            //Tant que le nombre de plat n'est pas atteint, on demande la saisie d'un nouveau plat
            System.out.println("Entrez l'intitulé du plat: ");
            plat = sc.nextLine();
            if (plat == "") {
                i++;
                break;
            }

            //Saisie de la quantité
            System.out.println("entrez la quantité commandée: ");
            quantite = sc.nextInt();
            sc.nextLine();

            //Saisie du prix unitaire
            System.out.println("Entrez le prix unitaire: ");
            prix_unitaire = sc.nextFloat();
            sc.nextLine();

            //Stockage de la liste des produits
            produits = produits + "\n" + plat + " | " + quantite + " | " + (prix_unitaire * quantite) + " €";

            //Calcul du total
            total_ticket = total_ticket + (prix_unitaire * quantite);

        }


        //Affichage des plats
        System.out.println(produits);

        //Affichage du total de la commande
        System.out.println("\n Total de la commande: " + total_ticket + " €");

        // On ferme le scanner
        sc.close();
    }
}
