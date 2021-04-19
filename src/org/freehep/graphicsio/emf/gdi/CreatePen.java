// Copyright 2001, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * CreatePen TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: CreatePen.java 10140 2006-12-07 07:50:41Z duns $
 */
public class CreatePen extends EMFTag {

    private int index;

    private LogPen pen;

    public CreatePen() {
        super(38, 1);
    }

    public CreatePen(int index, LogPen pen) {
        this();
        this.index = index;
        this.pen = pen;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        CreatePen tag = new CreatePen(emf.readDWORD(), new LogPen(emf));
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeDWORD(index);
        pen.write(emf);
    }

    public String toString() {
        return super.toString() + "\n" + "  index: 0x"
                + Integer.toHexString(index) + "\n" + pen.toString();
    }

    public int getIndex() {
        return index;
    }

    public LogPen getPen() {
        return pen;
    }

}
