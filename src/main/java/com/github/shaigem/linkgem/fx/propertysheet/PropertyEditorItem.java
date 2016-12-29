package com.github.shaigem.linkgem.fx.propertysheet;

import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;

import java.util.Optional;

public class PropertyEditorItem<T> implements PropertySheet.Item {

    private final Property<T> property;
    private final String category;
    private final String name;
    private final String description;
    private final Class<? extends PropertyEditor<?>> propertyEditor;

    public PropertyEditorItem(String aCategory, Property<T> aProperty, String aName, String aDescription,Class<? extends PropertyEditor<?>> aPropertyEditor) {
        property = aProperty;
        category = aCategory;
        name = aName;
        description = aDescription;
        propertyEditor = aPropertyEditor;
    }

    public PropertyEditorItem(String aCategory, Property<T> aProperty, String aName, String aDescription) {
        this(aCategory, aProperty, aName, aDescription, StringPropertyEditor.class);
    }

    @Override
    public Class<?> getType() {
        return property.getClass();
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Object getValue() {
        return property.getValue();
    }

    @Override
    public void setValue(Object aValue) {
        property.setValue((T) aValue);
    }

    @Override
    public Optional<ObservableValue<?>> getObservableValue() {
        return Optional.ofNullable(property);
    }

    @Override
    public Optional<Class<? extends PropertyEditor<?>>> getPropertyEditorClass() {
        return Optional.ofNullable(propertyEditor);
    }

}