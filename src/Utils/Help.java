
package Utils;

public class Help 
{
    private static String help_text = 
            "\n[Help:]" +
            "\n -h <parameter>: Hash in any supported format." +
            "\n -p <parameter>: Password or path to a wordlist file containing possible passwords separated by newline." +
            "\n";
    
    private static String hint_text = 
            "\nUse 'help' command to access help manual.\n";
    
    public static void printHelp()
    {
        System.out.print(help_text);
    }
    
    public static void printHint()
    {
        System.out.print(hint_text);
    }
}
