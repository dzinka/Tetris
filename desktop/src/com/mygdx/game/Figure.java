package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public class Figure {
    private Coord metaPointCoords;

    private RotationMode currentRotation;

    private FigureForm form;

    public Figure(Coord metaPointCoords){
        this.metaPointCoords = metaPointCoords;
        this.currentRotation = RotationMode.NORMAL;
        this.form = FigureForm.getRandomForm();
    }

    public Coord[] getCoords(){
        return form.getMask().generateFigure(metaPointCoords, currentRotation);
    }
}
