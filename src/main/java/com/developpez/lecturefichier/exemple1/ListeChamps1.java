/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developpez.lecturefichier.exemple1;

/**
 *
 * @author abarret
 */
public enum ListeChamps1 implements Champs {
    Nom(0,20),Prenom(20,20),DateNaissance(40,8);
    
    private ListeChamps1(int position,int longueur)
    {
        this.position=position;
        this.longeur=longueur;
    }

    //@Override
    public int getLongeur() {
        return longeur;
    }

    //@Override
    public int getPosition() {
        return position;
    }
        
    private int position;
    private int longeur;
}
