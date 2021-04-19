// Copyright FreeHEP, 2014
package org.freehep.graphics2d.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.freehep.graphics2d.VectorGraphics;
import org.freehep.util.export.ExportDialog;

/**
 * This example shows how to add a standard ExportDialog
 * to your application and allow it to export what you draw
 * in panel to any of the supported vector and bitmap formats.
 *
 * Instead of MyPanel you should use your own panel/component.
 *
 * The output formats available depend on the jar files
 * you add to the CLASSPATH.
 *
 * This example (or your application) solely depends
 * on the ExportDialog class and the VectorGraphics
 * class (the latter only if you wish to use special
 * methods from this class in the paint methods).
 *
 * @author Mark Donszelmann
 */
public class ExportDialogExample2 {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("MenuInfographics6");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        final MyPanel2 panel = new MyPanel2();
        frame.getContentPane().add(panel);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        JMenuItem exportItem = new JMenuItem("Export...");
        exportItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExportDialog export = new ExportDialog();
                export.showExportDialog(panel, "Export view as ...", panel, "export");
            }
        });
        file.add(exportItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(quitItem);

        frame.pack();
        frame.setVisible(true);
    }
}

class MyPanel2 extends MenuInfographics6 {
	private static final long serialVersionUID = 1317455379981344343L;

	public MyPanel2() {
        setPreferredSize(new Dimension(500,635));		
	}

    public void paintComponent(Graphics g) {
    	Dimension dim = getSize();
        if (g == null) return;
        g.setColor(new Color(51,77,102));
        g.fillRect(0, 0, dim.width, dim.height);
        VectorGraphics vg = VectorGraphics.create(g);
        super.paintComponent(vg);
        
    }
}
