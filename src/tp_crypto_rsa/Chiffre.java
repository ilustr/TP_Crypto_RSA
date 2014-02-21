/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_crypto_rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Fichier;

/**
 *
 * @author ilustr
 */
public class Chiffre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String str;
        int compteur = 0;
        String retour = Fichier.lireFichier("essai.priv");
        String variable[] = retour.split(" ");

        int t = Integer.parseInt(variable[0]);
        BigInteger n = new BigInteger(variable[1]);
        BigInteger a = new BigInteger(variable[4]);

        System.out.println("Message à chiffrer: ");
        str = sc.nextLine();
        //// create message by converting string to integer

        byte[] bytes = str.getBytes();
        byte[] temp = new byte[t];
        String messCrypte ="";
        int i = 0;
        while (i < bytes.length) {
            if (compteur == t) {
                BigInteger mess = new BigInteger(temp);
                messCrypte += mess.modPow(a, n);
                compteur = 0;
            } else {
                temp[compteur] = bytes[i];
                compteur++;
                i++;
            }
        }
        if (compteur != 0) {
            BigInteger mess = new BigInteger(temp);
             messCrypte += mess.modPow(a, n);
        }
         System.out.println("Message crypté: " + messCrypte);
         Fichier.creerFichier("crypt.priv",messCrypte);
    }

}
