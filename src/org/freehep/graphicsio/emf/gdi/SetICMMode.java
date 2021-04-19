// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFConstants;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * SetICMMode TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: SetICMMode.java 10140 2006-12-07 07:50:41Z duns $
 */
public class SetICMMode extends EMFTag implements EMFConstants {

    private int mode;

    public SetICMMode() {
        super(98, 1);
    }

    public SetICMMode(int mode) {
        this();
        this.mode = mode;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        SetICMMode tag = new SetICMMode(emf.readDWORD());
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeDWORD(mode);
    }

    public String toString() {
        return super.toString() + "\n" + "  mode: " + mode;
    }
}
