// Copyright 2001-2006, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;
import org.freehep.util.io.Tag;

/**
 * GDIComment TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: GDIComment.java 10305 2007-01-12 23:43:03Z duns $
 */
public class GDIComment extends EMFTag {

    private static final String EMF_PLUS = "EMF+";
    
    private byte[] bytes;
    private EMFTag tag;
    
    public GDIComment() {
        super(70, 1);
    }

    public GDIComment(String comment) {
        this(comment.getBytes());
    }

    public GDIComment(byte[] bytes) {
        this();
        this.bytes = bytes;
    }

    // FIXME should be EMFPlusTag
    public GDIComment(EMFTag tag) {
        this();
        this.tag = tag;
    }
    
    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {
// FIXME decode internal EMFPlus Tags
        int l = emf.readDWORD();
        GDIComment tag = new GDIComment(emf.readBYTE(l));
        // Align to 4-byte boundary
        if (l % 4 != 0)
            emf.readBYTE(4 - l % 4);
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        if (tag != null) {
            emf.pushBuffer();
            emf.writeBYTE(EMF_PLUS.getBytes());
            emf.writeTag(tag, true);
            int len = emf.popBuffer();
            emf.writeDWORD(len);
            emf.append();
        } else {
            emf.writeDWORD(bytes.length);
            emf.writeBYTE(bytes);
            if (bytes.length % 4 != 0) {
                for (int i = 0; i < 4 - bytes.length % 4; i++) {
                    emf.writeBYTE(0);
                }
            }
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("\n");
        sb.append("  length: ");
        sb.append(bytes.length);
        sb.append("\n");
        String s = new String(bytes);
        if (s.startsWith(EMF_PLUS)) {
            try {
                EMFInputStream emf = new EMFInputStream(new ByteArrayInputStream(bytes, 4, bytes.length-4), 0x4001);
                sb.append(" --> Embedding:\n");
                Tag emfPlusTag = emf.readTag();
                while (emfPlusTag != null) {
                    sb.append(emfPlusTag);
                    emfPlusTag = emf.readTag();
                    if (emfPlusTag != null) sb.append("\n");
                }
                emf.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        } else {
            int n = Math.min(bytes.length, 40);
            sb.append("  bytes: ");
            for (int i=0; i<n; i++) {
                if (i != 0) sb.append(" ");
                sb.append(Integer.toHexString(bytes[i]));
            }
            sb.append(" ");
            sb.append(new String(bytes));
        }
        return sb.toString();
    }
}
