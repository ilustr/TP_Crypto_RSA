/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_crypto_rsa;

import com.sun.imageio.plugins.common.BogusColorSpace;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.ProcessBuilder.Redirect.to;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilustr
 */
public class DeChiffre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BigInteger phi = null;
        BigInteger p = null, q = null, n = null, a = null, b = null;
        int t = 0;
        
        String adressedufichier = System.getProperty("user.dir") + "/essai.priv";

        try {

            FileReader fr = new FileReader(adressedufichier);

            BufferedReader input = new BufferedReader(fr);

            String file = input.readLine();
            
            input.close();
            
            String keys[] = file.split(" ");
            
            t = Integer.parseInt(keys[0]);
            n = new BigInteger(keys[1]);
            p = new BigInteger(keys[2]);
            q = new BigInteger(keys[3]);
            a = new BigInteger(keys[4]);
            b = new BigInteger(keys[5]);
        
        } catch (IOException ioe) {
            System.out.print("Erreur : ");
            ioe.printStackTrace();
        }

        
        String clair = "";

        Scanner sc = new Scanner(System.in);

        BigInteger[] code = new BigInteger[200];
        
        for (BigInteger crypt : code) {
            crypt = Fonctions.pow(crypt, b);
            crypt = crypt.modInverse(n);
            
        }
        
    }
    
}
