package findpath.input.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileMazeReader extends AbstractMazeInputReader
{
    private final String pathToFile;

    public FileMazeReader(String pathToFile)
    {
        this.pathToFile = pathToFile;
    }

    @Override
    public String readFully() throws IOException
    {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile)))
        {
            while (reader.ready())
            {
                builder.append(reader.readLine()).append('\n');
            }
        }
        return builder.toString();
    }


}
