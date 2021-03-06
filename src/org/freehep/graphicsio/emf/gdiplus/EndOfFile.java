// Copyright 2006, FreeHEP.
package org.freehep.graphicsio.emf.gdiplus;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;

/**
 * The EndOfFile metafile record is a footer placed at the end 
 * of an EMF+ metafile (or the EMF+ portion thereof). It signals the end of all EMF+ data.
 * 
 * @author Mark Donszelmann
 * @version $Id$
 */
public class EndOfFile extends EMFPlusTag {

	public EndOfFile() {
		super(2, 1);
	} 
	 
	public EMFPlusTag read(int tagID, int flags, EMFInputStream emf, int len)
			throws IOException {
		return new EndOfFile();
	}
	
	public void write(int tagID, int flags, EMFOutputStream emf) throws IOException {
		// nop
	}

}
