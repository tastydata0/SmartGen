package com.genetic.bots.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Show extends Label {
    public Show(CharSequence text, Skin skin) {
        super(text, skin);
    }

    public Show(CharSequence text, Skin skin, String styleName) {
        super(text, skin, styleName);
    }

    /**
     * Creates a label, using a {@link LabelStyle} that has a BitmapFont with the specified name from the skin and the specified
     * color.
     *
     * @param text
     * @param skin
     * @param fontName
     * @param color
     */
    public Show(CharSequence text, Skin skin, String fontName, Color color) {
        super(text, skin, fontName, color);
    }

    /**
     * Creates a label, using a {@link LabelStyle} that has a BitmapFont with the specified name and the specified color from the
     * skin.
     *
     * @param text
     * @param skin
     * @param fontName
     * @param colorName
     */
    public Show(CharSequence text, Skin skin, String fontName, String colorName) {
        super(text, skin, fontName, colorName);
    }

    public Show(CharSequence text, LabelStyle style) {
        super(text, style);
    }

    @Override
    public String toString() {
        return getText()+"";
    }
}