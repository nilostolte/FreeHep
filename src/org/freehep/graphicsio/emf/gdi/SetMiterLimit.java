// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * SetMiterLimit TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: SetMiterLimit.java 10140 2006-12-07 07:50:41Z duns $
 */
public class SetMiterLimit extends EMFTag {

    private int limit;

    public SetMiterLimit() {
        super(58, 1);
    }

    public SetMiterLimit(int limit) {
        this();
        this.limit = limit;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        SetMiterLimit tag = new SetMiterLimit(emf.readDWORD());
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeDWORD(limit);
    }

    public String toString() {
        return super.toString() + "\n" + "  limit: " + limit;
    }
}
