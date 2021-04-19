// Copyright 2006, FreeHEP.
package org.freehep.graphicsio.emf.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.freehep.graphicsio.emf.EMFHandleManager;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;
import org.freehep.graphicsio.emf.gdi.EOF;
import org.freehep.graphicsio.emf.gdi.GDIComment;
import org.freehep.graphicsio.emf.gdiplus.Clear;
import org.freehep.graphicsio.emf.gdiplus.DrawLines;
import org.freehep.graphicsio.emf.gdiplus.EndOfFile;
import org.freehep.graphicsio.emf.gdiplus.GDIPlusObject;
import org.freehep.graphicsio.emf.gdiplus.Header;

public class EMFPlusDrawLinesTest extends JPanel {

    private static final long serialVersionUID = 1L;

    public EMFPlusDrawLinesTest() {
    }

    public void run() throws IOException {
        Rectangle bounds = new Rectangle(0, 0, 400, 400);
        List emf = new ArrayList();
        
        emf.add(new GDIComment(new Header()));
        emf.add(new GDIComment(new Clear(Color.ORANGE)));
        emf.add(new GDIComment(new GDIPlusObject(0, new BasicStroke(3), Color.BLACK)));
        float x[] = { 20, 50, 200 };
        float y[] = { 50, 100, 200 };
        emf.add(new GDIComment(new DrawLines(0, x, y)));
        emf.add(new GDIComment(new EndOfFile()));
        emf.add(new EOF());
        
        EMFOutputStream out = new EMFOutputStream(new FileOutputStream(
                "EMFPlusDrawLinesTest.emf"), bounds, new EMFHandleManager(), "EMFTest",
                "TestFile", new Dimension(1024, 768), 0x4001);
        for (int i = 0; i < emf.size(); i++) {
            out.writeTag((EMFTag) emf.get(i));
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        EMFPlusDrawLinesTest test = new EMFPlusDrawLinesTest();
        test.run();
        System.exit(0);
    }
}
