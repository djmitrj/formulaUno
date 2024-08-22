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

package it.unicam.cs.formulaUno.api.File;

import it.unicam.cs.formulaUno.api.Player.*;

import java.util.List;

/**
 * @param <T> type of the racetrack
 */
public interface FileIO<T> {
    /**
     * Reads the game path file as input
     * @return file read as input
     * @throws FileReaderError Exception in case of incorrect reading of the file
     */
    List<String> readFile() throws FileReaderError;

    /**
     * Parse the input file and generates the racetrack
     * @param file file read as input
     * @return racetrack
     * //@param <T> type of the racetrack
     */
    T parseTrack(List<String> file);

    /**
     * Parse the racetrack and generates the list of competing players
     * @param racetrack racetrack
     * @return the list of competing players
     * //@param <T> type of the racetrack
     */
    List<Player> parsePlayers(T racetrack);

    /**
     * Generate the coordinates of the race finish line
     * @param players list of competing players
     * @return Coordinates of the finish line
     */
    List<Integer> parseFinishLine(List<Player> players);
}
