package com.developpez.lecturefichier.exemple2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Fichier {

    private List<Map<ChampsFixes,String>> liste;
    
    public Fichier()
    {
        liste=new ArrayList<Map<ChampsFixes, String>>();
    }
    
    public void ajoute(Map<ChampsFixes, String> map)
    {
        liste.add(map);
    }

    public List<Map<ChampsFixes, String>> getListe() {
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
                Map<ChampsFixes,String> map=liste.get(i);
                out.println("Ligne no "+i);
                for(ChampsFixes champs:map.keySet())
                {
                    out.println(champs.name()+"="+map.get(champs));
                }
            }
        }
        out.println("Fin affichage");
    }
}
