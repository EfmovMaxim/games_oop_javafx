package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Ignore
    @Test
    public void moveBishopBlackC1toH6()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void moveBishopBlackD4toH8() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bb1 = new BishopBlack(Cell.D4);
        logic.add(bb1);
        BishopBlack bb2 = new BishopBlack(Cell.F6);
        logic.add(bb2);

        logic.move(Cell.D4, Cell.H8);
    }

    @Test(expected = FigureNotFoundException.class)
    public void moveWithoutFigure() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bb1 = new BishopBlack(Cell.D4);
        logic.add(bb1);
        BishopBlack bb2 = new BishopBlack(Cell.F6);
        logic.add(bb2);

        logic.move(Cell.C1, Cell.H8);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void moveBishopBlackImpossibleMove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bb1 = new BishopBlack(Cell.D4);
        logic.add(bb1);
        BishopBlack bb2 = new BishopBlack(Cell.F6);
        logic.add(bb2);

        logic.move(Cell.D4, Cell.D8);
    }



}