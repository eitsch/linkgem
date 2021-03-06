package com.github.shaigem.linkgem.util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

import java.lang.reflect.Field;

/**
 * Created on 2016-12-31.
 */
public class TooltipUtil {


    private static final Duration TOOLTIP_ACTIVATION_DURATION = Duration.millis(600);

    /**
     * Changes the tooltip activation duration for all JavaFX tooltips.
     * Since JavaFX offers no way to manually change it, reflection must be used.
     * <p><a href="http://stackoverflow.com/questions/26854301/control-javafx-tooltip-delay">
     * http://stackoverflow.com/questions/26854301/control-javafx-tooltip-delay</a>
     * </p>
     */
    public static void changeDefaultTooltipActivationDuration() {
        try {
            Field fieldBehavior = Tooltip.class.getDeclaredField("BEHAVIOR");
            fieldBehavior.setAccessible(true);
            Object objBehavior = fieldBehavior.get(Tooltip.class);

            Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
            fieldTimer.setAccessible(true);
            Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

            objTimer.getKeyFrames().clear();
            objTimer.getKeyFrames().add(new KeyFrame(TOOLTIP_ACTIVATION_DURATION));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
