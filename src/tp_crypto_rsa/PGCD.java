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
    
    public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while (b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }

    public static boolean estPremierLent(BigInteger n) {

        BigInteger varZero = new BigInteger("0");
        BigInteger varI = new BigInteger("3");
        BigInteger varTemp = new BigInteger("2");
        BigInteger m = sqrt(n);

        if (n.mod(varTemp).compareTo(varZero) == 0) {
            return (n.compareTo(varTemp) == 0);
        }
        while (varI.compareTo(m) != 1) {
            if ((n.mod(varI)).compareTo(varZero) == 0) {
                return false;
            }
            varI = varI.add(new BigInteger("2"));
        }
        return true;
    }

   /* public static boolean estProbablementPremier (BigInteger n)
    {
        
    }*/
}
