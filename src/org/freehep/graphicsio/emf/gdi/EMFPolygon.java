// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * PolylineTo TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: EMFPolygon.java 10140 2006-12-07 07:50:41Z duns $
 */
public class EMFPolygon extends EMFTag {

    private Rectangle bounds;

    private int numberOfPoints;

    private Point[] points;

    public EMFPolygon() {
        super(3, 1);
    }

    public EMFPolygon(Rectangle bounds, int numberOfPoints, Point[] points) {
        this();
        this.bounds = bounds;
        this.numberOfPoints = numberOfPoints;
        this.points = points;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        Rectangle r = emf.readRECTL();
        int n = emf.readDWORD();
        EMFPolygon tag = new EMFPolygon(r, n, emf.readPOINTL(n));
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeRECTL(bounds);
        emf.writeDWORD(numberOfPoints);
        emf.writePOINTL(numberOfPoints, points);
    }

    public String toString() {
        return super.toString() + "\n" + "  bounds: " + bounds + "\n"
                + "  #points: " + numberOfPoints;
    }
}
