// Copyright 2006 FreeHEP
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
 * 
 * @author Mark Donszelmann
 * @version $Id: EMFExportFileType.java 10100 2006-11-30 18:44:02Z duns $
 */
public class EMFPlusExportFileType extends AbstractExportFileType {

    public String getDescription() {
        return "Windows Enhanced Metafile Plus";
    }

    public String[] getExtensions() {
        // NOTE: the extension emf+ is strictly not correct, but ExportFileType will not select it otherwise.
        return new String[] { "emf", "emf+" };
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

        String rootKey = EMFPlusGraphics2D.class.getName();

        // Make the full panel.
        OptionPanel optionsPanel = new OptionPanel();
        optionsPanel.add("0 0 [5 5 5 5] wt", new BackgroundPanel(options,
                rootKey, true));
        optionsPanel.add(TableLayout.COLUMN_FILL, new JLabel());

        return optionsPanel;
    }

    public VectorGraphics getGraphics(OutputStream os, Component target)
            throws IOException {

        return new EMFPlusGraphics2D(os, target);
    }
}
