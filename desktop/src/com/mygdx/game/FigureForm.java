package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public enum FigureForm {

    I_FORM (CoordMask.I_FORM, Color.BLUE);

    private CoordMask mask;

    private Color color;

    FigureForm(CoordMask mask, Color color){
        this.mask = mask;
        this.color = color;
    }

    private static final FigureForm[] formByNumber = {I_FORM};

    public CoordMask getMask(){
        return this.mask;
    }

    public Color getColor(){
        return this.color;
    }


    public static FigureForm getRandomForm() {
        int formNumber = new Random().nextInt(formByNumber.length);
        return formByNumber[formNumber];
    }

}