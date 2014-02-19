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
public class TP_Crypto_RSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BigInteger a, b;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un nombre :");
        String str = sc.nextLine();
        a = new BigInteger(str);
        System.out.println("Veuillez saisir un nombre :");
        str = sc.nextLine();
        
        b = new BigInteger(str);
        
        
        System.out.println("pgcd de "+a+" et "+b+" est :" + PGCD.pgcd(a, b));
        
        
    }
    
}
