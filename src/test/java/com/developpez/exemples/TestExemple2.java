package com.developpez.exemples;

import com.developpez.lecturefichier.exemple2.ChampsFixes;

import junit.framework.TestCase;

public class TestExemple2 extends TestCase {


	public void test1()
	{
		ChampsFixes premier_debut=null;
		for(ChampsFixes tmp:ChampsFixes.values())
		{
			assertTrue(tmp.getPosition()>=0);
			assertTrue(tmp.getLongeur()>0);
			if(tmp.getPosition()==0)
			{
				premier_debut=tmp;
			}
		}
		assertNotNull("il n'y a aucun champs pour la colonne no 0",premier_debut);
	}

	public void test2()
	{
		int taille_champs;
		taille_champs=0;
		for(ChampsFixes tmp:ChampsFixes.values())
		{
			taille_champs=Math.max(taille_champs, tmp.getPosition()+tmp.getLongeur());
		}
		assertEquals(taille_champs, ChampsFixes.taille_ligne());
	}
	
	public void test3()
	{
		ChampsFixes tab[];
		tab=new ChampsFixes[ChampsFixes.taille_ligne()];
		for(ChampsFixes tmp:ChampsFixes.values())
		{
			for(int i=tmp.getPosition();i<tmp.getPosition()+tmp.getLongeur();i++)
			{
				assertNull("La case n°"+i+" est associé a deux champs différents :"+tmp+" et "+tab[i], tab[i]);
				tab[i]=tmp;
			}
		}
		for(int i=0;i<tab.length;i++)
		{
			assertNotNull("La case n°"+i+" n'est associé a aucun champs ", tab[i]);
		}
	}
}
