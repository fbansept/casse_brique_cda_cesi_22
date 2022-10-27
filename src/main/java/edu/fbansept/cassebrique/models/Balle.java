package edu.fbansept.cassebrique.models;

import edu.fbansept.cassebrique.CasseBrique;

import java.awt.*;

public class Balle extends Rond {

    protected int vitesseHorizontalBalle = 5;
    protected int vitesseVerticalBalle = 5;

    public Balle(int positionX, int positionY, Color couleur, int diametre, int vitesseHorizontalBalle, int vitesseVerticalBalle) {
        super(positionX, positionY, couleur, diametre);
        this.vitesseHorizontalBalle = vitesseHorizontalBalle;
        this.vitesseVerticalBalle = vitesseVerticalBalle;
    }

    public void mouvement() {
        positionX += vitesseHorizontalBalle;
        positionY += vitesseVerticalBalle;
    }

    public void collision(){
        //si la balle est arrivée à droite ou à gauche alors on inverse sa vitesse
        if(positionX >= CasseBrique.LARGEUR - diametre || positionX <= 0){
            vitesseHorizontalBalle *= -1; //vitesseHorizontalBalle = vitesseHorizontalBalle * -1
//            couleur = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        }

        if(positionY >= CasseBrique.HAUTEUR - diametre || positionY <= 0){
            vitesseVerticalBalle *= -1;
        }
    }

    public int getVitesseHorizontalBalle() {
        return vitesseHorizontalBalle;
    }

    public void setVitesseHorizontalBalle(int vitesseHorizontalBalle) {
        this.vitesseHorizontalBalle = vitesseHorizontalBalle;
    }
    public int getVitesseVerticalBalle() {
        return vitesseVerticalBalle;
    }

    public void setVitesseVerticalBalle(int vitesseVerticalBalle) {
        this.vitesseVerticalBalle = vitesseVerticalBalle;
    }



}
