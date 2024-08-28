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

package it.unicam.cs.formulaUno.api.Console;

import it.unicam.cs.formulaUno.api.Player.*;

import java.util.List;

public interface Console {
    /**
     * Print the racetrack on the console
     * @param racetrack racetrack
     * @param <T> type of the racetrack
     */
    <T> void printTrack(T racetrack);

    /**
     * Print the list of players competing with their positions
     * @param players list of players competing
     */
    void printPlayers(List<Player> players);

    /**
     * Print the race start message
     */
    void messageStart();

    /**
     * All Players have been eliminated, the competition is over
     */
    void messageFinish();

    /**
     * Victory message
     * @param player Winning player
     */
    void messageVictory(Player player);

    /**
     * Player on duty
     * @param player Player on duty
     */
    void playerTurn(Player player);

    /**
     * Wrong move
     */
    void errorMove(Player player);

}
