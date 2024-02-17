
package Controller;

import javax.swing.JTextPane;
import javax.swing.tree.TreePath;

import Model.Shape;
import Model.ShapeManager;

/**
 * La classe `ControllerDisplay` est responsable de la gestion de l'affichage
 * d'informations sur une forme géométrique sélectionnée.
 * Elle permet de rechercher une forme dans le gestionnaire de formes
 * (`ShapeManager`) en fonction d'un chemin de sélection (`TreePath`) et
 * d'afficher des informations sur cette forme dans un composant `JTextPane`.
 * 
 * @author Yanis Mechta
 */
public class ControllerDisplay {
    /**
     * Le gestionnaire de formes (`ShapeManager`) à utiliser.
     */
    private final ShapeManager data;

    /**
     * Constructeur de la classe `ControllerDisplay`.
     * 
     * @param d Le gestionnaire de formes (`ShapeManager`) à utiliser.
     */
    public ControllerDisplay(ShapeManager d) {
        data = d;
    }

    /**
     * Cette méthode permet de contrôler l'affichage des informations sur une forme
     * géométrique sélectionnée.
     * 
     * @param selectedPath          Le chemin de sélection (`TreePath`) de la forme
     *                              géométrique à afficher.
     * @param jTextPaneInformations Le composant `JTextPane` où afficher des
     *                              informations sur la forme.
     * @return La forme géométrique correspondante, ou null si aucune forme
     *         correspondante n'a été trouvée.
     */
    public Shape control(TreePath selectedPath, JTextPane jTextPaneInformations) {
        Shape shape = null;
        if (selectedPath != null) {
            Object lastPathComponent = selectedPath.getLastPathComponent();
            String path = lastPathComponent.toString();
            String[] parts = path.split("\\(");

            if (parts.length > 0) {
                String name = parts[0].trim();

                String coordinates = parts[1];
                String[] coordinateParts = coordinates.split("[\\[,\\]]");

                if (coordinateParts.length >= 3) {

                    String xCoordinate = coordinateParts[1].trim();
                    String yCoordinate = coordinateParts[2].trim();
                    int xC = Integer.parseInt(xCoordinate);
                    int yC = Integer.parseInt(yCoordinate);
                    shape = search(name, xC, yC, jTextPaneInformations);
                }
            }
        }
        return shape;
    }

    /**
     * Cette méthode permet de rechercher une forme géométrique dans le gestionnaire
     * de formes en fonction de son nom, de ses coordonnées x et y, et d'afficher un
     * message dans le composant `JTextPane`.
     * 
     * @param name                  Le nom de la forme à rechercher.
     * @param x                     La coordonnée x de la forme à rechercher.
     * @param y                     La coordonnée y de la forme à rechercher.
     * @param jTextPaneInformations Le composant `JTextPane` où afficher un message.
     * @return La forme géométrique correspondante, ou null si aucune forme
     *         correspondante n'a été trouvée.
     */
    private Shape search(String name, int x, int y, JTextPane jTextPaneInformations) {
        Shape shape = data.search(name, x, y);
        jTextPaneInformations.setText("Shape selected !");
        return shape;
    }
}
