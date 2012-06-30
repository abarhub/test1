/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developpez.lecturefichier.exemple1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abarret
 */
public class Main {
    public static void main(String[] arg)
    {
        Lecture lecture;
        Fichier fichier;
        try {
            lecture=new Lecture(new File("./donnees/exemple1.txt"),ListeChamps1.class);
            fichier=lecture.lecture_fichier();
            fichier.affiche();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
