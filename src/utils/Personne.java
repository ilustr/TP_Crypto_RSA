/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.math.BigInteger;

/**
 *
 * @author Anthony
 */
public class Personne {
    private String nom;
    private BigInteger clePublique;
    private BigInteger modulus;
    private BigInteger clePrivee;
    
    public Personne(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigInteger getClePublique() {
        return clePublique;
    }

    public void setClePublique(BigInteger clePublique) {
        this.clePublique = clePublique;
    }

    public BigInteger getClePrivee() {
        return clePrivee;
    }

    public void setClePrivee(BigInteger clePrivee) {
        this.clePrivee = clePrivee;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public void setModulus(BigInteger modulus) {
        this.modulus = modulus;
    }
    
    
}
