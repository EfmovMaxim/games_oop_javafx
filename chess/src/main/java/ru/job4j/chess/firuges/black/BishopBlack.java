package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {

        if (!isDiagonal(position(), dest)) {
            throw new ImpossibleMoveException(String.format("Could not way by diagonal from %s to %s", position, dest));
        }

        int deltaX = dest.getX() - position().getX();
        int deltaY = dest.getY() - position().getY();

        int kx = 1;
        int ky = 1;

        if (deltaX < 0) {
            kx = -1;
        }

        if (deltaY < 0) {
            ky = -1;
        }

        Cell[] way = new Cell[Math.abs(deltaX)];

        int ix = 0;
        int iy = 0;

        while (deltaX != ix * kx) {
            ++ix;
            ++iy;
            way[Math.abs(ix) - 1] = Cell.findBy(position().getX() + ix * kx, position.getY() + iy * ky);
        }

        return way;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public static void main(String[] args) {
        BishopBlack bb = new BishopBlack(Cell.C1);
        System.out.println(Arrays.toString(bb.way(Cell.G5)));
        System.out.println(Arrays.toString(bb.way(Cell.A3)));
    }
}
