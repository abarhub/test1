/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developpez.lecturefichier.exemple1;

//import lecturefichier.test2.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abarret
 */
public class Fichier {
    
    private List<Map<Champs,String>> liste;
    
    public Fichier()
    {
        liste=new ArrayList<Map<Champs, String>>();
    }
    
    public void ajoute(Map<Champs, String> map)
    {
        liste.add(map);
    }

    public List<Map<Champs, String>> getListe() {
        return liste;
    }
    
    
    public void affiche()
    {
        affiche(System.out);
    }
    
    public void affiche(PrintStream out)
    {
        out.println("Debut affichage");
        if(liste!=null&&!liste.isEmpty())
        {
            for(int i=0;i<liste.size();i++)
            {
                Map<Champs,String> map=liste.get(i);
                out.println("Ligne no "+i);
                for(Champs champs:map.keySet())
                {
                    out.println(champs.name()+"="+map.get(champs));
                }
            }
        }
        out.println("Fin affichage");
    }
}
