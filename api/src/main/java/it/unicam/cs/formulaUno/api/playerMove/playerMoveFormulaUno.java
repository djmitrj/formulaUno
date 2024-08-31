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

package it.unicam.cs.formulaUno.api.playerMove;

import it.unicam.cs.formulaUno.api.Player.Player;
import it.unicam.cs.formulaUno.api.Player.botPlayer;
import it.unicam.cs.formulaUno.api.Position.Position;
import it.unicam.cs.formulaUno.api.Position.positionFormulaUno;

import java.util.Random;

/**
 * Class that manages the player's move
 */
public class playerMoveFormulaUno implements playerMove{

    @Override
    public Position move(Player player) {
        if(player == null) throw new NullPointerException("The passed player is null");
        if(player instanceof botPlayer) {
            Random rand = new Random();
            if(player.getGameMachine().getLastPosition() == null) {
                return new positionFormulaUno(player.getGameMachine().getPosition().x(),
                        player.getGameMachine().getPosition().y() - 1);
            }
            return player.getGameMachine().possibleMoves().get(rand.nextInt(player.getGameMachine().possibleMoves().size()));
        }
        return null;
    }
}
