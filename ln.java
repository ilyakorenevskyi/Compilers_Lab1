public class ln {

    /**
     * The name of this program.
     * This is the program name that is used
     * when displaying error messages.
     */
    public static String PROGRAM_NAME = "ln" ;

    public static void main(String[] args) throws Exception {
        Kernel.initialize();
        if( args.length < 2 )
        {
            System.err.println( PROGRAM_NAME + ": too few arguments" ) ;
            Kernel.exit( 1 ) ;
        }
        String path1 = args[0] ;
        String path2 = args[1] ;
        Kernel.link(path1,path2);
        Kernel.exit( 0 ) ;
    }
}
