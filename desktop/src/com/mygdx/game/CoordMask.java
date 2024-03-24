package com.mygdx.game;

import java.lang.reflect.Array;

public enum CoordMask {
    I_FORM(
            new GenerationDelegate() {
                @Override
                public Coord[] generateFigure(Coord initalCoord, RotationMode rotation) {
                    Coord[] ret = new Coord[4];

                    switch (rotation){
                        case NORMAL:
                        case INVERT:
                            ret[0] = initalCoord;
                            ret[1] = new Coord(initalCoord.x , initalCoord.y - 1);
                            ret[2] = new Coord(initalCoord.x, initalCoord.y - 2);
                            ret[3] = new Coord(initalCoord.x, initalCoord.y - 3);
                            break;
                        case FLIP_CCW:
                        case FLIP_CW:
                            ret[0] = initalCoord;
                            ret[1] = new Coord(initalCoord.x + 1, initalCoord.y);
                            ret[2] = new Coord(initalCoord.x + 2, initalCoord.y);
                            ret[3] = new Coord(initalCoord.x + 3, initalCoord.y);
                            break;
                    }

                    return ret;
                }
            }
    );

    /**
     * Делегат, содержащий метод,
     * который должен определять алгоритм для generateFigure()
     */
    private interface GenerationDelegate{
        Coord[] generateFigure(Coord initialCoord,  RotationMode rotation);
    }

    private GenerationDelegate forms;

    CoordMask(GenerationDelegate forms){
        this.forms = forms;
    }
    public Coord[] generateFigure(Coord initialCoord, RotationMode rotation){
        return this.forms.generateFigure(initialCoord, rotation);
    }
}
