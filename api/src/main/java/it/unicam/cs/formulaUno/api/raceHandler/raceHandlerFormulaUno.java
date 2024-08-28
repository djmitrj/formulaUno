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

package it.unicam.cs.formulaUno.api.raceHandler;


import it.unicam.cs.formulaUno.api.Player.*;
import it.unicam.cs.formulaUno.api.Position.*;
import it.unicam.cs.formulaUno.api.raceTrack.*;

public class raceHandlerFormulaUno implements raceHandler<char[][]> {

    private final raceTrack<char[][]> racetrack;

    /**
     * Constructor of the setup of the racetrack and the players competing in the Formula Uno game
     * @param raceTrack file of the racetrack
     */
    public raceHandlerFormulaUno(raceTrack<char[][]> raceTrack) {
        if(raceTrack == null) throw new NullPointerException("The passed parameter is null");
        this.racetrack = raceTrack;
    }

    @Override
    public void updatePlayerPosition(Player player, Position position) {
        if(player == null || position == null) {
            throw new NullPointerException("At least one of the passed arguments is null");
        }
        if(!this.racetrack.getPlayers().contains(player)) {
            throw new IllegalArgumentException("The passed player is not in the race");
        }
        this.racetrack.getTrack()[player.getGameMachine().getPosition().y()][player.getGameMachine().getPosition().x()] = '0';
        this.racetrack.getTrack()[position.y()][position.x()] = player.getCategory();
    }

    @Override
    public void removePlayer(Player player) {
        if(player == null ) {
            throw new NullPointerException("The passed player is null");
        }
        if(!this.racetrack.getPlayers().contains(player)) {
            throw new IllegalArgumentException("The passed player is not in the race");
        }
        this.racetrack.getTrack()[player.getGameMachine().getPosition().y()][player.getGameMachine().getPosition().x()] = '0';
        this.racetrack.getPlayers().remove(player);
    }

    @Override
    public boolean checkPosition(Position position) {
        if(position == null) {
            throw new NullPointerException("The passed position is null");
        }
        return (position.y() >= this.racetrack.getTrack().length -1 ||
                position.y() < 1 ||
                position.x() >= this.racetrack.getTrack()[0].length - 1 ||
                position.x() < 1 ||
                this.racetrack.getTrack()[position.y()][position.x()] != '0');
    }

    @Override
    public boolean checkFalseMove(Position currentPosition, Position newPosition) {
        if(currentPosition == null || newPosition == null) {
            throw new NullPointerException("At least one of the passed arguments is null");
        }
        return newPosition.y() >= this.racetrack.getFinishLine().get(1)
                && currentPosition.y() < this.racetrack.getFinishLine().get(1)
                && currentPosition.x() < this.racetrack.getFinishLine().get(0);
    }

    @Override
    public raceTrack<char[][]> getRaceTrack() {
        return this.racetrack;
    }

}
