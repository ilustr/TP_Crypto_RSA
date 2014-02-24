/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_crypto_rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tp_crypto_rsa.Chiffre.cryptMsg;
import utils.Cryptage;
import utils.Fichier;
import utils.Personne;

/**
 *
 * @author ilustr
 */
public class Signature {
    
    public static final String FILENAME_PERSONNE_A = "key_personne_A.priv";
    public static final String FILENAME_PERSONNE_B = "key_personne_B.priv";
    
    public static void main(String[] args) {
        
        int t;
        String str;
        String motAEnvoyer;
        Scanner sc = new Scanner(System.in);
        System.out.println("Taille de bloc (multiple de 8)");
        str = sc.nextLine();
        t = Integer.parseInt(str);
        
        Gencle.createKeys(FILENAME_PERSONNE_A, t);
        Gencle.createKeys(FILENAME_PERSONNE_B, t);
        
        System.out.println("========================================== CREATION DES PERSONNES ==========================================");
        Personne personneA = createPersonne( "Eva", FILENAME_PERSONNE_A);
        Personne personneB = createPersonne( "Nouissement", FILENAME_PERSONNE_B);
        
        System.out.println("Saisissez le mot a envoyer:");
        motAEnvoyer = sc.nextLine();
        t = Integer.parseInt(str);
        
        String motAEnvoyerSha1 = "";
        // Faire Sha1 du mot
        try {
            motAEnvoyerSha1 = Cryptage.encoderEnSHA1(motAEnvoyer);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Signature.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        /////////////////////////////////////////
        // Coté A (Emetteur)
        /////////////////////////////////////////
        // Crypter avec clé publique de B
        System.out.println("========================================== EMISSION ==========================================");
        System.out.println("-------- Cryptage du mot");
        String motAEnvoyerCrypte = Chiffre.cryptMsg(motAEnvoyer, t, personneB.getClePublique(), personneB.getModulus());
        // Crypter Sha1 avec cle privé de A
        System.out.println("-------- Cryptage du Sha1");
        String sha1crypte = Chiffre.cryptMsg(motAEnvoyerSha1, t, personneA.getClePrivee(), personneA.getModulus());
        

        /////////////////////////////////////////
        // Coté B (Recpteur)
        /////////////////////////////////////////
        // Crypter avec clé prive de B
        System.out.println("========================================== RECEPTION ==========================================");
        System.out.println("-------- Decryptage du mot");
        String messageDecrypt = DeChiffre.dcryptMSG(motAEnvoyerCrypte, personneB.getClePrivee(), personneB.getModulus());
        System.out.println("-------- Mot reçu: "+messageDecrypt);
        // Crypter Sha1 avec cle public B
        System.out.println("-------- Deryptage du Sha1");
        String sha1Decrypte = DeChiffre.dcryptMSG(sha1crypte, personneA.getClePublique(), personneA.getModulus());
        

        /////////////////////////////////////////
        // Verification
        /////////////////////////////////////////
        System.out.println("========================================== VERIFICATION DE LA SIGNATURE ==========================================");
        if(Cryptage.compareSHA1(messageDecrypt.trim(), sha1Decrypte))
        {
            System.out.println("-------- Signature OK");
        }
        else
        {
            System.out.println("-------- Signature Invalide");
        }
        
        
    }
    
    
    /**
     * Fonction permettant de créer une personne
     * @param personneName
     * @param fileName
     * @return 
     */
    public static Personne createPersonne(String personneName, String fileName)
    {
        Personne personne = new Personne(personneName);
        
        String retour = "";
        try {
            retour = Fichier.lireFichier(fileName);
        } catch (IOException ex) {
            Logger.getLogger(Signature.class.getName()).log(Level.SEVERE, null, ex);
        }
        String variable[] = retour.split(" ");
        
        personne.setClePrivee(new BigInteger(variable[5]));
        personne.setClePublique(new BigInteger(variable[4]));
        personne.setModulus(new BigInteger(variable[1]));
        
        return personne;
    }
}
