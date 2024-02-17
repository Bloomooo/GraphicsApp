
package Controller;

import Model.ShapeFactory;
import Model.ShapeManager;
import Model.Tool;

import java.awt.Color;

import javax.swing.JTextPane;

/**
 * La classe `Controller_Add` est responsable de la gestion de l'ajout de
 * nouvelles formes géométriques au modèle.
 * Elle prend en charge la création de formes en utilisant la classe
 * `ShapeFactory` et les ajoute au gestionnaire de formes `ShapeManager`.
 * 
 * @author adrien.peytavie
 */
public class Controller_Add {
    /**
     * Le gestionnaire de formes (`ShapeManager`) à utiliser.
     */
    private final ShapeManager data;

    /**
     * La fabrique de formes (`ShapeFactory`) à utiliser.
     */
    private final ShapeFactory s;

    /**
     * Constructeur de la classe `Controller_Add`.
     * 
     * @param d Le gestionnaire de formes (`ShapeManager`) à utiliser.
     * @param s La fabrique de formes (`ShapeFactory`) à utiliser.
     */
    public Controller_Add(ShapeManager d, ShapeFactory s) {
        data = d;
        this.s = s;
    }

    /**
     * Cette méthode permet de contrôler l'ajout d'une nouvelle forme géométrique
     * avec la couleur spécifiée, l'outil spécifié et des informations
     * supplémentaires à afficher dans un composant `JTextPane`.
     * 
     * @param color                 La couleur de la forme à créer.
     * @param tool                  L'outil à utiliser pour créer la forme.
     * @param jTextPaneInformations Le composant `JTextPane` où afficher des
     *                              informations supplémentaires.
     */
    public void control(Color color, Tool tool, JTextPane jTextPaneInformations) {
        s.createShape(data.getRoot(), color, tool, data, jTextPaneInformations);
    }
}
