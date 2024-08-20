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

import java.util.List;

public class ConsoleIOFormulaUno implements ConsoleIO{

    @Override
    public <T> void printTrack(T racetrack) {
        char[][] trackFormulaUno = (char[][]) racetrack;
        for (char[] chars : trackFormulaUno) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    @Override
    public void printPlayers(List<Player> players) {
        for(Player p : players) {
            System.out.println("Id: "+p.getId()
                    +", Category: "+p.getCategory()
                    +", Position: ("+p.getGameMachine().getPosition().x()+", "
                    +p.getGameMachine().getPosition().y()+")");
        }
    }

    @Override
    public void messageVictory(Player player) {
        System.out.println("Race over, player wins: " + player.getId());
    }

    @Override
    public void messageStart() {
        System.out.println("Start of the race");
    }

    @Override
    public void playerTurn(Player player) {
        System.out.println("Player of duty: "+player.getId());
    }

    @Override
    public void errorMove(Player player) {
        System.out.println("Invalid move by the Player: "+player.getId());
    }

    @Override
    public void messageFinish() {
        System.out.println("All the players went off the track, race over");
    }
}
