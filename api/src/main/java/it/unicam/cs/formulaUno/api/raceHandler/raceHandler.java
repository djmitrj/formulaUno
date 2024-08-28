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

/**
 * @param <T> type of the racetrack
 */
public interface raceHandler<T> {

    /**
     * Update a player's position on the racetrack
     * @param raceTrack racetrack of the game
     * @param player player to change the position of
     * @param position new position to assign to the player
     * @throws NullPointerException if at least one of the passed arguments is null
     * @throws IllegalArgumentException if the passed player is not in the race
     */
    void updatePlayerPosition(raceTrack<T> raceTrack, Player player, Position position);

    /**
     * Eliminate the player from the race
     * @param raceTrack racetrack of the game
     * @param player player to eliminate
     * @throws NullPointerException if at least one of the passed arguments is null
     * @throws IllegalArgumentException if the passed player is not in the race
     */
    void removePlayer(raceTrack<T> raceTrack, Player player);

    /**
     * Check if Player goes off racetrack
     * @param raceTrack racetrack of the game
     * @param position position to check
     * @throws NullPointerException if at least one of the passed arguments is null
     * @return True if Player goes off racetrack, False otherwise
     */
    boolean checkPosition(raceTrack<T> raceTrack, Position position);

    /**
     * Check if a player is trying to cross the finish line incorrectly
     * @param raceTrack racetrack of the game
     * @param currentPosition current position of the player
     * @param newPosition position to check
     * @throws NullPointerException if at least one of the passed arguments is null
     * @return True if the move is incorrect, False otherwise
     */
    boolean checkFalseMove(raceTrack<T> raceTrack, Position currentPosition, Position newPosition);
}
