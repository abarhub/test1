/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developpez.lecturefichier.exemple1;

import java.io.*;
import java.util.*;

/**
 *
 * @author abarret
 */
public class Lecture<T extends Enum<T>&Champs> {
    // le enum n'est pas necessaire, et peut être enlevé
    private File file;
    private List<T> liste_champs;
    
    public Lecture(File file,List<Champs> liste_champs){
        this.file=file;
        //this.liste_champs=liste_champs;
    }
    
    /*public Lecture(File file,EnumSet<Champs> liste_champs){
        this.file=file;
        this.liste_champs=EnumSet.;
    }*/
    
    public Lecture(File file,Champs[] liste_champs){
        this.file=file;
        //this.liste_champs=new ArrayList<Champs>(Arrays.asList(liste_champs));
    }
    
    public Lecture(File file,Class<T> clazz){
        this.file=file;
        this.liste_champs=new ArrayList<T>();
        for (T option : clazz.getEnumConstants()) {
            liste_champs.add(option);
        }

    }
    
    public Fichier lecture_fichier() throws FileNotFoundException, IOException
    {
        Fichier res;
        BufferedReader buf=null;
        Map<Champs,String> ligne;
        String ligne2;
        res=new Fichier();
        try{
            buf=new BufferedReader(new FileReader(file));
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
    
    private Map<Champs, String> decoupe(String ligne) {
        //EnumSet set=EnumSet.noneOf(ListeChamps.class);
        Map<Champs, String> res;
        String s;
        //res=new EnumMap(ListeChamps.class);
        //res=new EnumMap(ListeChamps.class);
        res=new HashMap<Champs,String>();
        for(Champs champs:liste_champs)
        {
            s=ligne.substring(champs.getPosition(), champs.getPosition()+champs.getLongeur());
            res.put(champs, s);
        }
        return res;
    }
    
}
