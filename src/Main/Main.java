
package Main;

<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main 
{

    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        //  Initialize algorithms
        Algorithms.initialize();

        String[] bla = {"-h", "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", "-p", "passwords.txt", "-i", "5"};
        
        //  Start console service
        ArgumentsService as = new ArgumentsService(bla);
=======
public class Main 
{
    public static void main(String[] args) 
    {
        //  Initialize algorithms
        Algorithms.initialize();
        
        //  Start console service
        ArgumentsService as = new ArgumentsService(args);
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
        
    }
}
