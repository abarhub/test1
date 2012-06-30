/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developpez.lecturefichier.exemple2;

/**
 *
 * @author abarret
 */
public enum ChampsFixes {
    Nom(0,20),Prenom(20,20),DateNaissance(40,8);
    
    private ChampsFixes(int position,int longueur)
    {
        this.position=position;
        this.longeur=longueur;
    }

    public int getLongeur() {
        return longeur;
    }

    public int getPosition() {
        return position;
    }
        
    private int position;
    private int longeur;

    public static int taille_ligne()
    {
    	int res=0;
    	for(ChampsFixes champs:ChampsFixes.values())
    	{
    		res=Math.max(res, champs.getPosition()+champs.getLongeur());
    	}
    	return res;
    }
}
