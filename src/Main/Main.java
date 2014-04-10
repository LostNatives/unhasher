
package Main;

public class Main 
{
    public static void main(String[] args) 
    {
        //  Initialize algorithms
        Algorithms.initialize();
        
        //  Start console service
        ArgumentsService as = new ArgumentsService(args);
        
    }
}
