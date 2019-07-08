package findpath;

import java.util.ArrayDeque;
import java.util.Queue;

public class InputTestData
{
    public static final String MAZE_10_STEPS =
            "....................................\n" +
                    "..S...#.........#.............#.....\n" +
                    "....#..#.....................#......\n" +
                    "........#...........#.........#.....\n" +
                    "....................................\n" +
                    "........X...........................\n" +
                    "..............#.....................\n" +
                    "............#.......................";

    public static final String MAZE_25_STEPS =
            "......................#.......#.....\n" +
                    "......#.........#.....#.......#.....\n" +
                    "....#..#..............#......#......\n" +
                    "......X.#...........#####.######....\n" +
                    "....................................\n" +
                    "....................................\n" +
                    "..............#.....................\n" +
                    "............#..............S........";

    public static final String LINEAR_MAZE =
            "#.S........................X..#...#.";

    public static final String NO_SOLVE_MAZE =
            "....................................\n" +
                    "..S..##.........#.............#.....\n" +
                    "....#..#.....................#......\n" +
                    "...#....#...........#.........#.....\n" +
                    ".#.#.....##.........................\n" +
                    "...#....X.#.........................\n" +
                    "...#.......##.#.....................\n" +
                    "...#........#.......................";

    public static Queue<String> get10StepsMazeSolvedDirections()
    {
        Queue<String> steps = new ArrayDeque<>();
        for (int i = 0; i < 3; i++)
        {
            steps.add("r");
        }

        for (int i = 0; i < 3; i++)
        {
            steps.add("d");
            steps.add("r");
        }
        steps.add("d");
        return steps;
    }

    public static Queue<String> getLinearSolvedSteps()
    {
        Queue<String> steps = new ArrayDeque<>();
        for (int i = 0; i < 25; i++)
        {
            steps.add("r");
        }
        return steps;
    }
}