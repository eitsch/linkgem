package com.github.shaigem.linkgem.fx.propertysheet.editor;

import com.github.shaigem.linkgem.util.LocationUtil;
import org.controlsfx.control.PropertySheet;

/**
 * Property editor used to edit the bookmark's location or URL.
 *
 * @author Ronnie Tran
 */
public class LocationPropertyEditor extends StringPropertyEditorWithEmptyValidation {

    public LocationPropertyEditor(PropertySheet.Item aItem) {
        super(aItem);
    }

    @Override
    protected void commitChanges() {
        if (!getValidationSupport().isInvalid()) {
            String text = getTextField().getText();
            if (!LocationUtil.validLocation(text)) {
                text = "http://" + text;
                getTextField().setText(text);
            }
            getItem().setValue(text);
        }
    }

}
