//: com.tecsys.itopia.shell.command.SSHLoggingCommand.java

package com.tecsys.itopia.shell.command;


import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;


/*
 * java -jar target/itopia-shell-lab-0.0.1-SNAPSHOT.jar
 *
 * The annotation @ShellComponent tells Spring Shell that an annotated class
 * may contain shell methods, which are annotated with @ShellMethod
 */
@Slf4j
@ShellComponent
final class SSHLoggingCommand {

    private boolean loggedIn;

    private String username;

    @ShellMethod(key = "login", value = "Sign in")
    public void login(
            @ShellOption(value = "-u", defaultValue = "tecuser")
            String username) {

        this.loggedIn = true;
        this.username = username;
        log.info(">>> Logged {} in.", username);
    }

    @ShellMethod(key = "logout", value = "Sign out")
    public void logout() {
        this.loggedIn = false;
        log.info(">>> Logged {} out.", username);
        this.username = null;
    }

    @ShellMethod(key = "cpw", value = "Change password")
    public void changePassword() {
        log.info(">>> Changed password of {}", this.username);
    }

    @ShellMethodAvailability({"logout", "cpw"})
    public Availability logoutAvailabilityCheck() {
        return loggedIn ? Availability.available() :
                Availability.unavailable(">>> Must be logged in first!");
    }
}///:~