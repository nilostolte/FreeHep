// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.awt.geom.AffineTransform;
import java.io.IOException;

import org.freehep.graphicsio.emf.EMFConstants;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * ModifyWorldTransform TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: ModifyWorldTransform.java 10140 2006-12-07 07:50:41Z duns $
 */
public class ModifyWorldTransform extends EMFTag implements EMFConstants {

    private AffineTransform transform;

    private int mode;

    public ModifyWorldTransform() {
        super(36, 1);
    }

    public ModifyWorldTransform(AffineTransform transform, int mode) {
        this();
        this.transform = transform;
        this.mode = mode;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        ModifyWorldTransform tag = new ModifyWorldTransform(emf.readXFORM(),
                emf.readDWORD());
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeXFORM(transform);
        emf.writeDWORD(mode);
    }

    public String toString() {
        return super.toString() + "\n" + "  transform: " + transform + "\n"
                + "  mode: " + mode;
    }
}
