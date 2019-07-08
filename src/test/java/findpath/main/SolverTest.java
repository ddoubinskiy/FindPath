package findpath.main;

import findpath.util.exceptions.NoMazePathExistsException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Queue;

import static findpath.InputTestData.*;

public class SolverTest
{
    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSolve10Steps() throws Exception
    {
        Solver solver = new Solver(MAZE_10_STEPS);
        Queue<String> steps = solver.solve();
        Assert.assertEquals(10, steps.size());
    }

    @Test
    public void testSolve10StepsDirections() throws Exception
    {
        Solver solver = new Solver(MAZE_10_STEPS);
        Queue<String> steps = solver.solve();
        String[] stepsArray = steps.toArray(new String[]{});
        Assert.assertArrayEquals(stepsArray, get10StepsMazeSolvedDirections().toArray(new String[]{}));
    }

    @Test
    public void testSolve25Steps() throws Exception
    {
        Solver solver = new Solver(MAZE_25_STEPS);
        Queue<String> steps = solver.solve();
        Assert.assertEquals(25, steps.size());
    }

    @Test
    public void testSolveLinearMaze() throws Exception
    {
        Solver solver = new Solver(LINEAR_MAZE);
        Queue<String> steps = solver.solve();
        String[] stepsArray = steps.toArray(new String[]{});
        Assert.assertArrayEquals(stepsArray, getLinearSolvedSteps().toArray(new String[]{}));
    }

    @Test
    public void testNoSolveMaze() throws Exception
    {
        exceptionRule.expect(NoMazePathExistsException.class);
        exceptionRule.expectMessage("Path in maze does not exist!");
        Solver solver = new Solver(NO_SOLVE_MAZE);
        solver.solve();
    }

}