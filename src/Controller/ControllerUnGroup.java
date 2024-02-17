package Controller;

import javax.swing.JTextPane;
import javax.swing.tree.TreePath;

import Model.Group;
import Model.Shape;
import Model.ShapeManager;

public class ControllerUnGroup {
    private final ShapeManager data;

    public ControllerUnGroup(ShapeManager d) {
        data = d;
    }

    public void control(TreePath[] selectedPaths, JTextPane jTextPaneInformations) {
        if (selectedPaths != null) {
            for (TreePath selectedPath : selectedPaths) {
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
                            int x = Integer.parseInt(xCoordinate);
                            int y = Integer.parseInt(yCoordinate);
                            Shape shape = data.search(name, x, y);
                            if (shape != null) {
                                data.removeGroup(shape.getGroup(), shape);
                                data.addGroup((Group) data.getRoot(), shape);
                                if (shape.getGroup().getSize() == 0) {
                                    Group tmp = shape.getGroup().getParent((Group) data.getRoot());
                                    data.deleteGroup(shape.getGroup());
                                    while (tmp.getSize() == 0) {
                                        Group tmp2 = tmp;
                                        tmp = tmp.getParent((Group) data.getRoot());
                                        data.deleteGroup(tmp2);
                                    }

                                }
                                shape.setGroup((Group) data.getRoot());
                                jTextPaneInformations.setText("Ungrouped !");
                            } else {
                                jTextPaneInformations.setText("Shape not found");
                            }
                        }
                    }

                }
            }
            data.update();
        }
    }
}
