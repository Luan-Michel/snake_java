/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luan
 */
public class Cobra {
    public int x;
    public int y;

    public Cobra(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Cobra novo = (Cobra)obj;
        if(novo.x == this.x && novo.y == this.y)
            return true;
        return false;
    }

}
