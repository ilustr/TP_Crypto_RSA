/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_crypto_rsa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ilustr
 */
public class Chiffre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str;
        int t;
        int start = 0;

        System.out.println("Taille de bloc (multiple de 32)");
        str = sc.nextLine();
        t = Integer.parseInt(str);

        System.out.println("Message à chiffrer: ");
        str = sc.nextLine();
        ArrayList<String> buffer = new ArrayList<>();

        while (start + t < str.length()) {
            buffer.add(str.substring(start, t));
            start = start + t;
        }
        buffer.add(str.substring(start, str.length() - start));
        
        // Crypter avec le a qui est dans le fichier lire le fichier pour récuperer les valeurs sa serait plus intelligent
    }

}
