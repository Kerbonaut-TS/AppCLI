package it.hedgehog;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;


@Command(name = "AppCLI", mixinStandardHelpOptions = true, version = "AppCLI template 1.0", description = "An example of how to setup a command line interface")
public class AppCLI implements Runnable {

    // COMMAND 1 ===============================================================
    @Command(name = "command1", description = "Command 1 description")
    static class Command1 implements Runnable {
        @Parameters(index = "0", description = "Command 1 <string> will print a test message")
        private String param;

        public void run() {
            System.out.println("Executing Command 1 with parameter: " + param);
        }
    }
    
    // COMMAND 2 ===============================================================
    @Command(name = "command2", description = "Command 2 <string> will print a test message")
    static class Command2 implements Runnable {
        @Parameters(index = "0", description = "Parameter for command 2")
        private String param;

        public void run() {
            System.out.println("Executing Command 2 with parameter: " + param);
        }
    }

    public void run() {
    }

    public static void main(String[] args) {
        //enable all commands
        CommandLine commandLine = new CommandLine(new AppCLI());
        commandLine.addSubcommand("command1", new Command1());
        commandLine.addSubcommand("command2", new Command2());

        int exitCode = commandLine.execute(args);
        System.exit(exitCode);


    }
}