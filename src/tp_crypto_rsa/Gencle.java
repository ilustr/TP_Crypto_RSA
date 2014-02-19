/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_crypto_rsa;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author ilustr
 */
public class Gencle {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigInteger a, b, t;
        String str ;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Taille de bloc (multiple de 32)");
        str = sc.nextLine();
        t = new BigInteger(str);
        
        System.out.println("Generation aléatoire de deux entiers premiers :");
        
        //System.out.println("euclide étendu de "+a+" et "+b+" est :" + Fonctions.EuclideEtendu(a, b));
    }
    
}
