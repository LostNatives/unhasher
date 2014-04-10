package Utils;

import java.util.ArrayList;
import java.util.List;

public class Mutation
{
    /*
        Mutation list
        
        hash(pass)
        hash(pass.salt)
        hash(salt.pass)
        hash(salt1.pass.salt2)
        hash(salt2.pass.salt1)
        hash(salt2.salt1.pass)
        hash(salt1.salt2.pass)
        hash(pass.salt1.salt2)
        hash(pass.salt2.salt1)
     */
    
    //  List of all mutations
    private static List<Mutation> mutations;
    
    //  Mutation attributes
    private List<String> mutators;
    
    //  Constructor
    public Mutation(String[] args)
    {
        mutators = new ArrayList<String>();
    }

    public List<String> getMutators()
    {
        return this.mutators;
    }
            
}
