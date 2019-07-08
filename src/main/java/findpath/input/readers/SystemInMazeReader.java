package findpath.input.readers;

import java.io.IOException;

public class SystemInMazeReader extends AbstractMazeInputReader
{
    private final StringBuilder result = new StringBuilder();
    private int inputWidth;

    @Override
    public String readFully() throws IOException
    {
        return result.toString();
    }

    public void addLine(String line)
    {
        if (isEmpty())
        {
            inputWidth = line.length();
        }
        result.append(line).append('\n');
    }

    public boolean isEmpty()
    {
        return result.length() == 0;
    }

    public int getInputWidth()
    {
        return inputWidth;
    }
}
