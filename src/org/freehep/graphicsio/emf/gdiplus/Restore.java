// Copyright 2006, FreeHEP.
package org.freehep.graphicsio.emf.gdiplus;

import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;

/**
 * The Restore metafile record represents a call to Graphics.Restore, 
 * which ends a graphics container.
 * 
 * @author Mark Donszelmann
 * @version $Id$
 */
public class Restore extends EMFPlusTag {
	
	private int containerIndex;
	
	public Restore() {
		super(38, 1);
	}

	public Restore(int containerIndex) {
		this();
		flags = 0;
		this.containerIndex = containerIndex;
	}
		
	public EMFPlusTag read(int tagID, int flags, EMFInputStream emf, int len)
			throws IOException {
		Restore tag = new Restore();
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
