/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_crypto_rsa;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.ProcessBuilder.Redirect.to;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilustr
 */
public class Gencle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BigInteger phi;
        BigInteger p, q, n, a, b;
        BigInteger min, max;
        int t;
        String str;

        Scanner sc = new Scanner(System.in);

        System.out.println("Taille de bloc (multiple de 32)");
        str = sc.nextLine();
        t = Integer.parseInt(str);

        System.out.println("Generation aléatoire de deux entiers premiers :");

        min = new BigInteger("1");
        max = new BigInteger("1");
        for (int i = 0; i < (t / 2); i++) {
            min = min.multiply(Fonctions.TWO);
            max = max.multiply(Fonctions.TWO);
        }
        for (int i = 0; i < 16; i++) {
            max = max.multiply(Fonctions.TWO);
        }

        //Soient deux grands nombres premiers « aléatoirement » choisis : p et q
        do {
            p = Fonctions.randomBigInteger(max, min);
        } while (!Fonctions.estPremierRapide(p, 4));
        do {
            q = Fonctions.randomBigInteger(max, min);
        } while (!Fonctions.estPremierRapide(q, 4));

        System.out.println("clé p :" + p);
        System.out.println("clé q :" + q);

        // Notons : n = p*q et φ = (p-1)*(q-1)
        n = p.multiply(q);
        phi = (p.subtract(Fonctions.ONE)).multiply(q.subtract(Fonctions.ONE));

        System.out.println("n :" + n);
        System.out.println("phi :" + phi);

        //Soient d un grand entier « aléatoirement » choisi, premier avec φ
        do {
            a = Fonctions.randomBigInteger(max, min);
        } while ((Fonctions.pgcd(a, phi)).compareTo(Fonctions.ONE) != 0);

        System.out.println("public key a :" + a);

        b = Fonctions.EuclideEtendu(a, phi);
        BigInteger b1 = a.modInverse(phi);

        /**
         * TODO
         * EuclideEtendu a revoir !! Renvoi des fois des nombres négatifs !!
         */
        System.out.println("private key algo aurel b :" + b);
        
        System.out.println("private key  vrai algo b1 :" + b1);
        
        String ecriture = t+" "+n.toString()+" "+p.toString()+" "+q.toString()+" "+a.toString()+" "+b1.toString();
        creerFichier("essai.priv",ecriture);
        
    }
    
    
    public static void creerFichier(String nomFic, String texte) {
        //on va chercher le chemin et le nom du fichier et on me tout ca dans un String
        String adressedufichier = System.getProperty("user.dir") + "/" + nomFic;

        //on met try si jamais il y a une exception
        try {
            /**
             * BufferedWriter a besoin d un FileWriter, les 2 vont ensemble, on
             * donne comme argument le nom du fichier true signifie qu on ajoute
             * dans le fichier (append), on ne marque pas par dessus              *
             */
            FileWriter fw = new FileWriter(adressedufichier, true);

            // le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
            BufferedWriter output = new BufferedWriter(fw);

            //on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
            output.write(texte);
				//on peut utiliser plusieurs fois methode write

            output.flush();
				//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter

            output.close();
            //et on le ferme
            System.out.println("fichier créé");
        } catch (IOException ioe) {
            System.out.print("Erreur : ");
            ioe.printStackTrace();
        }

    }

 
}
