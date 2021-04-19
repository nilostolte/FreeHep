// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.awt.Rectangle;
import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * Ellipse TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: Ellipse.java 10140 2006-12-07 07:50:41Z duns $
 */
public class Ellipse extends EMFTag {
    private Rectangle bounds;

    public Ellipse(Rectangle bounds) {
        this();
        this.bounds = bounds;
    }

    public Ellipse() {
        super(42, 1);
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {
        Ellipse tag = new Ellipse(emf.readRECTL());

        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeRECTL(bounds);
    }

    public String toString() {
        return super.toString() + "\n" + "  bounds: " + bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
