
package Controller;

import java.awt.Color;

import Model.Shape;
import Model.ShapeManager;

/**
 * La classe `ControllerModify` est responsable de la gestion de la modification
 * des propriétés d'une forme géométrique dans le gestionnaire de formes
 * (`ShapeManager`).
 * Elle permet de contrôler la modification des coordonnées, du rayon, de la
 * largeur, de la hauteur, de la taille, de la couleur, et d'autres propriétés
 * d'une forme géométrique spécifiée.
 * 
 * Elle offre également la capacité de rechercher une forme géométrique en
 * fonction des coordonnées de la souris lors d'un événement `MouseEvent`.
 * 
 * @author Yanis Mechta
 */
public class ControllerModify {
    /**
     * Le gestionnaire de formes (`ShapeManager`) à utiliser.
     */
    private final ShapeManager data;

    /**
     * Constructeur de la classe `ControllerModify`.
     * 
     * @param data Le gestionnaire de formes (`ShapeManager`) à utiliser.
     */
    public ControllerModify(ShapeManager data) {
        this.data = data;
    }

    /**
     * Cette méthode permet de contrôler la modification des propriétés d'une forme
     * géométrique spécifiée.
     * 
     * @param x      La nouvelle coordonnée x de la forme.
     * @param y      La nouvelle coordonnée y de la forme.
     * @param radius Le nouveau rayon de la forme (pour les formes circulaires).
     * @param width  La nouvelle largeur de la forme (pour les formes
     *               rectangulaires).
     * @param height La nouvelle hauteur de la forme (pour les formes
     *               rectangulaires).
     * @param size   La nouvelle taille de la forme.
     * @param color  La nouvelle couleur de la forme.
     * @param shape  La forme géométrique à modifier.
     */
    public void control(int x, int y, int radius, int width, int height, int size, Color color, Shape shape) {
        data.modify(x, y, radius, width, height, size, color, shape);
    }

    /**
     * Cette méthode permet de rechercher une forme géométrique en fonction des
     * coordonnées de la souris lors d'un événement `MouseEvent`.
     * 
     * @param e L'événement `MouseEvent` contenant les coordonnées de la souris.
     * @return La forme géométrique trouvée, ou null si aucune forme correspondante
     *         n'a été trouvée.
     */
    public Shape searchWithMouse(java.awt.event.MouseEvent e) {
        Shape shape = data.searchWithMouse(e);
        return shape;
    }
}
