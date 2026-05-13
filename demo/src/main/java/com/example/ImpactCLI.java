package com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

@Command(name = "impact", mixinStandardHelpOptions = true, version = "1.0",
        description = "A personalized CLI for the Impact team.")
public class ImpactCLI implements Callable<Integer> {

    @Option(names = {"-f", "--fancy"}, description = "Use fancy formatting")
    private boolean fancy;

    @Override
    public Integer call() throws Exception {
        if (fancy) {
            System.out.println("===============================");
            System.out.println("       IMPACT CLI TOOL        ");
            System.out.println("===============================");
        } else {
            System.out.println("Impact CLI: Welcome to the team.");
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ImpactCLI()).execute(args);
        System.exit(exitCode);
    }
}
