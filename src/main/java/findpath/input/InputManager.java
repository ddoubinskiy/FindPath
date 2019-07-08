package findpath.input;

import findpath.input.readers.FileMazeReader;
import findpath.input.readers.SystemInMazeReader;
import findpath.util.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputManager
{

    public static final String EXIT = "Exit";
    private static final String MAZE_TYPING_DONE = "Done";

    public String processInput()
    {
        System.out.println("This app allows you to find a path from start position to target position in any given maze based on next rules:\n" +
                "1. maze is rectangular 2d grid of maze elements\n" +
                "2. maze element is free '.' or blocked '#'\n" +
                "3. maze contains one start position marker 'S'\n" +
                "4. maze contains target position 'X'");

        System.out.println("\nIf you like to exit the app - type \"Exit\"");

        System.out.println("Please, choose your input type (F - read from file; C - read from console):");
        boolean modeSelected = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            while (!modeSelected)
            {
                String mode = reader.readLine();
                if (mode.equalsIgnoreCase(EXIT))
                {
                    return EXIT;
                }
                String result = "";
                if (mode.equalsIgnoreCase("f"))
                {
                    modeSelected = true;
                    result = getValidatedStringMazeFromFile(reader);
                } else if (mode.equalsIgnoreCase("c"))
                {
                    modeSelected = true;
                    result = getValidatedStringMazeFromConsole(reader);
                } else
                {
                    System.out.println("Incorrect input type. Please, choose your input type (F - read from file; C - read from console):");
                    modeSelected = false;
                }

                if (!result.isEmpty())
                {
                    if (result.equalsIgnoreCase(EXIT))
                    {
                        return EXIT;
                    } else
                    {
                        return result;
                    }
                }

            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return EXIT;
    }

    private String getValidatedStringMazeFromFile(BufferedReader reader) throws IOException
    {
        System.out.println("Please, enter a path to file:");
        String input = reader.readLine();
        while (!input.equalsIgnoreCase(EXIT))
        {
            if (!Files.exists(Paths.get(input)))
            {
                System.out.println("Please, enter a valid and existing path to file:");
                input = reader.readLine();
            } else
            {
                FileMazeReader fileReader = new FileMazeReader(input);
                String maze = fileReader.readFully();
                if (!Utils.isValidStringMaze(maze))
                {
                    System.out.println("File does not match the requirements. Please, try another file:");
                    input = reader.readLine();
                } else
                {
                    return maze;
                }
            }
        }
        return EXIT;
    }

    private String getValidatedStringMazeFromConsole(BufferedReader reader) throws IOException
    {
        System.out.println("Please, start typing a maze field in the console. When done, type \"Done\" on a new line.");
        String input = reader.readLine();
        SystemInMazeReader mazeReader = new SystemInMazeReader();
        boolean valid;
        while (!input.equalsIgnoreCase(EXIT))
        {
            if (mazeReader.isEmpty())
            {
                if (input.equalsIgnoreCase(MAZE_TYPING_DONE))
                {
                    System.out.println("No lines were typed. Please, try again:");
                    input = reader.readLine();
                    continue;
                }
                valid = Utils.isValidStringFirstLine(input);
            } else
            {
                valid = Utils.isValidStringLine(input, mazeReader.getInputWidth());
            }
            if (valid)
            {
                mazeReader.addLine(input);
            } else
            {
                if (input.equalsIgnoreCase(MAZE_TYPING_DONE))
                {
                    return mazeReader.readFully();
                }
                System.out.println("Line does not match the requirements. Please, try typing another line:");
            }
            input = reader.readLine();
        }
        return EXIT;
    }

}
