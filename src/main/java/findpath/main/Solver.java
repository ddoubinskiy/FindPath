package findpath.main;

import findpath.util.Utils;
import findpath.util.exceptions.NoMazePathExistsException;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solver
{
    private final String maze;

    public Solver(String maze)
    {
        this.maze = maze;
    }

    public Queue<String> solve() throws NoMazePathExistsException
    {
        char[][] charMat = Utils.stringToCharArray(maze);
        int xLength = charMat[0].length;
        int yLength = charMat.length;
        boolean[][] visited = new boolean[yLength][xLength];
        int yPossibleMoves[] = {-1, 0, 0, 1};
        int xPossibleMoves[] = {0, -1, 1, 0};
        String[] directions = new String[]{"u", "l", "r", "d"};

        Queue<Element> q = new ArrayDeque<>();
        Element startField = Utils.createUniqueField(Element.START, maze, xLength);
        q.add(startField);
        visited[startField.getY()][startField.getX()] = true;
        int x;
        int y;
        Element targetField = Utils.createUniqueField(Element.TARGET, maze, xLength);

        while (!q.isEmpty())
        {
            Element field = q.poll();
            x = field.getX();
            y = field.getY();

            Queue<String> moves = field.getMoves();
            if (x == targetField.getX() && y == targetField.getY())
            {
                return moves;
            }

            for (int k = 0; k < 4; k++)
            {
                int xNext = x + xPossibleMoves[k];
                int yNext = y + yPossibleMoves[k];
                if (Utils.isValidField(charMat, visited, xNext, yNext))
                {
                    visited[yNext][xNext] = true;
                    Queue<String> newMoves = new ArrayDeque<>(moves);
                    newMoves.add(directions[k]);
                    q.add(new Element(xNext, yNext, newMoves));
                }
            }
        }
        throw new NoMazePathExistsException();
    }
}
