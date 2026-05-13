# Impact Diagnostic CLI

A Professional System Utility built for the Impact Team.

This project is a functional Java command-line interface. It uses Picocli for argument parsing and Maven for the build lifecycle.

## Quick Start

If you have Java 17+ installed, you can build and run this tool immediately.

1. **Build the Executable**
   Open your terminal in the project root, navigate to `impactCLI\demo` and run:
   ```bash
   mvn clean package
   ```

   This will download dependencies, compile the source, and bundle everything into a portable "Fat JAR" located in the `target` directory.

2. **Run the Tool**
   Use the following command to see the tool in action with the "fancy" branding and "system status" features enabled:
   ```bash
   java -jar target/impactCLI-1.0-SNAPSHOT.jar -f -s
   ```

## Features

- **System Health Diagnostics**: Uses the `-s` or `--status` flag to pull real-time Disk and JVM Memory stats from the host machine.
- **Fancy Header**: Use the `-f` or `--fancy` flag to display professional ASCII branding.
- **Self-Documenting CLI**: Built-in help menus are automatically generated and accessible via the `--help` flag.
- **Shaded Distribution**: Uses the Maven Shade Plugin to bundle all dependencies into a single executable file, eliminating classpath issues.

## Tech Stack

- **Language**: Java 17 (JDK 21 compatible)
- **Build Tool**: Maven
- **CLI Framework**: Picocli
- **Distribution**: Maven Shade Plugin
