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

import it.unicam.cs.formulaUno.api.File.FileIO;
import it.unicam.cs.formulaUno.api.File.FileIOFormulaUno;
import it.unicam.cs.formulaUno.api.File.FileReaderError;
import it.unicam.cs.formulaUno.api.raceTrack.raceTrack;
import it.unicam.cs.formulaUno.api.raceTrack.raceTrackFormulaUno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaceTrackTest {

    private final FileIO<char[][]> fileIO = new FileIOFormulaUno("racetrack.txt");
    private final raceTrack<char[][]> raceTrack = new raceTrackFormulaUno(fileIO);

    public RaceTrackTest() throws FileReaderError {
    }

    @Test
    public void getTrackTest() {
        assertEquals(17,raceTrack.getTrack().length);
        assertEquals(16,raceTrack.getTrack()[0].length);
        assertEquals('B',raceTrack.getTrack()[8][2]);
        assertEquals('0',raceTrack.getTrack()[9][2]);
        assertEquals('1',raceTrack.getTrack()[8][1]);
    }

    @Test
    public void getPlayersTest() {
        assertEquals(4,raceTrack.getPlayers().size());
        assertEquals('B',raceTrack.getPlayers().get(0).getCategory());
        assertEquals("4B",raceTrack.getPlayers().get(3).getId());
    }

    @Test
    public void getFinishLineTest() {
        assertEquals(5,raceTrack.getFinishLine().getFirst());
        assertEquals(9,raceTrack.getFinishLine().get(1));
    }
}
