package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//Déclarer les variables du ticket

        //Référentiel produits
        ArrayList<String> intitule_plat = new ArrayList<String>();
        ArrayList<Float> prix_produits = new ArrayList<Float>();

        //Alimentation du référentiel produits
        intitule_plat.add("Lasagnes");
        intitule_plat.add("Entrcôte");
        intitule_plat.add("Pizza Saumon");
        intitule_plat.add("Café");

        prix_produits.add(16F);
        prix_produits.add(16.90F);
        prix_produits.add(12F);
        prix_produits.add(2.5F);


        //Variable Total de l'adition
        float total_ticket=0;

        //Utilisation de tableaux de type "Arraylist" pour stocker les saisies
        ArrayList<String> plats = new ArrayList<String>();
        ArrayList<Integer> quantites = new ArrayList<Integer>();
        ArrayList<Float> prix_unitaires = new ArrayList<Float>();

        //Lancement du nouveau Ticket de caisse
        System.out.println("Nouveau Ticket de caisse.");

        // On déclare un scanner pour lire les entrées de la console
        Scanner sc = new Scanner(System.in);


        //On lance un boucle permettant de choisir plusieurs plat
        //Dans cette boucle on va demander le numéro du plat et la quantité. Le prix unitaire est récupéré automatiquement
        //Une fois les informations stockées, on calcul le prix total du plat (de la ligne)
        //Cette information est additionnée à la variable total_ticket
        //on stocke également les différentes occurences de plats pour affichage final

        int i = 0;

        while (i >= 0) {
            //Affichage des plats du référentiel
            for (int l=0; l<intitule_plat.size(); l++){
                System.out.println(l+": "+ intitule_plat.get(l) + " - " + prix_produits.get(l));
            }

            //Tant que le numéro du plat n'est pas vide, on continue la saisie
            System.out.println("Séléctionnez un plat: ");
            String index_temp = sc.nextLine();

            if (index_temp == "") {
                break;
            }
            //On transforme la saisie de l'utilisateur en integer pour l'utiliser comme index et récupérer les infos du référentiel
            int index = Integer.parseInt(index_temp);
            plats.add(intitule_plat.get(index));

            //Saisie de la quantité
            System.out.println("entrez la quantité commandée: ");
            quantites.add(sc.nextInt());
            sc.nextLine();

            //Récupération du prix unitaire
            prix_unitaires.add(prix_produits.get(index));


            //Stockage du total prix unitaire par quantité
            prix_unitaires.set(i, prix_unitaires.get(i) * quantites.get(i));

            //Incrémentation du total
            total_ticket = total_ticket + prix_unitaires.get(i);

            //Incrémentation du compteur utilisé pour la manupulation des ArrayList
            ++i;

        }

        //Test du contenu du ticket (Si aucune saisie)
        if (total_ticket == 0){
            System.out.println("Le Ticket est vide, abandon de l'impression");
        }
        else {
            //préparation de la date
            DateFormat formatage = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date_du_jour = new Date();
            System.out.println("Date: " + formatage.format(date_du_jour));
            System.out.println("---------------------------------------------");
            //affichage de la liste
            System.out.println("Ticket détaillé:\n---------------------------------------------");
            for (int j = 0; j < quantites.size(); j++) {
                System.out.print("X" + quantites.get(j) + " ");
                System.out.printf("%-25s", plats.get(j));
                System.out.printf("%15s %n", String.format("%.2f", prix_unitaires.get(j)) + "€");
            }
            //Affichage du total de la commande
            System.out.println("--------------------------------------------- \nTotal de la commande: " + String.format("%.2f", total_ticket) + "€");
        }

        // On ferme le scanner
        sc.close();
    }
}
