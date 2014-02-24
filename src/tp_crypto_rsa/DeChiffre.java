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
import utils.Fichier;

/**
 *
 * @author ilustr
 */
public class DeChiffre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BigInteger n, b;
        int t = 0;
        
        String retour = "";
        try {
            retour = Fichier.lireFichier("essai.priv");
        } catch (IOException ex) {
            Logger.getLogger(DeChiffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String adressedufichier = System.getProperty("user.dir") + "/essai.priv";
        String keys[] = retour.split(" ");

        t = Integer.parseInt(keys[0]);
        n = new BigInteger(keys[1]);
        b = new BigInteger(keys[5]);

        String msgCrypt = "";
        try {
            retour = Fichier.lireFichier("crypt.priv");
        } catch (IOException ex) {
            Logger.getLogger(DeChiffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        String clair = dcryptMSG(retour, b, n);
        
        System.out.println("clair =>" + clair);
    }

    public static String dcryptMSG(String msgCrypt, BigInteger b, BigInteger n) {
        System.out.println("----------------------------- DECRYPTAGE MESSAGE -----------------------------");
        String clair = "";
        String tbMSGCrypt[] = msgCrypt.split(" ");
        for (String strCrypt : tbMSGCrypt) {
            
            BigInteger crypt = new BigInteger(strCrypt);
            crypt = crypt.modPow(b, n);
            
            byte val[] = crypt.toByteArray();
            
            clair += new String(val);
            
        }
        return clair;
    }
    
}
