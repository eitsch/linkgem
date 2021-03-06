package com.github.shaigem.linkgem.fx.popup.quickinfo;

import javafx.scene.Cursor;
import javafx.scene.text.Text;

/**
 * Helper class for creating nodes with a quick information popup.
 *
 * @author Ronnie Tran
 */
public final class QuickInfoIcon {

    /**
     * Create a icon node that will display a quick info popup when hovered over.
     *
     * @param infoText the text that the popup will show
     * @param icon     the icon which will be displayed
     * @return the icon
     */
    public static Text create(final String infoText, final Text icon) {
        icon.setCursor(Cursor.DEFAULT);
        QuickInfoPopup.install(icon, new QuickInfoPopup(infoText));
        return icon;
    }
}
