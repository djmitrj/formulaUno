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

import java.util.List;

public interface gameMachine {
    /**
     * Get the player's position on the racetrack
     * @return position of the player
     */
    Position getPosition();

    /**
     * Set the new player position
     * @param position new position of the player
     * @throws NullPointerException if the passed position is null
     */
    void setPosition(Position position);

    /**
     * Get the player's previous position
     * @return player's previous position
     */
    Position getLastPosition();

    /**
     * Set the player's previous position
     * @param position player's previous position
     * @throws NullPointerException if the passed position is null
     */
    void setLastPosition(Position position);

    /**
     * Get the player's next "normal" move
     * @return player's next "normal" move
     */
    Position getNextPosition();

    /**
     * Check a player's possible next moves
     * @return player's possible next moves
     */
    List<Position> possibleMoves();
}
