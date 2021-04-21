public class chown {
    public static final String PROGRAM_NAME = "chown" ;
    public static void main(String[] args) throws Exception {

        Kernel.initialize();
        if( args.length < 2 ) {
            System.err.println( PROGRAM_NAME + ": usage: java " + PROGRAM_NAME +
                    "new-uid path-name" ) ;
            Kernel.exit( 1 ) ;
        }

        short uid = Short.parseShort(args[0]);

        for(int i = 1 ;i < args.length;i++) {
            String name = args[i];
            int chown = Kernel.chown(name, uid, -1);
            if (chown < 0) {
                Kernel.perror(PROGRAM_NAME);
                System.err.println(PROGRAM_NAME + ": unable to change \"" +
                        name + "\"");
                Kernel.exit(2);
            }
        }
        Kernel.exit(0);
    }
}
