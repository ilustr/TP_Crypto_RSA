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
        String str ;
        
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("Veuillez saisir un nombre :");
        str = sc.nextLine();
        a = new BigInteger(str);
        System.out.println("Veuillez saisir un nombre :");
        str = sc.nextLine();
        
        b = new BigInteger(str);
        
        
        System.out.println("pgcd de "+a+" et "+b+" est :" + Fonctions.pgcd(a, b));*/
        
        /////////////////////////////////////////////////////
        // test hecka
        /////////////////////////////////////////////////////
        
        BigInteger varTest = new BigInteger("2147483647");
        
        if(Fonctions.estPremierLent(varTest)){
            System.out.println("Il est premier !!!!");
        }else{
            System.out.println("=(");
        }

        if(Fonctions.estProbablementPremier(varTest)){
            System.out.println("Il est PROBABLEMENT premier !!!!");
        }else{
            System.out.println("PROBABLEMENT =(");
        }
    }
    
}
