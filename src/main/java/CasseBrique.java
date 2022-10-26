
import models.Balle;

import javax.swing.*;
import java.awt.*;

public class CasseBrique extends Canvas {

    private int largeur = 500;
    private int hauteur = 600;

    public CasseBrique() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(largeur, hauteur));
        setBounds(0, 0, largeur,hauteur);
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

        Balle balle = new Balle();

        while(true) {

            balle.mouvement();
            balle.collision(largeur,hauteur);

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0, largeur, hauteur);

            balle.dessiner(dessin);

            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }
}
