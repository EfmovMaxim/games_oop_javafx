package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionA1() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        Assert.assertThat(bb.position(), is(Cell.A1));
    }

    @Test
    public void copyA1toB2() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        Assert.assertThat(bb.copy(Cell.B2).position(), is(Cell.B2));
    }


    @Test
    public void wayC1toG5() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] rsl = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(Arrays.equals(bb.way(Cell.G5), rsl), is(true));
        //System.out.println(Arrays.toString(bb.way(Cell.A3)));  [B2, A3]
    }

    @Test
    public void wayC1toA3() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] rsl = new Cell[]{Cell.B2, Cell.A3};
        Assert.assertThat(Arrays.equals(bb.way(Cell.A3), rsl), is(true));
    }
}