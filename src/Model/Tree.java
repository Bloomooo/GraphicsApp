package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Cette classe représente un objet de type arbre dessiné à l'écran.
 * Un arbre est composé d'un tronc brun et de feuilles vertes.
 * La hauteur de l'arbre détermine la longueur du tronc.
 * 
 * @author Yanis Mechta
 */
public class Tree extends Shape {
    /** La couleur des feuilles de l'arbre. */
    private Color leafColor;

    /** La hauteur de l'arbre. */
    private int height;

    /** Le point central de l'arbre. */
    private Point center;

    /** La couleur du tronc de l'arbre. */
    private Color trunkColor;

    /** Le groupe auquel cet arbre appartient. */
    private Group group;

    /**
     * Constructeur de la classe Tree.
     *
     * @param group      Le groupe auquel appartient cet arbre.
     * @param p          Le point central de l'arbre.
     * @param trunkColor La couleur du tronc de l'arbre.
     * @param leafColor  La couleur des feuilles de l'arbre.
     * @param height     La hauteur de l'arbre.
     */
    public Tree(Shape shape, Point p, Color trunkColor, Color leafColor, int height) {
        this.center = p;
        this.trunkColor = trunkColor;
        this.leafColor = leafColor;
        this.height = height;
        this.group = (Group) shape;
    }

    /**
     * Définit le groupe auquel cet arbre appartient.
     *
     * @param group Le groupe auquel cet arbre appartient.
     */
    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Obtient le groupe auquel cet arbre appartient.
     *
     * @return Le groupe auquel cet arbre appartient.
     */
    @Override
    public Group getGroup() {
        return group;
    }

    /**
     * Obtient le type de l'objet, qui est "Tree" pour un arbre.
     *
     * @return Le type de l'objet.
     */
    @Override
    public String getType() {
        return "Tree";
    }

    /**
     * Dessine l'arbre sur un objet Graphics donné.
     *
     * @param g L'objet Graphics sur lequel dessiner l'arbre.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(leafColor);
        int leafSize = 40; // Taille des feuilles
        int numberOfLeaves = 5; // Nombre de feuilles

        for (int i = 0; i < numberOfLeaves; i++) {
            int leafX = center.x - leafSize / 2 + i * (leafSize / 2);
            int leafY = center.y - leafSize - i * (leafSize / 2);

            if (leafY + leafSize >= 0) {
                g.fillOval(leafX, leafY, leafSize, leafSize);
            }
        }

        g.setColor(trunkColor);
        int trunkWidth = 20; // Largeur du tronc
        int trunkHeight = height * 4; // Hauteur du tronc (4 fois la hauteur de l'arbre)
        g.fillRect(center.x - trunkWidth / 2, center.y, trunkWidth, trunkHeight);
        g.setColor(Color.black);
        g.drawRect(center.x - trunkWidth / 2, center.y, trunkWidth, trunkHeight);
    }

    /**
     * Obtient un nœud mutable par défaut représentant cet arbre pour une
     * utilisation dans un JTree.
     *
     * @return Un nœud mutable par défaut représentant cet arbre.
     */
    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(
                getType() + "(Center[" + center.x + ", " + center.y + "], TrunkColor[" + trunkColor + "], LeafColor["
                        + leafColor + "], Height[" + height + "])");
    }

    /**
     * Obtient la coordonnée X du point central de l'arbre.
     *
     * @return La coordonnée X du point central de l'arbre.
     */
    @Override
    public int getX() {
        return center.x;
    }

    /**
     * Obtient la coordonnée Y du point central de l'arbre.
     *
     * @return La coordonnée Y du point central de l'arbre.
     */
    @Override
    public int getY() {
        return center.y;
    }

    /**
     * Définit la coordonnée X du point central de l'arbre.
     *
     * @param x La nouvelle coordonnée X du point central de l'arbre.
     */
    @Override
    public void setX(int x) {
        center.x = x;
    }

    /**
     * Définit la coordonnée Y du point central de l'arbre.
     *
     * @param y La nouvelle coordonnée Y du point central de l'arbre.
     */
    @Override
    public void setY(int y) {
        center.y = y;
    }

    /**
     * Obtient le rayon de l'arbre (non applicable aux arbres, car ce sont des
     * formes complexes).
     *
     * @return Le rayon de l'arbre.
     */
    @Override
    public double getRadius() {
        // Non applicable aux arbres, car ce sont des formes complexes.
        return 0.0;
    }

    /**
     * Définit la largeur de l'arbre (non applicable aux arbres, car ce sont des
     * formes complexes).
     *
     * @param width La nouvelle largeur de l'arbre.
     */
    @Override
    public void setWidth(int width) {
        // Non applicable aux arbres, car ce sont des formes complexes.
    }

    /**
     * Définit la taille de l'arbre (non applicable aux arbres, car ce sont des
     * formes complexes).
     *
     * @param size La nouvelle taille de l'arbre.
     */
    @Override
    public void setSize(int size) {
        // Non applicable aux arbres, car ce sont des formes complexes.
    }

    /**
     * Obtient la taille de l'arbre (non applicable aux arbres, car ce sont des
     * formes complexes).
     *
     * @return La taille de l'arbre.
     */
    @Override
    public int getSize() {
        // Non applicable aux arbres, car ce sont des formes complexes.
        return 0;
    }

    /**
     * Obtient la largeur de l'arbre (non applicable aux arbres, car ce sont des
     * formes complexes).
     *
     * @return La largeur de l'arbre.
     */
    @Override
    public int getWidth() {
        // Non applicable aux arbres, car ce sont des formes complexes.
        return 0;
    }

    /**
     * Définit la couleur du tronc de l'arbre.
     *
     * @param color La nouvelle couleur du tronc de l'arbre.
     */
    @Override
    public void setColor(Color color) {
        this.trunkColor = color;
    }

    /**
     * Obtient la couleur du tronc de l'arbre.
     *
     * @return La couleur du tronc de l'arbre.
     */
    @Override
    public Color getColor() {
        return trunkColor;
    }

    /**
     * Obtient la couleur des feuilles de l'arbre.
     *
     * @return La couleur des feuilles de l'arbre.
     */
    public Color getLeafColor() {
        return leafColor;
    }

    /**
     * Définit la couleur des feuilles de l'arbre.
     *
     * @param leafColor La nouvelle couleur des feuilles de l'arbre.
     */
    public void setLeafColor(Color leafColor) {
        this.leafColor = leafColor;
    }

    /**
     * Obtient la hauteur de l'arbre.
     *
     * @return La hauteur de l'arbre.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Définit la hauteur de l'arbre.
     *
     * @param height La nouvelle hauteur de l'arbre.
     */
    public void setHeight(int height) {
        this.height = height;
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

    @Override
    boolean containsPoint(int x, int y) {
        return false;
    }

}
