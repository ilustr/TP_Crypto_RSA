/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_crypto_rsa;

import java.math.BigInteger;

/**
 *
 * @author ilustr
 */
public class PGCD {
    
    public static BigInteger pgcd(BigInteger m, BigInteger n)
    {
        BigInteger zero = new BigInteger("0");
        BigInteger r;
        
        while ( n.compareTo(zero) != 0) {
            r = m.mod(n);
            m = n;
            n = r;
        }
        return m;
    }
    
    public static BigInteger exponentiation(BigInteger b,BigInteger c,BigInteger n)
    {
        BigInteger r = new BigInteger("1");
        BigInteger deux = new BigInteger("2");
        BigInteger un = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        
        while(c.compareTo(zero) != 0) {
            if(c.and(r).compareTo(un) == 0)
            {
                r = r.multiply(b).mod(n);
            }
            c.divide(deux);
            b = b.multiply(b).mod(n);
        }
        return r;
    }
    
   /* public static boolean estProbablementPremier (BigInteger n)
    {
        
    }*/
}
