public class chgrp {
    public static final String PROGRAM_NAME = "chgrp" ;
    public static void main(String[] args) throws Exception {

        Kernel.initialize();
        if( args.length < 2 ) {
            System.err.println( PROGRAM_NAME + ": usage: java " + PROGRAM_NAME +
                    "new-gid path-name" ) ;
            Kernel.exit( 1 ) ;
        }

        short gid = Short.parseShort(args[0]);

        for(int i = 1 ;i < args.length;i++) {
            String name = args[i];
            int chown = Kernel.chown(name, -1, gid);
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
