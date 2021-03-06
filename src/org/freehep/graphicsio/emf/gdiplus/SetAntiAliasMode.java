// Copyright 2006, FreeHEP.
package org.freehep.graphicsio.emf.gdiplus;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;

/**
 * The SetAntiAliasMode metafile record represents a change in the Graphics.SmoothingMode 
 * property, which controls the smoothing mode of the graphics object.
 * 
 * @author Mark Donszelmann
 * @version $Id$
 */
public class SetAntiAliasMode extends EMFPlusTag {
	    	
	public SetAntiAliasMode() {
		super(30, 1);
	}

	public SetAntiAliasMode(boolean antiAlias) {
		this();
		flags = antiAlias ? 0x01 : 0x00;
	}
		
	public EMFPlusTag read(int tagID, int flags, EMFInputStream emf, int len)
			throws IOException {
		SetAntiAliasMode tag = new SetAntiAliasMode();
		tag.flags = flags;
		return tag;
	}

	public void write(int tagID, int flags, EMFOutputStream emf) throws IOException {
		// nop
	}    
}
