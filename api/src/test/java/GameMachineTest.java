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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GameMachineTest {

    gameMachine gameMachine = new gameMachineFormulaUno(new positionFormulaUno(1,2));

    @Test
    public void testGameMachineGetPosition() {
        assertNull(gameMachine.getLastPosition());
        assertEquals(1,gameMachine.getPosition().x());
        assertEquals(2,gameMachine.getPosition().y());
    }

    @Test
    public void testGameMachineSetPositions() {
        gameMachine.setLastPosition(gameMachine.getPosition());
        gameMachine.setPosition(new positionFormulaUno(3,4));
        assertEquals(1,gameMachine.getLastPosition().x());
        assertEquals(2,gameMachine.getLastPosition().y());
        assertEquals(3,gameMachine.getPosition().x());
        assertEquals(4,gameMachine.getPosition().y());
    }

    @Test
    public void nextPositionGameMachineTest() {
        gameMachine.setLastPosition(new positionFormulaUno(1,2));
        gameMachine.setPosition(new positionFormulaUno(3,4));
        assertEquals(new positionFormulaUno(5,6),gameMachine.getNextPosition());
    }

    @Test
    public void possibleMovesTest() {
        gameMachine.setLastPosition(new positionFormulaUno(1,2));
        gameMachine.setPosition(new positionFormulaUno(3,4));
        assertEquals(9,gameMachine.possibleMoves().size());
    }
}
