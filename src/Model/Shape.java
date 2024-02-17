package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public abstract class Shape {
    abstract void draw(Graphics g);

    public abstract Group getGroup();

    public abstract void setSelected(boolean bool);

    public abstract void setGroup(Group group);

    abstract DefaultMutableTreeNode getJTreeNodes();

    public abstract String getType();

    public abstract int getX();

    public abstract int getY();

    public abstract int getSize();

    public abstract int getWidth();

    public abstract int getHeight();

    abstract void setX(int x);

    abstract void setY(int y);

    abstract void setRadius(int radius);

    public abstract double getRadius();

    public abstract String getName();

    abstract void setWidth(int width);

    abstract void setHeight(int height);

    abstract void setSize(int size);

    abstract boolean containsPoint(int x, int y);

    abstract void setColor(Color color);

    public abstract Color getColor();

    abstract void addShape(Shape shape);

    abstract void deleteGroupVoid(Group group);

    abstract Shape search(String name, int x, int y);

    abstract Shape searchWithMouse(java.awt.event.MouseEvent e);

    abstract List<Shape> getShapes();
}