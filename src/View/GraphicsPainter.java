/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.ShapeManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

/**
 *
 * @author adrien.peytavie
 */
public class GraphicsPainter extends JComponent {

    ShapeManager data;

    public GraphicsPainter(ShapeManager d) {
        data = d;
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        data.draw(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.size().width, this.size().height);
    }

    @Override
    protected void paintChildren(Graphics g) {
        data.draw(g);
    }

}
