package Main;

import Utils.Help;
import Utils.Statics;
import java.io.File;
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
    private int hash_iteration;
    private List<String> specified_algorithms;
    private boolean isHexFormat;
    
    public ArgumentsService(String[] args)
    {
        this.args = args;
        
        validate();
    }
    
    public void validate()
    {
        int status = OK;
        
        //  Check if there are args.
        if (this.args == null || this.args.length == 0)
            status = NO_ARGS;
        
        //  Check for help quotation
        if (this.args.length == 1 && this.args[0].equals(Statics.HELP_PARAMETER))
            Help.printHelp();
        else if (this.args.length == 0)
            Help.printHint();
        
        for (int i = 0; i < args.length; i++)
        {
            //  Check for hash input
            if (args[i].equals(Statics.HASH_PARAMETER) && i + 1 <= args.length)
                this.hash = args[i + 1];
            else
                status = NO_HASH_ARGUMENT;
            
            //  Check for password input
            if (args[i].equals(Statics.PASSWORD_PARAMETER) && i + 1 <= args.length)
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
            else
                status = NO_PASSWORD_ARGUMENT;   
        }
        
        if (status != OK)
            return;
        
        if (!passwordIsFile && !password.isEmpty() && !hash.isEmpty())
        {
            for (Algorithms a : Algorithms.getAlgorithms())
            {
                if (a.crypt(password).equals(hash))
                    System.out.println("[" + a.getName() + "] Password " + password + " matches hash " + hash);
                else
                    System.out.println("[" + a.getName() + "] NOT OK");
            }
        }
        else if (passwordIsFile && !password.isEmpty() && !hash.isEmpty())
        {
            for (Algorithms a : Algorithms.getAlgorithms())
            {
                //  Read from file
            }
        }

    }

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
