// Copyright 2006, FreeHEP.
package org.freehep.graphicsio.emf.gdiplus;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;

/**
 * The DrawPath metafile record represents a call to Graphics.DrawPath, 
 * which draws the border of a GraphicsPath object.
 * 
 * @author Mark Donszelmann
 * @version $Id$
 */
public class DrawPath extends EMFPlusTag {
	
	private int penIndex;
	
	public DrawPath() {
		super(21, 1);
	}

	public DrawPath(int pathIndex, int penIndex) {
		this();
		flags = pathIndex;
		this.penIndex = penIndex;
	}
		
	public EMFPlusTag read(int tagID, int flags, EMFInputStream emf, int len)
			throws IOException {
		DrawPath tag = new DrawPath();
		tag.flags = flags;
		tag.penIndex = emf.readUINT();
		return tag;
	}

	public void write(int tagID, int flags, EMFOutputStream emf) throws IOException {
		emf.writeUINT(penIndex);
	}
    
    public String toString() {
        return super.toString() + "\n  penIndex: "+penIndex;
    }
}
