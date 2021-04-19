// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * DeleteObject TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: DeleteObject.java 10140 2006-12-07 07:50:41Z duns $
 */
public class DeleteObject extends EMFTag {

    private int index;

    public DeleteObject() {
        super(40, 1);
    }

    public DeleteObject(int index) {
        this();
        this.index = index;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        DeleteObject tag = new DeleteObject(emf.readDWORD());
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeDWORD(index);
    }

    public String toString() {
        return super.toString() + "\n" + "  index: 0x"
                + Integer.toHexString(index);
    }

    public int getIndex() {
        return index;
    }
}
