package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Square extends Shape {
    private Group group;
    private Point p;
    private Color color;
    private int size = 100;
    private boolean selected;

    public Square(Shape shape, Point p, Color color) {
        this.group = (Group) shape;
        this.p = p;
        this.color = color;
        selected = false;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String getType() {
        return "Square";
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
        g.fillRect(this.p.x, this.p.y, size, size);
        if (selected) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.black);
        }
        g.drawRect(this.p.x, this.p.y, size, size);

    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(
                getType() + "(Center[" + p.x + ", " + p.y + "], W[" + size + "], H[" + size + "])");
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
    public String getName() {
        return getType();
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWidth'");
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHeight'");
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return (x >= this.p.x && x <= this.p.x + size &&
                y >= this.p.y && y <= this.p.y + size);
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
