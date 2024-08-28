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

import it.unicam.cs.formulaUno.api.File.FileIO;
import it.unicam.cs.formulaUno.api.File.FileReaderError;
import it.unicam.cs.formulaUno.api.Player.Player;

import java.util.List;

public class raceTrackFormulaUno implements raceTrack<char[][]> {

    private final char[][] racetrack;
    private final List<Player> players;
    private final List<Integer> finishLine;

    public raceTrackFormulaUno(FileIO<char[][]> fileIO) throws FileReaderError {
        this.racetrack = fileIO.parseTrack(fileIO.readFile());
        this.players = fileIO.parsePlayers(getTrack());
        this.finishLine = fileIO.parseFinishLine(getPlayers());
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
