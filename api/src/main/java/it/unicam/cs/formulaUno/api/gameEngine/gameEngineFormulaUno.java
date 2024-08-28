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

package it.unicam.cs.formulaUno.api.gameEngine;

import it.unicam.cs.formulaUno.api.Console.*;
import it.unicam.cs.formulaUno.api.Player.*;
import it.unicam.cs.formulaUno.api.Position.*;
import it.unicam.cs.formulaUno.api.playerMove.*;
import it.unicam.cs.formulaUno.api.raceHandler.*;
import it.unicam.cs.formulaUno.api.raceTrack.*;

public class gameEngineFormulaUno implements gameEngine {

    private boolean gameRunning;
    private final Console<char[][]> console;
    private final raceHandler<char[][]> raceHandlerFormulaUno;
    private final raceTrack<char[][]> raceTrackFormulaUno;
    private final playerMove playerMoveFormulaUno;

    /**
     * Constructor of the Formula Uno game engine
     * @param console console's operations
     * @param raceHandlerFormulaUno handler of racetrack and competing players
     */
    public gameEngineFormulaUno(raceHandler<char[][]> raceHandlerFormulaUno,raceTrack<char[][]> raceTrackFormulaUno,
                                Console<char[][]> console, playerMove playerMoveFormulaUno) {
        if(raceHandlerFormulaUno == null || raceTrackFormulaUno == null
                || console == null || playerMoveFormulaUno == null)
            throw new NullPointerException("At least one of the parameters is null");
        this.gameRunning = true;
        this.console = console;
        this.raceTrackFormulaUno = raceTrackFormulaUno;
        this.raceHandlerFormulaUno = raceHandlerFormulaUno;
        this.playerMoveFormulaUno = playerMoveFormulaUno;
    }

    @Override
    public void start() {
        this.console.messageStart();
        while(this.gameRunning) {
           this.console.printPlayers(this.raceTrackFormulaUno.getPlayers());
           for(int i = 0; i < this.raceTrackFormulaUno.getPlayers().size(); i++) {
               Player player = this.raceTrackFormulaUno.getPlayers().get(i);
               this.playerTurn(player);
               if(this.checkVictory(player)) {
                   this.gameRunning = false;
                   break;
               }
           }
           if(checkListPlayers()) this.gameRunning = false;
        }
    }

    /**
     * Check if a player has won
     * @param player player whose victory is to be verified
     * @return True if Player won, False otherwise
     */
    private boolean checkVictory(Player player) {
        if(player == null) throw new NullPointerException("The passed player is null");
        if(player.getGameMachine().getLastPosition() == null) return false;
        if(this.raceTrackFormulaUno.getFinishLine().get(1) >= player.getGameMachine().getPosition().y()
                && player.getGameMachine().getLastPosition().y() > this.raceTrackFormulaUno.getFinishLine().get(1)
                && player.getGameMachine().getPosition().x() <= this.raceTrackFormulaUno.getFinishLine().get(0)) {
            this.console.printTrack(this.raceTrackFormulaUno.getTrack());
            this.console.messageVictory(player);
            return true;
        }
        return false;
    }

    /**
     * Check if there are still players in the race
     * True if at least one player is competing, False otherwise
     */
    private boolean checkListPlayers() {
        if(this.raceTrackFormulaUno.getPlayers().isEmpty()) {
            this.console.messageFinish();
            return true;
        }
        return false;
    }

    /**
     * Check whether the move entered by the player can be made or not,
     * check if the new possible position of the player is inside the track,
     * if it is in a free area of the track or if the player crosses the finish line
     * incorrectly
     * @param player player making the move
     * @param newPosition new possible position of the player
     * @return True if the move is valid, False otherwise and the Player will be eliminated from the race
     */
    private boolean checkMove(Player player, Position newPosition) {
        if(player == null || newPosition == null)
            throw new NullPointerException("At least one of the parameters is null");
        if(this.raceHandlerFormulaUno.checkPosition(this.raceTrackFormulaUno,newPosition) ||
           (this.raceHandlerFormulaUno.checkFalseMove(this.raceTrackFormulaUno,player.getGameMachine().getPosition(),newPosition))) {
                this.raceHandlerFormulaUno.removePlayer(this.raceTrackFormulaUno, player);
                return false;
        }
        return true;
    }

    /**
     * Make the player's move if possible and update his position
     * @param player player of duty
     */
    private void playerTurn(Player player)  {
        if(player == null) throw new NullPointerException("The passed player is null");
        this.console.playerTurn(player);
        Position newPosition = playerMoveFormulaUno.move(player);
        if(this.checkMove(player, newPosition)) {
            this.raceHandlerFormulaUno.updatePlayerPosition(this.raceTrackFormulaUno,player,newPosition);
            player.getGameMachine().setLastPosition(player.getGameMachine().getPosition());
            player.getGameMachine().setPosition(newPosition);
        } else {
            this.console.errorMove(player);
        }
        this.console.printTrack(this.raceTrackFormulaUno.getTrack());
    }
}