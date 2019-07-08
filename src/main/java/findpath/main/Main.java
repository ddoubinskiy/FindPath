package findpath.main;

import findpath.input.InputManager;
import findpath.util.Utils;
import findpath.util.exceptions.NoMazePathExistsException;

import java.util.Queue;

import static findpath.input.InputManager.EXIT;

public class Main
{

    public static void main(String[] args) throws NoMazePathExistsException
    {
        InputManager inputManager = new InputManager();
        String maze = inputManager.processInput();
        if (maze.equalsIgnoreCase(EXIT))
        {
            System.out.println("Exiting...");
            return;
        }
        Solver solver = new Solver(maze);
        Queue<String> solution = solver.solve();
        System.out.println("\nSolution: " + Utils.collectionToString(solution));
        System.out.println("Total number of steps: " + solution.size());
    }


}


