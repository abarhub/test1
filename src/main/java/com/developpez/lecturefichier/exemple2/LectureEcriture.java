package com.developpez.lecturefichier.exemple2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EnumMap;
import java.util.Map;

public class LectureEcriture {

	public LectureEcriture() {
		// constructeur vide
	}

    public Fichier lecture_fichier(File fichier) throws FileNotFoundException, IOException
    {
        Fichier res;
        BufferedReader buf=null;
        Map<ChampsFixes,String> ligne;
        String ligne2;
        res=new Fichier();
        try{
            buf=new BufferedReader(new FileReader(fichier));
            while((ligne2=buf.readLine())!=null)
            {
                if(ligne2!=null&&ligne2.length()>0)
                {
                    ligne=decoupe(ligne2);
                    if(ligne!=null)
                    {
                        res.ajoute(ligne);
                    }
                }
            }
        }finally{
            if(buf!=null)
            {
                buf.close();
                buf=null;
            }
        }
        return res;
    }
    
    private Map<ChampsFixes, String> decoupe(String ligne) {
        Map<ChampsFixes, String> res;
        String s;
        res=new EnumMap<ChampsFixes,String>(ChampsFixes.class);
        for(ChampsFixes champs:ChampsFixes.values())
        {
            s=ligne.substring(champs.getPosition(), champs.getPosition()+champs.getLongeur());
            res.put(champs, s);
        }
        return res;
    }

    public void ecriture_fichier(File nom_fichier,Fichier contenu_fichier) throws IOException
    {
    	PrintWriter out=null;
    	try{
    		out=new PrintWriter(new BufferedWriter(new FileWriter(nom_fichier)));
    		if(contenu_fichier!=null)
    		{
    			if(contenu_fichier.getListe()!=null)
    			{
    				for(Map<ChampsFixes,String> ligne:contenu_fichier.getListe())
    				{
    					out.println(assemble(ligne));
    				}
    			}
    		}
    	}finally{
    		if(out!=null)
    		{
    			out.flush();
    			out.close();
    		}
    	}
    }
    
    private String assemble(Map<ChampsFixes, String> ligne) {
        String valeur;
        StringBuilder buf;
        char c;
        buf=new StringBuilder();
        buf.setLength(ChampsFixes.taille_ligne());
        for(ChampsFixes champs:ligne.keySet())
        {
        	valeur=ligne.get(champs);
        	if(valeur!=null&&valeur.length()>0)
        	{
        		for(int i=0;i<champs.getLongeur();i++)
        		{
        			c=valeur.charAt(i);
        			buf.setCharAt(champs.getPosition()+i, c);
        		}
        	}
        }
        return buf.toString();
    }
    
}
