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

import java.util.Random;

public class botPlayer extends genericPlayer {
    /**
     * Bot player constructor
     * @param id identifier
     * @param category category
     * @param machine player's machine
     */
    public botPlayer(String id, char category, gameMachine machine) {
        super(id, category, machine);
    }

    @Override
    public Position move() {
        Random rand = new Random();
        if(getGameMachine().getLastPosition() == null) {
            return new positionFormulaUno(getGameMachine().getPosition().x(),
                    getGameMachine().getPosition().y() - 1);
        }
        return getGameMachine().possibleMoves().get(rand.nextInt(getGameMachine().possibleMoves().size()));
    }
}
