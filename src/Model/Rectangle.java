package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Rectangle extends Shape {
    private Group group;
    private Point p;
    private Color color;
    private int width = 100;
    private int height = 80;
    private boolean selected;

    public Rectangle(Shape shape, Point p, Color color) {
        this.group = (Group) shape;
        this.p = p;
        this.color = color;
        selected = false;
    }

    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String getName() {
        return getType();
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    public String toString(int padding) {
        String str = new String();

        str += getType() + "(" + p + ")";

        return str;
    }

    @Override
    public void setSelected(boolean bool) {
        this.selected = bool;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(this.p.x, this.p.y, width, height);
        if (selected) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.black);
        }
        g.drawRect(this.p.x, this.p.y, width, height);
    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(
                getType() + "(Center[" + p.x + ", " + p.y + "], W[" + width + "], H[" + height + "])");
    }

    @Override
    public int getX() {
        return this.p.x;
    }

    @Override
    public int getY() {
        return this.p.y;
    }

    @Override
    public void setX(int x) {
        this.p.x = x;
    }

    @Override
    public void setY(int y) {
        this.p.y = y;
    }

    @Override
    public void setRadius(int radius) {

    }

    @Override
    public double getRadius() {
        return (double) 0.0;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return (x >= this.p.x && x <= this.p.x + width &&
                y >= this.p.y && y <= this.p.y + height);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    void addShape(Shape shape) {

    }

    @Override
    void deleteGroupVoid(Group group) {

    }

    @Override
    Shape search(String name, int x, int y) {
        return null;
    }

    @Override
    Shape searchWithMouse(MouseEvent e) {
        return null;
    }

    @Override
    List<Shape> getShapes() {
        return null;
    }
}
