package Main;

<<<<<<< HEAD
import Utils.FileStreamer;
import Utils.Help;
import Utils.Statics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
=======
import Utils.Help;
import Utils.Statics;
import java.io.File;
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
import java.util.List;

public class ArgumentsService 
{
    //  Codes
    public static int OK = 1;
    public static int NO_SUFFICIENT_ARGUMENTS = 2;
    public static int NO_ARGS = 3;
    public static int NO_HASH_ARGUMENT = 4;
    public static int NO_PASSWORD_ARGUMENT = 5;
    
    //  Arguments from command line
    private String[] args;
    
    //  Required fields
    private String hash;
    private String password;
    
    //  Optional fields
    private boolean passwordIsFile;
    private List<String> salts;
<<<<<<< HEAD
    private int hash_iteration = 1;
    private List<String> specified_algorithms;
    private boolean isHexFormat;
    
    public ArgumentsService(String[] args) throws 
            FileNotFoundException, 
            IOException
=======
    private int hash_iteration;
    private List<String> specified_algorithms;
    private boolean isHexFormat;
    
    public ArgumentsService(String[] args)
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
    {
        this.args = args;
        
        validate();
    }
    
<<<<<<< HEAD
    public void validate() throws 
            FileNotFoundException, 
            IOException
=======
    public void validate()
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
    {
        int status = OK;
        
        //  Check if there are args.
        if (this.args == null || this.args.length == 0)
            status = NO_ARGS;
        
        //  Check for help quotation
        if (this.args.length == 1 && this.args[0].equals(Statics.HELP_PARAMETER))
<<<<<<< HEAD
        {
            Help.printHelp();
            return;
        }
        else if (this.args.length == 0)
        {
            Help.printHint();
            return;            
        }
            
=======
            Help.printHelp();
        else if (this.args.length == 0)
            Help.printHint();
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
        
        for (int i = 0; i < args.length; i++)
        {
            //  Check for hash input
            if (args[i].equals(Statics.HASH_PARAMETER) && i + 1 <= args.length)
<<<<<<< HEAD
            {
                this.hash = args[i + 1];
                continue;
            }
            
            //  Check for password input
            if (args[i].equals(Statics.PASSWORD_PARAMETER) && i + 1 <= args.length)
            {  
=======
                this.hash = args[i + 1];
            else
                status = NO_HASH_ARGUMENT;
            
            //  Check for password input
            if (args[i].equals(Statics.PASSWORD_PARAMETER) && i + 1 <= args.length)
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
                if (isFile(args[i + 1]))
                {
                    passwordIsFile = true;
                    password = args[i + 1];
                }
                else
                {
                    passwordIsFile = false;
                    password = args[i + 1];
                }
<<<<<<< HEAD
                continue;
            }  
            
            //  Check for iterations
            if (args[i].equals(Statics.ITERATIONS_PARAMETER) && i + 1 <= args.length)
            {
                this.hash_iteration = Integer.parseInt(args[i + 1]);
                
                continue;
            }
        }
        
        start();
    }

    public void start() throws 
            FileNotFoundException, 
            IOException
    {
                
=======
            else
                status = NO_PASSWORD_ARGUMENT;   
        }
        
        if (status != OK)
            return;
        
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
        if (!passwordIsFile && !password.isEmpty() && !hash.isEmpty())
        {
            for (Algorithms a : Algorithms.getAlgorithms())
            {
                if (a.crypt(password).equals(hash))
                    System.out.println("[" + a.getName() + "] Password " + password + " matches hash " + hash);
<<<<<<< HEAD
=======
                else
                    System.out.println("[" + a.getName() + "] NOT OK");
>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
            }
        }
        else if (passwordIsFile && !password.isEmpty() && !hash.isEmpty())
        {
<<<<<<< HEAD
            int processed_iterations = 0;
            
            for (Algorithms a : Algorithms.getAlgorithms())
            {
                System.out.println("Current algorithm: " + a.getName() + " ");
                
                FileStreamer fs = new FileStreamer(password);
                
                while (fs.hasNext())
                {
                    String h = a.crypt(fs.getNext());
                    
                    int i = 0;
                    while (i < this.hash_iteration)
                    {
                        if (h.equals(hash))
                        {
                            System.out.println("[" + a.getName() + "] Password '" + h + "' matches hash: " + hash + " iterations: " + i);
                        }
                        else                        
                            h = a.crypt(h);
                        
                        i++;
                    }
                }                
            }
            
            System.out.println("[DONE] Processed " + Algorithms.getProcessedIterations() + " different iterations.");
        }
    }
    
=======
            for (Algorithms a : Algorithms.getAlgorithms())
            {
                //  Read from file
            }
        }

    }

>>>>>>> 2d4292fcb1e8eacabdea66915b6720f0b4a81be9
    //  Additional functions
    private boolean isFile(String path)
    {
        File f = new File(path);
        
        if(f.exists() && !f.isDirectory())
            return true;
        else
            return false;
    }
}
