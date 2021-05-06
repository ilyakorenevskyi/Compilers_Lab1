public class umask {
    public static final String PROGRAM_NAME = "umask" ;
    public static void main(String[] args) throws Exception {
        Kernel.initialize();
        if( args.length < 1) {
            System.err.println( PROGRAM_NAME + ": usage: java " + PROGRAM_NAME +
                    " new-mask" ) ;
            Kernel.exit( 1 ) ;
        }
        int umask = Kernel.umask(Short.parseShort(args[0]));
        System.err.println( PROGRAM_NAME + ": return old umask " + umask ) ;
    }
}
