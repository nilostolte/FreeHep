// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * PolyPolyline16 TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: PolyPolyline16.java 10140 2006-12-07 07:50:41Z duns $
 */
public class PolyPolyline16 extends EMFTag {

    private Rectangle bounds;

    private int numberOfPolys;

    private int[] numberOfPoints;

    private Point[][] points;

    public PolyPolyline16() {
        super(90, 1);
    }

    public PolyPolyline16(Rectangle bounds, int numberOfPolys,
            int[] numberOfPoints, Point[][] points) {
        this();
        this.bounds = bounds;
        this.numberOfPolys = numberOfPolys;
        this.numberOfPoints = numberOfPoints;
        this.points = points;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        Rectangle bounds = emf.readRECTL();
        int np = emf.readDWORD();
        /* int totalNumberOfPoints = */ emf.readDWORD();
        int[] pc = new int[np];
        Point[][] points = new Point[np][];
        for (int i = 0; i < np; i++) {
            pc[i] = emf.readDWORD();
            points[i] = new Point[pc[i]];
        }
        for (int i = 0; i < np; i++) {
            points[i] = emf.readPOINTS(pc[i]);
        }
        PolyPolyline16 tag = new PolyPolyline16(bounds, np, pc, points);
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeRECTL(bounds);
        emf.writeDWORD(numberOfPolys);
        int c = 0;
        for (int i = 0; i < numberOfPolys; i++) {
            c += numberOfPoints[i];
        }
        emf.writeDWORD(c);
        for (int i = 0; i < numberOfPolys; i++) {
            emf.writeDWORD(numberOfPoints[i]);
        }
        for (int i = 0; i < numberOfPolys; i++) {
            emf.writePOINTS(numberOfPoints[i], points[i]);
        }
    }

    public String toString() {
        return super.toString() + "\n" + "  bounds: " + bounds + "\n"
                + "  #polys: " + numberOfPolys;
    }
}
