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

package it.unicam.cs.formulaUno.api.Player;

import it.unicam.cs.formulaUno.api.gameMachine.*;

public abstract class genericPlayer implements Player {

    private final String id;
    private final char category;
    private final gameMachine machine;

    /**
     * Constructor of a generic player of Formula Uno
     * @param id identifier
     * @param category category
     * @param machine player's machine
     * @throws IllegalArgumentException if the parameters are invalid
     */
    public genericPlayer(String id, char category, gameMachine machine) {
        if(id == null || category != 'B' || machine == null) {
            throw new IllegalArgumentException("The parameters are invalid");
        }
        this.id = id;
        this.category = category;
        this.machine = machine;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public char getCategory() {
        return this.category;
    }

    @Override
    public gameMachine getGameMachine() {
        return this.machine;
    }
}
