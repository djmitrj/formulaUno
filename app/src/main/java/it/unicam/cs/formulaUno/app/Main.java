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

package it.unicam.cs.formulaUno.app;

import it.unicam.cs.formulaUno.api.Console.*;
import it.unicam.cs.formulaUno.api.raceTrackParser.*;
import it.unicam.cs.formulaUno.api.gameEngine.*;
import it.unicam.cs.formulaUno.api.playerMove.*;
import it.unicam.cs.formulaUno.api.raceHandler.*;
import it.unicam.cs.formulaUno.api.raceTrack.*;

public class Main {
    public static void main(String[] args) throws FileReaderError {
        raceTrackParser<char[][]> rtParserFormulaUno = new raceTrackParserFormulaUno("racetrack.txt");
        Console<char[][]> console = new ConsoleFormulaUno();
        raceTrack<char[][]> raceTrack = new raceTrackFormulaUno(rtParserFormulaUno);
        raceHandler<char[][]> rhFormulaUno = new raceHandlerFormulaUno();
        playerMove pmFormulaUno = new playerMoveFormulaUno();
        gameEngine geFormulaUno = new gameEngineFormulaUno(rhFormulaUno, raceTrack,
                console, pmFormulaUno);
        geFormulaUno.start();
    }
}
