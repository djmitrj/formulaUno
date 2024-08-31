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

import it.unicam.cs.formulaUno.api.fileParser.*;
import it.unicam.cs.formulaUno.api.Player.*;
import it.unicam.cs.formulaUno.api.Position.*;
import it.unicam.cs.formulaUno.api.gameMachine.*;
import it.unicam.cs.formulaUno.api.raceHandler.*;
import it.unicam.cs.formulaUno.api.raceTrack.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class test of raceHandler
 */
public class RaceHandlerTest {

    private final fileParser<char[][]> fileParserFormulaUno = new fileParserFormulaUno("racetrack.txt");
    private final raceTrack<char[][]> raceTrack = new raceTrackFormulaUno(fileParserFormulaUno);
    private final raceHandler<char[][]> raceHandlerFormulaUno = new raceHandlerFormulaUno();

    public RaceHandlerTest() throws FileReaderError {
    }
    
    @Test
    public void updatePlayerPositionTest() {
        char[][] track = raceTrack.getTrack();
        Player player = new botPlayer("1B",'B',
                new gameMachineFormulaUno(new positionFormulaUno(3,3)));
        raceTrack.getPlayers().add(player);
        raceHandlerFormulaUno.updatePlayerPosition(raceTrack,player, new positionFormulaUno(3,4));
        assertEquals('B', track[4][3]);
    }

    @Test
    public void removePlayerTest() {
        raceHandlerFormulaUno.removePlayer(raceTrack, raceTrack.getPlayers().getFirst());
        assertEquals(3, raceTrack.getPlayers().size());
    }

    @Test
    public void checkPositionTest() {
        boolean check = raceHandlerFormulaUno.checkPosition(raceTrack, new positionFormulaUno(0,0));
        assertTrue(check);
        boolean check1 = raceHandlerFormulaUno.checkPosition(raceTrack, new positionFormulaUno(2,7));
        assertFalse(check1);
    }

   @Test
   public void checkFalseMoveTest() {
        boolean check = raceHandlerFormulaUno.checkFalseMove(raceTrack, new positionFormulaUno(2,5),
                new positionFormulaUno(2,11));
        assertTrue(check);
        boolean check1 = raceHandlerFormulaUno.checkFalseMove(raceTrack, new positionFormulaUno(2,5),
                new positionFormulaUno(2,4));
        assertFalse(check1);
   }
}
