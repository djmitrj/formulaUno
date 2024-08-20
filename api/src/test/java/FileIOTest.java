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

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileIOTest {

    FileIO fileIO = new FileIOFormulaUno("racetrack.txt");
    char[][] track = fileIO.getRacetrack();
    List<Player> players = fileIO.getPlayers();
    List<Integer> finishLine = fileIO.getFinishLine();

    public FileIOTest() throws FileReaderError {
    }


    @Test
    public void parseTrackTest() {
        assertEquals(17,track.length);
        assertEquals(16,track[0].length);
        assertEquals('B',track[8][2]);
        assertEquals('0',track[9][2]);
        assertEquals('1',track[8][1]);
    }

    @Test
    public void parsePlayerTest() {
        assertEquals(4,players.size());
        assertEquals('B',players.get(0).getCategory());
        assertEquals("4B",players.get(3).getId());
    }

    @Test
    public void parseFinishLineTest() {
        assertEquals(5,finishLine.get(0));
        assertEquals(9,finishLine.get(1));
    }
}
