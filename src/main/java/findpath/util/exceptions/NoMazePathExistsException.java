package findpath.util.exceptions;

public class NoMazePathExistsException extends Exception
{
    public NoMazePathExistsException()
    {
        super("Path in maze does not exist!");
    }
}
