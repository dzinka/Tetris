package com.mygdx.game;


public class Figure {
    private FigureForm form;
    private Coord start;
    private RotationMode currentRotation;

    public Figure(){
        this.form = FigureForm.getRandomForm();
        this.start = Coord.GerRandomCoord(form.getForm());
        this.currentRotation = RotationMode.NORMAL;
    }

    public Coord getStart() {
        return start;
    }

    public FigureForm getForm() {
        return form;
    }

    public void rotate(){
        this.currentRotation = RotationMode.getNextRotationFrom(currentRotation);
    }

    public RotationMode getCurrentRotation() {
        return currentRotation;
    }

}
