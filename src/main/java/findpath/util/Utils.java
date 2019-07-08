package findpath.util;

import findpath.main.Element;

import java.util.Collection;
import java.util.stream.Collectors;

public class Utils
{
    public static char[][] stringToCharArray(String mat)
    {
        String[] split = mat.split("\n");
        char[][] result = new char[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++)
        {
            result[i] = split[i].toCharArray();
        }
        return result;
    }

    public static boolean isValidStringMaze(String maze)
    {
        return maze != null && !maze.isEmpty() && maze.contains("S") && maze.contains("X") && maze.contains(".");
    }

    public static boolean isValidStringLine(String line, int mazeWidth)
    {
        return isValidStringFirstLine(line) && line.length() == mazeWidth;
    }

    public static boolean isValidStringFirstLine(String line)
    {
        return line != null && !line.isEmpty() && line.contains(".");
    }

    public static Element createUniqueField(char value, String mat, int xLength)
    {
        int idx = mat.replaceAll("\n", "").indexOf(value);
        int y = idx / xLength;
        int x = idx % xLength;
        return new Element(x, y);
    }

    public static boolean isValidField(char mat[][], boolean visited[][], int x, int y)
    {
        return (y >= 0) && (y < mat.length) && (x >= 0) && (x < mat[0].length)
                && mat[y][x] != Element.BLOCK && !visited[y][x];
    }

    public static String collectionToString(Collection<?> c)
    {
        String s = c.stream().map(Object::toString).collect(Collectors.joining(","));
        return String.format("[%s]", s);
    }

}
