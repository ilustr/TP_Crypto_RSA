/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_crypto_rsa;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author ilustr
 */
public class PGCD {
    
    private static BigInteger NBCONST_DEUX = new BigInteger("2");
    private static BigInteger NBCONST_UN = new BigInteger("1");
    private static BigInteger NBCONST_ZERO = new BigInteger("0");
        
    public static BigInteger pgcd(BigInteger m, BigInteger n)
    {
        BigInteger r;
        
        while ( n.compareTo(NBCONST_ZERO) != 0) {
            r = m.mod(n);
            m = n;
            n = r;
        }
        return m;
    }
    
    public static BigInteger exponentiation(BigInteger b,BigInteger c,BigInteger n)
    {
        BigInteger r = new BigInteger("1");
        
        while(c.compareTo(NBCONST_ZERO) != 0) {
            if(c.and(r).compareTo(NBCONST_UN) == 0)
            {
                r = r.multiply(b).mod(n);
            }
            c.divide(NBCONST_DEUX);
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

        BigInteger varI = new BigInteger("3");
        BigInteger m = sqrt(n);

        if (n.mod(NBCONST_DEUX).compareTo(NBCONST_ZERO) == 0) {
            return (n.compareTo(NBCONST_DEUX) == 0);
        }
        while (varI.compareTo(m) != 1) {
            if ((n.mod(varI)).compareTo(NBCONST_ZERO) == 0) {
                return false;
            }
            varI = varI.add(new BigInteger("2"));
        }
        return true;
    }

    public static BigInteger EuclideEtendu (BigInteger a, BigInteger b)
    {
        BigInteger q;
        
        ArrayList<BigInteger> r = new ArrayList<>();
        ArrayList<BigInteger> s = new ArrayList<>();
        ArrayList<BigInteger> t = new ArrayList<>();
        
        r.add(a); r.add(b);
        s.add(new BigInteger("1")); s.add(new BigInteger("0"));
        t.add(new BigInteger("0")); t.add(new BigInteger("1"));

        q = r.get(0).divide(r.get(1)); 
        
        r.add(r.get(0).subtract(q.multiply(r.get(1))));
        
        int i = 2;
        while(r.get(i).compareTo(NBCONST_ZERO) > 0)
        {
            s.add(s.get(i-2).subtract(q.multiply(s.get(i-1))));
            t.add(t.get(i-2).subtract(q.multiply(t.get(i-1))));
            q = r.get(i-1).divide(r.get(i));
            
            i = i+1;
            
            r.add(r.get(i-2).subtract(q.multiply(r.get(i-1))));
        }
        return s.get(i-1);
    }
}
