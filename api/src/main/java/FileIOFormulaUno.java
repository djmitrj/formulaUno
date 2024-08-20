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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileIOFormulaUno implements FileIO{

    private final String file;

    public FileIOFormulaUno(String file) {
        this.file = file;
    }

    @Override
    public List<String> readFile() throws FileReaderError {
        ClassLoader classLoader = FileIOFormulaUno.class.getClassLoader();
        List<String> track = new ArrayList<>();
        try (InputStream inputStream = classLoader.getResourceAsStream(this.file)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) { track.add(line);}
                return track;
            }
        } catch (IOException e) {
            throw new FileReaderError("Error reading the file");
        }
    }

    @Override
    public <T,K> T parseTrack(K file) {
        List<String> parseFile = (List<String>) file;
        char[][] track = new char[parseFile.size()][parseFile.getFirst().length()];
        for(int j = 0; j < parseFile.size(); j++) {
            for(int i = 0; i < parseFile.getFirst().length(); i++) {
                track[j][i] = parseFile.get(j).charAt(i);
            }
        }
        return (T) track;
    }

    @Override
    public <T> List<Player> parsePlayers(T track) {
        char[][] racetrack = (char[][]) track;
        int c = 0;
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < racetrack.length; i++) {
            for(int j = 0; j < racetrack[0].length; j++) {
                if(racetrack[i][j] == 'B') {
                    players.add(new botPlayer((++c) + "B",'B', new gameMachineFormulaUno(new positionFormulaUno(j, i))));
                }
            }
        }
        return players;
    }

    @Override
    public List<Integer> parseFinishLine(List<Player> players) {
        List<Integer> finishLine = new ArrayList<>();
        finishLine.add(players.getLast().getGameMachine().getPosition().x());
        finishLine.add(players.getLast().getGameMachine().getPosition().y() + 1);
        return finishLine;
    }
}