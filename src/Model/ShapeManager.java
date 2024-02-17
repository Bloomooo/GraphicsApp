/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author adrien.peytavie
 */
public class ShapeManager extends Observable {
    private Shape root;

    public ShapeManager() {
        root = new Group("Formes");
    }

    public void add(Shape shape) {
        root.addShape(shape);
        setChanged();
        notifyObservers();
    }

    public Shape getRoot() {
        return root;
    }

    public void deleteGroup(Group group) {
        root.deleteGroupVoid(group);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Data{\n" + "  shape{\n" + root.toString() + "  }\n}";
    }

    public void draw(Graphics g) {
        root.draw(g);
    }

    public DefaultTreeModel getTreeModel() {
        DefaultMutableTreeNode rootTree = new DefaultMutableTreeNode("Formes");
        for (Shape shape : root.getShapes()) {
            rootTree.add(shape.getJTreeNodes());
        }
        return new DefaultTreeModel(rootTree);
    }

    public void deleteGroup(String name) {
        if (!root.getName().equals(name)) {
            Group tmp = (Group) root;
            tmp.deleteGroup(name);
        }
    }

    public void remove(Shape shape) {
        Shape shape1 = this.search(shape.getType(), shape.getX(), shape.getY());
        shape1.getGroup().removeShape(shape1);
        shape1.setGroup(null);
    }

    public Shape search(String name, int x, int y) {
        return root.search(name, x, y);
    }

    public Shape searchWithMouse(java.awt.event.MouseEvent e) {
        return root.searchWithMouse(e);
    }

    public void modify(int x, int y, int radius, int width, int height, int size, Color color, Shape shapeModify) {
        Shape searchShape = root.search(shapeModify.getType(), shapeModify.getX(), shapeModify.getY());
        if (searchShape != null) {
            shapeModify.setX(x);
            shapeModify.setY(y);
            shapeModify.setColor(color);
            if (shapeModify.getType().equals("Square")) {
                shapeModify.setSize(size);
            } else if (shapeModify.getType().equals("Rectangle")) {
                shapeModify.setWidth(width);
                shapeModify.setHeight(height);
            } else {
                shapeModify.setRadius(radius);
            }
        }
    }

    public void addGroup(Group group, Shape shape) {
        group.addShape(shape);
        setChanged();
        notifyObservers();
    }

    public void removeGroup(Group group, Shape shape) {
        group.removeShape(shape);
        setChanged();
        notifyObservers();
    }

    public void update() {
        setChanged();
        notifyObservers();
    }
}
