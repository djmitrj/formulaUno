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

import it.unicam.cs.formulaUno.api.File.*;
import it.unicam.cs.formulaUno.api.Player.*;
import it.unicam.cs.formulaUno.api.Position.*;
import it.unicam.cs.formulaUno.api.gameMachine.*;
import it.unicam.cs.formulaUno.api.raceHandler.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaceHandlerTest {

    FileIO<char[][]> fileIO = new FileIOFormulaUno("racetrack.txt");
    raceHandler raceHandlerFormulaUno = new raceHandlerFormulaUno(fileIO);

    public RaceHandlerTest() throws FileReaderError {
    }
    
    @Test
    public void updatePlayerPositionTest() {
        char[][] track = raceHandlerFormulaUno.getRacetrack();
        Player player = new botPlayer("1B",'B',
                new gameMachineFormulaUno(new positionFormulaUno(3,3)));
        raceHandlerFormulaUno.getPlayers().add(player);
        raceHandlerFormulaUno.updatePlayerPosition(player, new positionFormulaUno(3,4));
        assertEquals('B', track[4][3]);
    }

    @Test
    public void removePlayerTest() {
        raceHandlerFormulaUno.removePlayer(raceHandlerFormulaUno.getPlayers().getFirst());
        assertEquals(3, raceHandlerFormulaUno.getPlayers().size());
    }

    @Test
    public void checkPositionTest() {
        boolean check = raceHandlerFormulaUno.checkPosition(new positionFormulaUno(0,0));
        assertTrue(check);
        boolean check1 = raceHandlerFormulaUno.checkPosition(new positionFormulaUno(2,7));
        assertFalse(check1);
    }

   @Test
   public void checkFalseMoveTest() {
        boolean check = raceHandlerFormulaUno.checkFalseMove(new positionFormulaUno(2,5),
                new positionFormulaUno(2,11));
        assertTrue(check);
        boolean check1 = raceHandlerFormulaUno.checkFalseMove(new positionFormulaUno(2,5),
                new positionFormulaUno(2,4));
        assertFalse(check1);
   }
}
