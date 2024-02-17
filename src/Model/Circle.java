/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author adrien.peytavie
 */
public class Circle extends Shape {
    private Group group;
    private Point center;
    private double radius;
    private boolean selected;
    Color color;

    public Circle(Shape shape, Point p, Color c) {
        this.group = (Group) shape;
        center = p;
        radius = 100;
        color = c;
        selected = false;
    }

    public Rectangle getBox() {
        return new Rectangle((int) (center.x), (int) (center.y), (int) (radius), (int) (radius));
    }

    @Override
    public String getName() {
        return getType();
    }

    @Override
    public void setSelected(boolean bool) {
        this.selected = bool;
    }

    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    public String toString(int padding) {
        String str = new String();

        str += getType() + "(" + center + ")";

        return str;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(center.x, center.y, (int) radius, (int) radius);
        if (selected) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.black);
        }
        g.drawOval(center.x, center.y, (int) radius, (int) radius);
    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {

        return new DefaultMutableTreeNode(
                getType() + "(Center[" + center.x + ", " + center.y + "], R[" + radius + "])");
    }

    @Override
    public int getX() {
        return this.center.x;
    }

    @Override
    public int getY() {
        return this.center.y;
    }

    @Override
    public void setX(int x) {
        this.center.x = x;
    }

    @Override
    public void setY(int y) {
        this.center.y = y;
    }

    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public void setWidth(int width) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setWidth'");
    }

    @Override
    public void setHeight(int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHeight'");
    }

    @Override
    public void setSize(int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSize'");
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
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
        double distance = Math.sqrt(Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2));
        return distance <= radius;
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
