/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpgraphicseditor;

import Model.ShapeFactory;
import Model.ShapeManager;
import View.Window;

/**
 *
 * @author adrien.peytavie
 */
public class TPGraphicsEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ShapeManager data = new ShapeManager();
        ShapeFactory s = new ShapeFactory();
        /* Create and display the form */
        new Window(data, s).setVisible(true);

    }

}
