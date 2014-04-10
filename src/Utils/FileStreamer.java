
package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileStreamer 
{
    private String path;
    private BufferedReader in;
    
    public FileStreamer(String path) throws FileNotFoundException
    {
        this.path = path;
        
        in = new BufferedReader(new FileReader(path));
    }
    
    public boolean hasNext() throws IOException
    {
        return this.in.ready();
    }

    public String getNext() throws IOException
    {
        if (this.hasNext())
            return this.in.readLine();
        else
            in.close();
        
        return "";
    }
}
