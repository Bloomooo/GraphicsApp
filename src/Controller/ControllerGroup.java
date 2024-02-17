package Controller;

import javax.swing.JTextPane;
import javax.swing.tree.TreePath;

import Model.Group;
import Model.Shape;
import Model.ShapeManager;

public class ControllerGroup {
    private final ShapeManager data;

    private static int groupid = 0;

    public ControllerGroup(ShapeManager d) {
        data = d;
    }

    public void control(TreePath[] selectedPaths, JTextPane jTextPaneInformations) {
        if (selectedPaths != null) {
            Group newGroup = new Group("Group" + groupid);
            groupid++;
            int maxi = -1;
            Group groupParent = (Group) data.getRoot();
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
                                if (maxi < selectedPath.getPath().length) {
                                    maxi = selectedPath.getPath().length;
                                    groupParent = shape.getGroup();
                                }
                                data.removeGroup(shape.getGroup(), shape);
                                data.addGroup(newGroup, shape);
                                shape.setGroup(newGroup);
                                jTextPaneInformations.setText("Grouped !");
                            } else {
                                jTextPaneInformations.setText("Shape not found");
                            }
                        }
                    }
                }
            }

            groupParent.getShapes().add(newGroup);
            data.update();
        }

    }
}
