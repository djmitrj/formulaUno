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

package it.unicam.cs.formulaUno.api.raceTrack;

import it.unicam.cs.formulaUno.api.raceTrackParser.raceTrackParser;
import it.unicam.cs.formulaUno.api.raceTrackParser.FileReaderError;
import it.unicam.cs.formulaUno.api.Player.Player;

import java.util.List;

public class raceTrackFormulaUno implements raceTrack<char[][]> {

    private final char[][] racetrack;
    private final List<Player> players;
    private final List<Integer> finishLine;

    /**
     * Constructor of the raceTrack of Formula Uno game
     * @param raceTrackParser file read as input
     * @throws FileReaderError Exception in case of incorrect reading of the file
     */
    public raceTrackFormulaUno(raceTrackParser<char[][]> raceTrackParser) throws FileReaderError {
        if(raceTrackParser == null) throw new NullPointerException("The parameter is null");
        this.racetrack = raceTrackParser.parseTrack(raceTrackParser.readFile());
        this.players = raceTrackParser.parsePlayers(this.getTrack());
        this.finishLine = raceTrackParser.parseFinishLine(this.getPlayers());
    }

    @Override
    public char[][] getTrack() {
        return this.racetrack;
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public List<Integer> getFinishLine() {
        return this.finishLine;
    }
}
