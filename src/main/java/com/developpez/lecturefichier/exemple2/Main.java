package com.developpez.lecturefichier.exemple2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		LectureEcriture lecture;
        Fichier fichier;
        try {
            lecture=new LectureEcriture();
            fichier=lecture.lecture_fichier(new File("./donnees/exemple2.txt"));
            fichier.affiche();

            lecture.ecriture_fichier(new File("./donnees/exemple2_2.txt"), fichier);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
