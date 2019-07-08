package findpath.input.readers;

import java.io.IOException;

public abstract class AbstractMazeInputReader
{
    public abstract String readFully() throws IOException;
}
