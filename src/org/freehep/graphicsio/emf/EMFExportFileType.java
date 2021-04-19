// Copyright 2000-2006 FreeHEP
package org.freehep.graphicsio.emf;

import java.awt.Component;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.freehep.graphics2d.VectorGraphics;
import org.freehep.graphicsio.exportchooser.AbstractExportFileType;
import org.freehep.graphicsio.exportchooser.BackgroundPanel;
import org.freehep.graphicsio.exportchooser.OptionPanel;
import org.freehep.swing.layout.TableLayout;
import org.freehep.util.UserProperties;

/**
 * // FIXME, check all options
 * 
 * @author Mark Donszelmann
 * @version $Id: EMFExportFileType.java 10305 2007-01-12 23:43:03Z duns $
 */
public class EMFExportFileType extends AbstractExportFileType {

    public String getDescription() {
        return "Windows Enhanced Metafile";
    }

    public String[] getExtensions() {
        return new String[] { "emf" };
    }

    public String[] getMIMETypes() {
        return new String[] { "image/x-emf" };
    }

    public boolean hasOptionPanel() {
        return true;
    }

    public JPanel createOptionPanel(Properties user) {
        UserProperties options = new UserProperties(user, EMFGraphics2D
                .getDefaultProperties());

        String rootKey = EMFGraphics2D.class.getName();

        // Make the full panel.
        OptionPanel optionsPanel = new OptionPanel();
        optionsPanel.add("0 0 [5 5 5 5] wt", new BackgroundPanel(options,
                rootKey, true));
        optionsPanel.add(TableLayout.COLUMN_FILL, new JLabel());

        return optionsPanel;
    }

    public VectorGraphics getGraphics(OutputStream os, Component target)
            throws IOException {

        return new EMFGraphics2D(os, target);
    }
}
