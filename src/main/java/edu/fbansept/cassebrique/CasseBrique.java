package edu.fbansept.cassebrique;

import javax.swing.*;
import java.awt.*;
import edu.fbansept.cassebrique.models.Balle;

public class CasseBrique extends Canvas {

    public final static int LARGEUR = 500;
    public final static int HAUTEUR = 600;

    public CasseBrique() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        setBounds(0, 0, LARGEUR, HAUTEUR);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        setFocusable(false);

        demarrer();
    }

    public void demarrer() throws InterruptedException {


        Balle[] tableauBalle = new Balle[100];

        for (int i = 0; i < tableauBalle.length; i ++){

            int largeurBalle = (int)(Math.random() * 40 + 10);
            int positionXdepart = (int)(Math.random() * (LARGEUR - largeurBalle));
            int positionYdepart = (int)(Math.random() * (HAUTEUR - largeurBalle));

            int vitesseHorizontal = (int)(Math.random() * 8 -4);
            int vitesseVertical = (int)(Math.random() * 8 -4);

            tableauBalle[i] = new Balle(
                    positionXdepart,
                    positionYdepart,
                    largeurBalle,
                    vitesseHorizontal,
                    vitesseVertical);
        }

        while(true) {

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0, LARGEUR, HAUTEUR);

            for(Balle balle : tableauBalle) {
                balle.mouvement();
                balle.collision();
                balle.dessiner(dessin);
            }



            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }



    public static void main(String[] args) throws InterruptedException {

        int total = HAUTEUR + LARGEUR;

        new CasseBrique();
    }
}
