/*
 * Copyright (c) 2024 Demetrio Angeloni
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package it.unicam.cs.formulaUno.api.gameMachine;

import it.unicam.cs.formulaUno.api.Position.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the player's gaming machine
 */
public class gameMachineFormulaUno implements gameMachine {

    private Position position;
    private Position lastPosition;

    /**
     * Constructor of a machine of a Formula Uno player
     * @param position initial position of the machine
     * @throws NullPointerException if the passed position is null
     */
    public gameMachineFormulaUno(Position position) {
        if(position == null) throw new
                NullPointerException("The passed position is null");
        this.position = position;
        this.lastPosition = null;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        if(position == null) throw new
                NullPointerException("The passed position is null");
        this.position = position;
    }

    @Override
    public Position getLastPosition() {
        return lastPosition;
    }

    @Override
    public void setLastPosition(Position position) {
        if(position == null) throw new
                NullPointerException("The passed position is null");
        this.lastPosition = position;
    }

    @Override
    public Position getNextPosition() {
        return new positionFormulaUno(getPosition().x() + (getPosition().x() - getLastPosition().x()),
                getPosition().y() + (getPosition().y() - getLastPosition().y()));
    }

    @Override
    public List<Position> possibleMoves() {
        List<Position> possiblePositions = new ArrayList<>();
        possiblePositions.add(getNextPosition());
        possiblePositions.add(new positionFormulaUno(getNextPosition().x() +1,getNextPosition().y()));
        possiblePositions.add(new positionFormulaUno(getNextPosition().x() +1,getNextPosition().y() +1));
        possiblePositions.add(new positionFormulaUno(getNextPosition().x() +1,getNextPosition().y() -1));
        possiblePositions.add(new positionFormulaUno(getNextPosition().x() -1,getNextPosition().y()-1));
        possiblePositions.add(new positionFormulaUno(getNextPosition().x(),getNextPosition().y()+1));
        possiblePositions.add(new positionFormulaUno(getNextPosition().x()-1,getNextPosition().y()));
        possiblePositions.add(new positionFormulaUno(getNextPosition().x(),getNextPosition().y()-1));
        possiblePositions.add(new positionFormulaUno(getNextPosition().x()-1,getNextPosition().y()+1));
        return possiblePositions;
    }
}
