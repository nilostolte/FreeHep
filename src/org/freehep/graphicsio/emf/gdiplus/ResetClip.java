// Copyright 2006, FreeHEP.
package org.freehep.graphicsio.emf.gdiplus;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;

/**
 * The ResetClip metafile record specifies that the clipping region is set back to 
 * an infinite area.
 * 
 * @author Mark Donszelmann
 * @version $Id$
 */
public class ResetClip extends EMFPlusTag {

	public ResetClip() {
		super(49, 1);
	} 
	 
	public EMFPlusTag read(int tagID, int flags, EMFInputStream emf, int len)
			throws IOException {
		return new ResetClip();
	}
	
	public void write(int tagID, int flags, EMFOutputStream emf) throws IOException {
		// nop
	}

}
