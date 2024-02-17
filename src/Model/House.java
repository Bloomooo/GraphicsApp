package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Cette classe représente une forme de maison, avec un centre, une couleur, et
 * un nombre d'étages.
 * Elle permet de créer, dessiner et manipuler des maisons.
 * 
 * @author Yanis Mechta
 */
public class House extends Shape {
    /**
     * La position du centre de la maison.
     */
    private Point center;

    /**
     * La couleur de la maison.
     */
    private Color color;

    /**
     * Le nombre d'étages de la maison.
     */
    private int numFloors;

    /**
     * Le groupe auquel cette maison appartient.
     */
    private Group group;

    /**
     * Constructeur de la classe `House` qui initialise une nouvelle maison avec un
     * groupe, une position, une couleur et un nombre d'étages spécifiés.
     * 
     * @param group     Le groupe auquel appartient la maison.
     * @param p         La position du centre de la maison.
     * @param color     La couleur de la maison.
     * @param numFloors Le nombre d'étages de la maison.
     */
    public House(Shape shape, Point p, Color color, int numFloors) {
        this.center = p;
        this.color = color;
        this.numFloors = numFloors;
        this.group = (Group) shape;
    }

    /**
     * Définit le groupe auquel appartient cette maison.
     * 
     * @param group Le groupe auquel appartient la maison.
     */
    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Récupère le groupe auquel appartient cette maison.
     * 
     * @return Le groupe auquel appartient la maison.
     */
    @Override
    public Group getGroup() {
        return group;
    }

    /**
     * Récupère le type de cette forme, qui est "House".
     * 
     * @return Le type de la forme.
     */
    @Override
    public String getType() {
        return "House";
    }

    /**
     * Dessine la maison en utilisant un objet Graphics spécifié.
     * 
     * @param g L'objet Graphics pour le dessin.
     */
    @Override
    public void draw(Graphics g) {
        // Dessiner la structure de la maison (un rectangle)
        g.setColor(color);
        int width = 100; // Largeur de la maison
        int height = 80 + (numFloors - 1) * 20; // Hauteur de la maison en fonction du nombre d'étages
        g.fillRect(center.x - width / 2, center.y - height / 2, width, height);

        // Dessiner le toit de la maison (un triangle)
        int[] xPoints = { center.x - width / 2, center.x, center.x + width / 2 };
        int[] yPoints = { center.y - height / 2, center.y - height, center.y - height / 2 };
        g.fillPolygon(xPoints, yPoints, 3);

        g.setColor(Color.black);
        g.drawRect(center.x - width / 2, center.y - height / 2, width, height); // Dessiner la bordure de la maison
    }

    /**
     * Récupère un modèle d'arbre (`DefaultMutableTreeNode`) représentant cette
     * maison avec ses propriétés.
     * 
     * @return Un modèle d'arbre représentant la maison.
     */
    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(
                getType() + "(Center[" + center.x + ", " + center.y + "], Color[" + color + "], Floors[" + numFloors
                        + "])");
    }

    /**
     * Récupère la position X du centre de la maison.
     * 
     * @return La position X du centre.
     */
    @Override
    public int getX() {
        return center.x;
    }

    /**
     * Récupère la position Y du centre de la maison.
     * 
     * @return La position Y du centre.
     */
    @Override
    public int getY() {
        return center.y;
    }

    /**
     * Définit la position X du centre de la maison.
     * 
     * @param x La nouvelle position X du centre.
     */
    @Override
    public void setX(int x) {
        center.x = x;
    }

    /**
     * Définit la position Y du centre de la maison.
     * 
     * @param y La nouvelle position Y du centre.
     */
    @Override
    public void setY(int y) {
        center.y = y;
    }

    /**
     * Récupère le rayon de la maison (non applicable aux maisons).
     * 
     * @return Le rayon de la maison (non applicable).
     */
    @Override
    public double getRadius() {
        // Non applicable à une maison, car ce sont des formes complexes
        return 0.0;
    }

    /**
     * Définit la largeur de la maison (non applicable aux maisons).
     * 
     * @param width La largeur de la maison (non applicable).
     */
    @Override
    public void setWidth(int width) {
        // Non applicable à une maison, car ce sont des formes complexes
    }

    /**
     * Définit la hauteur de la maison (non applicable aux maisons).
     * 
     * @param height La hauteur de la maison (non applicable).
     */
    @Override
    public void setHeight(int height) {
        // Non applicable à une maison, car ce sont des formes complexes
    }

    /**
     * Définit la taille de la maison (non applicable aux maisons).
     * 
     * @param size La taille de la maison (non applicable).
     */
    @Override
    public void setSize(int size) {
        // Non applicable à une maison, car ce sont des formes complexes
    }

    /**
     * Récupère la taille de la maison (non applicable aux maisons).
     * 
     * @return La taille de la maison (non applicable).
     */
    @Override
    public int getSize() {
        // Non applicable à une maison, car ce sont des formes complexes
        return 0;
    }

    /**
     * Récupère la largeur de la maison (non applicable aux maisons).
     * 
     * @return La largeur de la maison (non applicable).
     */
    @Override
    public int getWidth() {
        // Non applicable à une maison, car ce sont des formes complexes
        return 0;
    }

    /**
     * Récupère la hauteur de la maison (non applicable aux maisons).
     * 
     * @return La hauteur de la maison (non applicable).
     */
    @Override
    public int getHeight() {
        // Non applicable à une maison, car ce sont des formes complexes
        return 0;
    }

    /**
     * Vérifie si un point spécifié est à l'intérieur de la maison en fonction de sa
     * position, de sa largeur, de sa hauteur et du nombre d'étages.
     * 
     * @param x La position X du point.
     * @param y La position Y du point.
     * @return `true` si le point est à l'intérieur de la maison, sinon `false`.
     */
    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }

    /**
     * Définit la couleur de la maison.
     * 
     * @param color La nouvelle couleur de la maison.
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Récupère la couleur de la maison.
     * 
     * @return La couleur de la maison.
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Récupère le nombre d'étages de la maison.
     * 
     * @return Le nombre d'étages de la maison.
     */
    public int getNumFloors() {
        return numFloors;
    }

    /**
     * Définit le nombre d'étages de la maison.
     * 
     * @param numFloors Le nouveau nombre d'étages de la maison.
     */
    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public void setSelected(boolean bool) {

    }

    @Override
    void setRadius(int radius) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    void addShape(Shape shape) {

    }

    @Override
    void deleteGroupVoid(Group group) {

    }

    @Override
    Shape search(String name, int x, int y) {
        return null;
    }

    @Override
    Shape searchWithMouse(MouseEvent e) {
        return null;
    }

    @Override
    List<Shape> getShapes() {
        return null;
    }
}
