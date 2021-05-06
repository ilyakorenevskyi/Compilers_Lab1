public class chmod {
    public static final String PROGRAM_NAME = "chmod" ;
    public static void main(String[] args) throws Exception {
        Kernel.initialize();
        if( args.length < 2 ) {
            System.err.println( PROGRAM_NAME + ": usage: java " + PROGRAM_NAME +
                    "new-mode path-name" ) ;
            Kernel.exit( 1 ) ;
        }
        short mod = Short.parseShort(args[0]);
        for(int i = 1 ;i < args.length;i++) {
            String name = args[i];
            int chmod = Kernel.chmod( args[0], mod);
            if (chmod < 0) {
                Kernel.perror(PROGRAM_NAME);
                System.err.println(PROGRAM_NAME + ": unable to change \"" +
                        name + "\"");
                Kernel.exit(2);
            }
        }
        Kernel.exit(0);
    }
}
