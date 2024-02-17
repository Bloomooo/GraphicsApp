package Model;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import javax.swing.JTextPane;

/**
 * La classe ShapeFactory est utilisée pour créer des instances de formes
 * géométriques
 * en fonction de l'outil sélectionné.
 * 
 * @author Yanis Mechta
 */
public class ShapeFactory {

    /**
     * Constructeur par défaut de la ShapeFactory.
     */
    public ShapeFactory() {

    }

    /**
     * Crée une nouvelle forme géométrique en fonction de l'outil sélectionné.
     * 
     * @param group                 Le groupe auquel la forme doit appartenir.
     * @param color                 La couleur de la forme.
     * @param tool                  L'outil sélectionné pour créer la forme.
     * @param data                  Le gestionnaire de formes où la nouvelle forme
     *                              sera ajoutée.
     * @param jTextPaneInformations Le composant JTextPane utilisé pour afficher des
     *                              informations sur la création de la forme.
     * @return Une nouvelle instance de la forme géométrique créée.
     */
    public Shape createShape(Shape shapeRoot, Color color, Tool tool, ShapeManager data,
            JTextPane jTextPaneInformations) {
        Random rand = new Random(System.currentTimeMillis());
        Shape shape = null;

        switch (tool) {
            case CIRCLE:
                shape = new Circle(shapeRoot, new Point(rand.nextInt(200), rand.nextInt(200)), color);
                break;
            case SQUARE:
                shape = new Square(shapeRoot, new Point(rand.nextInt(200), rand.nextInt(200)), color);
                break;
            case RECTANGLE:
                shape = new Rectangle(shapeRoot, new Point(rand.nextInt(200), rand.nextInt(200)), color);
                break;
            case TREE:
                shape = new Tree(shapeRoot, new Point(rand.nextInt(400), rand.nextInt(400)), color, Color.GREEN, 20);
                break;
            case HOUSE:
                shape = new House(shapeRoot, new Point(rand.nextInt(400), rand.nextInt(400)), color, 2);
                break;
            case CAR:
                shape = new Car(shapeRoot, new Point(rand.nextInt(400), rand.nextInt(400)), color);
                break;
        }

        if (shape != null) {
            jTextPaneInformations.setText(shape.getType() + " created !");
            data.add(shape);
        }

        return shape;
    }
}
