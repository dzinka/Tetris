package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public enum FigureForm {
    LINE_FORM(new int[][]{
            {1, 1, 1, 1}
    }, Color.BLUE),
    L_FORM(new int[][]{
            {1, 0},
            {1, 0},
            {1, 1}
    }, Color.RED),
    J_FORM(new int[][]{
            {0, 1},
            {0, 1},
            {1, 1}
    }, Color.GREEN),
    S_FORM(new int[][]{
            {0, 1, 1},
            {1, 1, 0}
    }, Color.YELLOW);

    private final int[][] formArray;
    private final Color color;

    FigureForm(int[][] formArray, Color color) {
        this.formArray = formArray;
        this.color = color;
    }

    public int[][] getForm() {
        return formArray;
    }

    public Color getColor() {
        return color;
    }

    public static FigureForm getRandomForm() {
        FigureForm[] values = FigureForm.values();
        int randomIndex = (int) (Math.random() * values.length);
        return values[randomIndex];
    }
}
