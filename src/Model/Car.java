package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Cette classe représente un objet de type "Voiture" qui est une forme
 * géométrique complexe.
 * Elle contient des attributs pour spécifier le centre de la voiture, sa
 * couleur, et le groupe auquel elle appartient.
 * La classe implémente l'interface `Shape` pour définir des comportements
 * spécifiques aux voitures.
 * 
 * @author Yanis Mechta
 */
public class Car extends Shape {
    /**
     * Le centre de la voiture, représenté par un point.
     */
    private Point center;

    /**
     * La couleur de la voiture.
     */
    private Color color;

    /**
     * Le groupe auquel appartient cette voiture.
     */
    private Group group;

    /**
     * La largeur par défaut de la voiture.
     */
    private int carWidth = 100;

    /**
     * La hauteur par défaut de la voiture.
     */
    private int carHeight = 40;

    /**
     * Constructeur de la classe `Car` qui initialise une nouvelle instance de
     * voiture avec le groupe, le centre et la couleur spécifiés.
     * 
     * @param group Le groupe auquel appartient la voiture.
     * @param p     Le centre de la voiture représenté par un point.
     * @param color La couleur de la voiture.
     */
    public Car(Shape shape, Point p, Color color) {
        this.center = p;
        this.color = color;
        this.group = (Group) shape;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Group getGroup() {
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return "Car";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(Graphics g) {
        // Dessiner la carrosserie de la voiture (un rectangle)
        g.setColor(color);
        // Hauteur de la voiture
        g.fillRect(center.x - carWidth / 2, center.y - carHeight / 2, carWidth, carHeight);

        // Dessiner les roues de la voiture (deux cercles)
        int wheelDiameter = 20; // Diamètre des roues
        int wheelY = center.y + carHeight / 2; // La position verticale des roues est en bas de la voiture
        int wheelX1 = center.x - carWidth / 3 - wheelDiameter / 2; // Position horizontale de la première roue
        int wheelX2 = center.x + carWidth / 3 - wheelDiameter / 2; // Position horizontale de la deuxième roue
        g.setColor(Color.black);
        g.fillOval(wheelX1, wheelY - wheelDiameter / 2, wheelDiameter, wheelDiameter); // Dessiner la première roue
        g.fillOval(wheelX2, wheelY - wheelDiameter / 2, wheelDiameter, wheelDiameter); // Dessiner la deuxième roue

        g.setColor(Color.black);
        g.drawRect(center.x - carWidth / 2, center.y - carHeight / 2, carWidth, carHeight); // Dessiner la bordure de la
                                                                                            // voiture
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(
                getType() + "(Center[" + center.x + ", " + center.y + "], Color[" + color + "])");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return center.x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return center.y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(int x) {
        center.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(int y) {
        center.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getRadius() {
        // Ne s'applique pas à une voiture, car ce sont des formes complexes
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidth(int width) {
        // Ne s'applique pas à une voiture, car ce sont des formes complexes
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHeight(int height) {
        // Ne s'applique pas à une voiture, car ce sont des formes complexes
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSize(int size) {
        // Ne s'applique pas à une voiture, car ce sont des formes complexes
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        // Ne s'applique pas à une voiture, car ce sont des formes complexes
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWidth() {
        // Ne s'applique pas à une voiture, car ce sont des formes complexes
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHeight() {
        // Ne s'applique pas à une voiture, car ce sont des formes complexes
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getColor() {
        return color;
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
