package com.github.shaigem.linkgem.fx.propertysheet.editor;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;

/**
 * The default property editor for properties that contain a string.
 *
 * @author Ronnie Tran
 */
public class StringPropertyEditor implements PropertyEditor<String> {

    private final TextField textField;
    private PropertySheet.Item editingItem;

    public StringPropertyEditor(PropertySheet.Item aItem) {
        editingItem = aItem;
        textField = new TextField();
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                // when the textfield is no longer in focus, commit the changes
                commitChanges();
            }
        });
        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // when the user presses the Enter key, commit the changes
                commitChanges();
            }
        });

    }

    /**
     * Save any changes to the property based on the textfield editor.
     */
    private void commitChanges() {
        editingItem.setValue(textField.getText());
    }

    @Override
    public Node getEditor() {
        return textField;
    }

    @Override
    public String getValue() {
        return textField.getText();
    }

    @Override
    public void setValue(String aValue) {
        textField.setText(aValue);
    }

}
