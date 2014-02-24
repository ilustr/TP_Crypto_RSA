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
import utils.Fichier;

/**
 *
 * @author ilustr
 */
public class Gencle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createKeys("essai.priv");
        
    }

    public static void createKeys(String filename) throws NumberFormatException {
        int t;
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Taille de bloc (multiple de 32)");
        str = sc.nextLine();
        t = Integer.parseInt(str);
        
        createKeys(filename, t);
    }

    public static void createKeys(String filename, int tailleBloc) throws NumberFormatException {
        BigInteger phi;
        BigInteger p, q, n, a, b;
        BigInteger min, max;
        int t = tailleBloc;
        
        System.out.println("----------------------------- GENERATION DE CLES -----------------------------");
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
        System.out.println("-------- p :" + p);
        System.out.println("-------- q :" + q);
        // Notons : n = p*q et φ = (p-1)*(q-1)
        n = p.multiply(q);
        phi = (p.subtract(Fonctions.ONE)).multiply(q.subtract(Fonctions.ONE));
        System.out.println("-------- n: " + n);
        System.out.println("-------- phi: " + phi);
        //Soient d un grand entier « aléatoirement » choisi, premier avec φ
        do {
            a = Fonctions.randomBigInteger(max, min);
        } while ((Fonctions.pgcd(a, phi)).compareTo(Fonctions.ONE) != 0);
        System.out.println("-------- Clé publique a: " + a);
        b = Fonctions.EuclideEtendu(a, phi);

        System.out.println("-------- Clé privée b: " + b);
        String ecriture = t+" "+n.toString()+" "+p.toString()+" "+q.toString()+" "+a.toString()+" "+b.toString();
        Fichier.creerFichier(filename,ecriture);
    }
 
}
