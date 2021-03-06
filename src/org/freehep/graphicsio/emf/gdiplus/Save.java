// Copyright 2006, FreeHEP.
package org.freehep.graphicsio.emf.gdiplus;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;

/**
 * The Save metafile record represents a call to Graphics.Save, 
 * which begins a graphics container.
 * 
 * @author Mark Donszelmann
 * @version $Id$
 */
public class Save extends EMFPlusTag {
	
	private int containerIndex;
	
	public Save() {
		super(37, 1);
	}

	public Save(int containerIndex) {
		this();
		flags = 0;
		this.containerIndex = containerIndex;
	}
		
	public EMFPlusTag read(int tagID, int flags, EMFInputStream emf, int len)
			throws IOException {
		Save tag = new Save();
		tag.flags = flags;
		tag.containerIndex = emf.readUINT();
		return tag;
	}

	public void write(int tagID, int flags, EMFOutputStream emf) throws IOException {
		emf.writeUINT(containerIndex);
	}
    
    public String toString() {
        return super.toString() + "\n  index: "+containerIndex;
    }
}
