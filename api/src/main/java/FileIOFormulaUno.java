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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class FileIOFormulaUno implements FileIO {

    private final String file;
    private final char[][] racetrack;
    private final List<Player> playerList;
    private final List<Integer> finishLine;

    public FileIOFormulaUno(String file) throws FileReaderError {
        this.file = file;
        this.racetrack = parseRacetrack(readFile());
        this.playerList = parsePlayers(racetrack);
        this.finishLine = parseFinishLine(playerList);
    }

    /**
     * Read the input file
     * @return file read as input
     * @throws FileReaderError Exception in case of incorrect reading of the file
     */
    private List<String> readFile() throws FileReaderError {
        ClassLoader classLoader = FileIOFormulaUno.class.getClassLoader();
        List<String> track = new LinkedList<>();
        try (InputStream inputStream = classLoader.getResourceAsStream(this.file)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) { track.addLast(line);}
                return track;
            }
        } catch (IOException e) {
            throw new FileReaderError("Error reading the file");
        }
    }

    /**
     * Parse the input file and generates the racetrack
     * @param file file read as input
     * @return racetrack
     */
    private char[][] parseRacetrack(List<String> file) {
        char[][] racetrack = new char[file.size()][file.getFirst().length()];
        for(int j = 0; j < file.size(); j++) {
            for(int i = 0; i < file.getFirst().length(); i++) {
                racetrack[j][i] = file.get(j).charAt(i);
            }
        }
        return racetrack;
    }

    /**
     * Parse the track and generates the list of competing players
     * @param racetrack racetrack
     * @return the list of competing players
     */
    private List<Player> parsePlayers(char[][] racetrack) {
        List<Player> players = new LinkedList<>();
        int c = 0;
        for(int i = 0; i < racetrack.length; i++) {
            for(int j = 0; j < racetrack[0].length; j++) {
                if(racetrack[i][j] == 'B') {
                    players.addLast(new botPlayer((++c) + "B",'B', new gameMachineFormulaUno(new positionFormulaUno(j, i))));
                }
            }
        }
        return players;
    }

    /**
     * Generate the coordinates of the race finish line
     * @param players list of competing players
     * @return Coordinates of the finish line
     */
    private List<Integer> parseFinishLine(List<Player> players) {
        List<Integer> finishLine = new LinkedList<>();
        finishLine.addLast(players.getLast().getGameMachine().getPosition().x());
        finishLine.addLast(players.getLast().getGameMachine().getPosition().y() + 1);
        return finishLine;
    }

    @Override
    public char[][] getRacetrack() {
        return this.racetrack;
    }

    @Override
    public List<Player> getPlayers() {
        return this.playerList;
    }

    @Override
    public List<Integer> getFinishLine() {
        return this.finishLine;
    }
}
