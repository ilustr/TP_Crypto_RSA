/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_crypto_rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author ilustr
 */
public class Fonctions {

    public static final BigInteger ZERO = BigInteger.ZERO;  // declaring constants
    public static final BigInteger ONE = BigInteger.ONE;
    public static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger pgcd(BigInteger m, BigInteger n) {
        BigInteger zero = new BigInteger("0");
        BigInteger r;

        while (n.compareTo(zero) != 0) {
            r = m.mod(n);
            m = n;
            n = r;
        }
        return m;
    }

    public static BigInteger exponentiation(BigInteger b, BigInteger c, BigInteger n) {
        BigInteger r = new BigInteger("1");
        BigInteger deux = new BigInteger("2");
        BigInteger un = new BigInteger("1");
        BigInteger zero = new BigInteger("0");

        while (c.compareTo(zero) != 0) {
            if (c.and(r).compareTo(un) == 0) {
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

        BigInteger varI = new BigInteger("3");
        BigInteger m = sqrt(n);

        if (n.mod(TWO).compareTo(ZERO) == 0) {
            return (n.compareTo(TWO) == 0);
        }
        while (varI.compareTo(m) != 1) {
            if ((n.mod(varI)).compareTo(ZERO) == 0) {
                return false;
            }
            varI = varI.add(TWO);
        }
        return true;
    }

    public static BigInteger randomBigInteger(BigInteger n) {
        Random rnd = new Random();
        int maxNumBitLength = n.bitLength();
        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
            // compare random number lessthan ginven number
        } while (aRandomBigInt.compareTo(n) > 0);
        return aRandomBigInt;
    }

    public static BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        while (exponent.signum() > 0) {
            if (exponent.testBit(0)) {
                result = result.multiply(base);
            }
            base = base.multiply(base);
            exponent = exponent.shiftRight(1);
        }
        return result;
    }

    public static boolean estProbablementPremier(BigInteger n) {
        BigInteger varI = new BigInteger("0");
        BigInteger vark = new BigInteger("0");
        BigInteger varM = n.subtract(ONE);
        
        while ((varM.mod(TWO)).compareTo(ZERO) == 0) {
            varM = varM.shiftRight(1);
            vark = vark.add(ONE);
        }
        
        BigInteger a = randomBigInteger(n.subtract(ONE));
        BigInteger b = a.modPow(varM, n);
        
        if ((b.mod(n)).compareTo(ZERO) == 0) {
            return true;
        } else {
            while (varI.compareTo(vark.subtract(ONE)) <= 0 ) {
                if (((b.subtract(ONE)).mod(n)).compareTo(ZERO) == 0) {
                    return true;
                } else {
                    b = b.modPow(TWO, n);
                }
                varI = varI.add(ONE);
            }
        }
        return false;
    }
}
