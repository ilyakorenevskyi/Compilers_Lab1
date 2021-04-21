
public class find {

    public static String PROGRAM_NAME = "find" ;



    public static void main(String[] args) throws Exception {
        Kernel.initialize();
        for( int i = 0 ; i < args.length ; i ++ ) {
            String name = args[i];
            recFind(name);
        }
    }
    private static void recFind(String path) throws Exception {
        int status;
        Stat stat = new Stat();
        status = Kernel.stat(path, stat);
        if (status < 0) {
            return;
        }

        System.out.println(path);
        short type = (short) (stat.getMode() & Kernel.S_IFMT);

        if (type == Kernel.S_IFDIR) {

            int fd = Kernel.open(path, Kernel.O_RDONLY);

            if (fd < 0) {
                Kernel.perror(PROGRAM_NAME);
                System.err.println(PROGRAM_NAME +
                        ": unable to open \"" + path + "\" for reading");
                Kernel.exit(1);
            }

            DirectoryEntry directoryEntry = new DirectoryEntry();

            while (true) {
                status = Kernel.readdir(fd, directoryEntry);
                if (status <= 0)
                    break;

                String entryName = directoryEntry.getName();

                status = Kernel.stat(path + "/" + entryName, stat);
                if (status < 0) {
                    Kernel.perror(PROGRAM_NAME);
                    Kernel.exit(1);
                }

                if(!entryName.equals(".") && !entryName.equals("..")) {
                    recFind(path + "/" + entryName);
                }

            }
        }
    }
}
