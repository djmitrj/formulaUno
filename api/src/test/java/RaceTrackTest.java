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
import it.unicam.cs.formulaUno.api.Player.*;
import it.unicam.cs.formulaUno.api.Position.*;
import it.unicam.cs.formulaUno.api.gameMachine.*;
import it.unicam.cs.formulaUno.api.raceTrack.raceTrack;
import it.unicam.cs.formulaUno.api.raceTrack.raceTrackFormulaUno;
import org.junit.jupiter.api.Test;

public class RaceTrackTest {

    private final FileIO<char[][]> fileIO = new FileIOFormulaUno("racetrack.txt");
    private final raceTrack<char[][]> raceTrack = new raceTrackFormulaUno(fileIO);

    public RaceTrackTest() throws FileReaderError {
    }

    @Test
    public void getTrackTest() {

    }
}