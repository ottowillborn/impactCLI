package com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "impact", mixinStandardHelpOptions = true, version = "1.0",
        description = "Impact Professional Diagnostic Tool.")
public class ImpactCLI implements Callable<Integer> {

    @Option(names = {"-f", "--fancy"}, description = "Display the fancy header.")
    private boolean fancy;

    @Option(names = {"-s", "--status"}, description = "Check local system health (Disk & Memory).")
    private boolean status;

    @Override
    public Integer call() throws Exception {
        if (fancy) {
            System.out.println("                                                       ");
            System.out.println("  ██╗ ███╗   ███╗ ██████╗   █████╗   ██████╗████████╗  ");
            System.out.println("  ██║ ████╗ ████║ ██╔══██╗ ██╔══██╗ ██╔════╝╚══██╔══╝  ");
            System.out.println("  ██║ ██╔████╔██║ ██████╔╝ ███████║ ██║        ██║     ");
            System.out.println("  ██║ ██║╚██╔╝██║ ██╔═══╝  ██╔══██║ ██║        ██║     ");
            System.out.println("  ██║ ██║ ╚═╝ ██║ ██║      ██║  ██║ ╚██████╗   ██║     ");
            System.out.println("  ╚═╝ ╚═╝     ╚═╝ ╚═╝      ╚═╝  ╚═╝  ╚═════╝   ╚═╝     ");
            System.out.println("                 COMMAND LINE INTERFACE                ");  
        } else if (!fancy) {
            System.out.println("===============================");
            System.out.println("       IMPACT CLI TOOL        ");
            System.out.println("===============================");
        }

        if (status) {
            checkSystemHealth();
        } 

        return 0;
    }

    private void checkSystemHealth() {
        File root = new File("C:");
        long totalSpace = root.getTotalSpace() / (1024 * 1024 * 1024);
        long freeSpace = root.getFreeSpace() / (1024 * 1024 * 1024);
        long usedSpace = totalSpace - freeSpace;

        System.out.println("\n--- [ SYSTEM HEALTH ] ---");
        System.out.printf("Storage (C:): %d GB / %d GB used%n", usedSpace, totalSpace);
        
        long maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        System.out.printf("JVM Memory:   %d MB allocated%n", maxMemory);
        
        if (freeSpace < 10) {
            System.out.println("Warning: Low disk space!");
        } else {
            System.out.println("Status: All systems operational.");
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ImpactCLI()).execute(args);
        System.exit(exitCode);
    }
}