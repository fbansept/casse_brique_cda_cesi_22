package models;

import java.awt.*;

public class Balle {

    protected int positionX = 0;
    protected int vitesseHorizontalBalle = 5;
    protected int positionY = 0;
    protected int vitesseVerticalBalle = 5;
    protected Color couleur;
    protected int largeur;

    public Balle(int positionX, int positionY, Color couleur, int largeur) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.couleur = couleur;
        this.largeur = largeur;
    }

    public void mouvement() {
        positionX += vitesseHorizontalBalle;
        positionY += vitesseVerticalBalle;
    }

    public void collision(int largeurEcran, int hauteurEcran){
        //si la balle est arrivée à droite ou à gauche alors on inverse sa vitesse
        if(positionX >= largeurEcran - largeur || positionX <= 0){
            vitesseHorizontalBalle *= -1; //vitesseHorizontalBalle = vitesseHorizontalBalle * -1
//            couleur = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        }

        if(positionY >= hauteurEcran - largeur || positionY <= 0){
            vitesseVerticalBalle *= -1;
        }
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(positionX,positionY, largeur,largeur);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getVitesseHorizontalBalle() {
        return vitesseHorizontalBalle;
    }

    public void setVitesseHorizontalBalle(int vitesseHorizontalBalle) {
        this.vitesseHorizontalBalle = vitesseHorizontalBalle;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getVitesseVerticalBalle() {
        return vitesseVerticalBalle;
    }

    public void setVitesseVerticalBalle(int vitesseVerticalBalle) {
        this.vitesseVerticalBalle = vitesseVerticalBalle;
    }



}
