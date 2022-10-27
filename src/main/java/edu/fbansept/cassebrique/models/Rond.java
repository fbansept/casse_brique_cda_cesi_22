package edu.fbansept.cassebrique.models;

import java.awt.*;

public class Rond extends Sprite {

    protected int diametre;

    public Rond(int positionX, int positionY, Color couleur, int diametre) {
        super(positionX, positionY, couleur);
        this.diametre = diametre;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(positionX,positionY,diametre,diametre);
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
}
