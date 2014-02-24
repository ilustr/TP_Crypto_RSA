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
        
        String retour = Fichier.lireFichier("essai.priv");
        String variable[] = retour.split(" ");

        System.out.println("Message à chiffrer: ");
        str = sc.nextLine();
        
        int t = Integer.parseInt(variable[0]);
        BigInteger n = new BigInteger(variable[1]);
        BigInteger a = new BigInteger(variable[4]);
        
        String msgCrypt = cryptMsg( str, t, a, n);
        
        Fichier.creerFichier("crypt.priv",msgCrypt);
    }

    public static String cryptMsg(String msg, int t, BigInteger key, BigInteger n) {
        //// create message by converting string to integer
        System.out.println("----------------------------- CRYPTAGE MESSAGE -----------------------------");
        int compteur = 0;
        byte[] bytes = msg.getBytes();
        byte[] temp = new byte[t/8];
        String messCrypte ="";
        int i = 0;
        
        while (i < bytes.length) {
            if (compteur == t/8) {
                BigInteger bloc = new BigInteger(temp);
                messCrypte += bloc.modPow(key, n)+" ";
                compteur = 0;
                temp = new byte[t/8];
            } else {
                temp[compteur] = bytes[i];
                compteur++;
                i++;
            }
        }
        
        if (compteur != 0) {
            BigInteger mess = new BigInteger(temp);
            messCrypte += mess.modPow(key, n);
        }
        
        System.out.println("-------- Message crypté: " + messCrypte);
        
        return messCrypte;
    }

}
