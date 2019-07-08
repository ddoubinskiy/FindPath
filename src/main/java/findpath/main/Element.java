package findpath.main;

import java.util.ArrayDeque;
import java.util.Queue;

public class Element
{
    public static final char START = 'S';
    public static final char TARGET = 'X';
    public static final char BLOCK = '#';

    private final int x;
    private final int y;
    private final Queue<String> moves;

    public Element(int x, int y, Queue<String> moves)
    {
        this.x = x;
        this.y = y;
        this.moves = moves;
    }

    public Element(int x, int y)
    {
        this.x = x;
        this.y = y;
        moves = new ArrayDeque<>();
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Queue<String> getMoves()
    {
        return moves;
    }

}
