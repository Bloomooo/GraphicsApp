package Model;

import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un groupe de formes, qui peut contenir à la fois des
 * formes individuelles et d'autres groupes.
 * Chaque groupe a un nom, une liste de formes et une liste de groupes enfants.
 * Elle offre des méthodes pour gérer et manipuler les formes et les groupes
 * dans le groupe.
 */
public class Group extends Shape {
    private List<Shape> shapes;
    private Shape group;
    private String name;

    public Group(String name) {
        this.shapes = new ArrayList<>();
        this.name = name;
    }

    public DefaultMutableTreeNode getTreeModel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(name);
        for (Shape shape : shapes) {
            root.add(shape.getJTreeNodes());
        }
        return root;
    }

    public boolean contain(Shape shape) {
        return shapes.contains(shape);
    }

    public void deleteGroupVoid(Group group) {
        if (shapes.contains(group)) {
            shapes.remove(group);
        } else {
            for (Shape shape : shapes) {
                shape.deleteGroupVoid(group);
            }
        }
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
        shape.setGroup(this);
    }

    public void removeShape(Shape shape) {
        this.shapes.remove(shape);
        shape.setGroup(null);
    }

    public int getSize() {
        return shapes.size();
    }

    @Override
    public int getWidth() {
        return -1;
    }

    @Override
    public int getHeight() {
        return -1;
    }

    @Override
    void setX(int x) {

    }

    @Override
    void setY(int y) {

    }

    @Override
    void setRadius(int radius) {

    }

    @Override
    public double getRadius() {
        return 0;
    }

    @Override
    void setWidth(int width) {

    }

    @Override
    void setHeight(int height) {

    }

    @Override
    void setSize(int size) {

    }

    @Override
    boolean containsPoint(int x, int y) {
        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public List<Shape> getShapes() {
        return this.shapes;
    }

    public void draw(Graphics g) {
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    @Override
    public Group getGroup() {
        return (Group) group;
    }

    @Override
    public void setSelected(boolean bool) {

    }

    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(name);
        for (Shape shape : shapes) {
            root.add(shape.getJTreeNodes());
        }
        return root;
    }

    @Override
    public String getType() {
        return "Group";
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public Shape search(String name, int x, int y) {
        for (Shape shape : shapes) {
            if (shape.getType().equals(name) && shape.getX() == x && shape.getY() == y) {
                return shape;
            } else if (shape.getType().equals("Group")) {
                Shape tmp = shape.search(name, x, y);
                if (tmp != null) {
                    return tmp;
                }
            }
        }
        return null;
    }

    @Override
    public Shape searchWithMouse(java.awt.event.MouseEvent e) {
        for (Shape shape : shapes) {
            if (shape.containsPoint(e.getX(), e.getY())) {
                return shape;
            } else if (shape.getType().equals("Group")) {
                Shape tmp = shape.searchWithMouse(e);
                if (tmp != null) {
                    return tmp;
                }
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void removeAllShape() {
        int i = shapes.size() - 1;
        while (i >= 0) {
            if (shapes.get(i).getType().equals("Group")) {
                Group tmp = (Group) shapes.get(i);
                tmp.removeAllShape();
            } else {
                shapes.remove(i);
            }
            i--;
        }
    }

    public void deleteGroup(String name) {
        for (Shape shape : shapes) {
            if (shape.getName().equals(name)) {
                int i = shape.getShapes().size() - 1;
                while (i >= 0) {
                    if (shape.getShapes().get(i).getType().equals("Group")) {
                        Group tmp = (Group) shape;
                        tmp.removeAllShape();
                    } else {
                        shape.getShapes().remove(i);
                    }
                    i--;
                }
            }
        }
    }

    public Group getParent(Group root) {
        if (!this.equals(root)) {
            if (root.contain(this)) {
                return root;
            } else {
                for (Shape shape : root.getShapes()) {
                    if (shape.getType().equals("Group")) {
                        Group tmp = this.getParent((Group) shape);
                        if (tmp != null) {
                            return tmp;
                        }
                    }

                }
            }

        }
        return null;
    }

    @Override
    void setColor(Color color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setColor'");
    }
}