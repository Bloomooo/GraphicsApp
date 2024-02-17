package Controller;

import Model.Group;
import Model.Shape;
import Model.ShapeManager;
import View.GraphicsPainter;

import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * La classe `ControllerRemove` est responsable de la gestion de la suppression
 * de formes géométriques du gestionnaire de formes (`ShapeManager`) et de
 * l'arbre visuel (`JTree`) correspondant.
 * Elle offre des méthodes pour supprimer des formes individuelles en fonction
 * de leur nom et de leurs coordonnées, ainsi que pour supprimer des formes
 * sélectionnées dans l'arbre visuel.
 * 
 * Elle prend également en charge la mise à jour de l'affichage graphique à
 * travers un composant `GraphicsPainter` et la mise à jour de l'arbre visuel
 * (`JTree`).
 * 
 * @author Yanis Mechta
 */
public class ControllerRemove {
    /**
     * Le gestionnaire de formes (`ShapeManager`) à utiliser.
     */
    private final ShapeManager data;

    /**
     * Constructeur de la classe `ControllerRemove`.
     * 
     * @param d Le gestionnaire de formes (`ShapeManager`) à utiliser.
     */
    public ControllerRemove(ShapeManager d) {
        this.data = d;
    }

    /**
     * Cette méthode permet de contrôler la suppression d'une forme géométrique en
     * fonction de son nom et de ses coordonnées.
     * 
     * @param name                  Le nom de la forme à supprimer.
     * @param x                     La coordonnée x de la forme à supprimer.
     * @param y                     La coordonnée y de la forme à supprimer.
     * @param jTextPaneInformations Le composant `JTextPane` où afficher des
     *                              informations sur l'action de suppression.
     */
    public Shape control(String name, int x, int y, JTextPane jTextPaneInformations) {
        Shape shape = data.search(name, x, y);
        if (shape != null) {
            jTextPaneInformations.setText(shape.getType() + " remove");
            data.remove(shape);
        } else {
            jTextPaneInformations.setText("Shape not found");
        }
        return shape;
    }

    /**
     * Cette méthode permet de supprimer des formes géométriques sélectionnées dans
     * l'arbre visuel (`JTree`) et de mettre à jour l'affichage graphique via un
     * composant `GraphicsPainter`.
     * 
     * @param selectedPaths         Les chemins de sélection (`TreePath`) des formes
     *                              à supprimer.
     * @param painter               Le composant `GraphicsPainter` pour mettre à
     *                              jour l'affichage graphique.
     * @param jTree_Objects         L'arbre visuel (`JTree`) représentant les formes
     *                              géométriques.
     * @param jTextPaneInformations Le composant `JTextPane` où afficher des
     *                              informations sur l'action de suppression.
     */
    public void control(TreePath[] selectedPaths, GraphicsPainter painter, JTree jTree_Objects,
            JTextPane jTextPaneInformations) {
        if (selectedPaths != null) {
            DefaultTreeModel treeModel = (DefaultTreeModel) jTree_Objects.getModel();
            for (TreePath selectedPath : selectedPaths) {
                if (selectedPath != null) {
                    Object lastPathComponent = selectedPath.getLastPathComponent();
                    String path = lastPathComponent.toString();
                    String[] parts = path.split("\\(");

                    if (parts.length > 0) {
                        String name = parts[0].trim();
                        if (parts.length == 1) {
                            data.deleteGroup(name);
                        } else {
                            String coordinates = parts[1];
                            String[] coordinateParts = coordinates.split("[\\[,\\]]");

                            if (coordinateParts.length >= 3) {
                                String xCoordinate = coordinateParts[1].trim();
                                String yCoordinate = coordinateParts[2].trim();
                                int x = Integer.parseInt(xCoordinate);
                                int y = Integer.parseInt(yCoordinate);
                                Shape shape = data.search(name, x, y);
                                if (shape != null) {
                                    jTextPaneInformations.setText(shape.getType() + " remove");
                                    data.remove(shape);
                                } else {
                                    jTextPaneInformations.setText("Shape not found");
                                }
                            }
                        }

                    }
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) lastPathComponent;
                    treeModel.removeNodeFromParent(selectedNode);

                    // Vérifiez si le parent n'a plus d'enfants, et si c'est le cas, supprimez
                    // également le parent.
                    DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
                    if (parentNode != null && parentNode.getChildCount() == 0) {
                        treeModel.removeNodeFromParent(parentNode);
                    }
                }
            }
            painter.repaint();
            data.update();
        }
    }

}
