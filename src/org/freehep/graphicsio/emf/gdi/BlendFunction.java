// Copyright 2002-2003, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFConstants;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;

/**
 * EMF BitmapInfoHeader
 * 
 * @author Mark Donszelmann
 * @version $Id: BlendFunction.java 10140 2006-12-07 07:50:41Z duns $
 */
public class BlendFunction implements EMFConstants {

    public static final int size = 4;

    private int blendOp;

    private int blendFlags;

    private int sourceConstantAlpha;

    private int alphaFormat;

    public BlendFunction(int blendOp, int blendFlags, int sourceConstantAlpha,
            int alphaFormat) {
        this.blendOp = blendOp;
        this.blendFlags = blendFlags;
        this.sourceConstantAlpha = sourceConstantAlpha;
        this.alphaFormat = alphaFormat;
    }

    public BlendFunction(EMFInputStream emf) throws IOException {
        blendOp = emf.readBYTE();
        blendFlags = emf.readBYTE();
        sourceConstantAlpha = emf.readBYTE();
        alphaFormat = emf.readBYTE();
    }

    public void write(EMFOutputStream emf) throws IOException {
        emf.writeBYTE(blendOp);
        emf.writeBYTE(blendFlags);
        emf.writeBYTE(sourceConstantAlpha);
        emf.writeBYTE(alphaFormat);
    }

    public String toString() {
        return "BlendFunction";
    }
}
