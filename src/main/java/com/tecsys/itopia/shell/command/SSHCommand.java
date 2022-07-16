//: com.tecsys.itopia.shell.command.SSHCommand.java

package com.tecsys.itopia.shell.command;


import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.validation.constraints.Size;


/*
 * java -jar target/itopia-shell-lab-0.0.1-SNAPSHOT.jar
 *
 * The annotation @ShellComponent tells Spring Shell that an annotated class
 * may contain shell methods, which are annotated with @ShellMethod
 */
@Slf4j
@ShellComponent
final class SSHCommand {

    /**
     * The @ShellMethod annotation is used to mark a method as invokable via
     * Spring Shell
     *
     * The @ShellOption annotation simply states that this command takes a
     * parameter named -s
     *
     * @param remoteServer
     */
    @ShellMethod(key="ssh", value = "Connect to remote server")
    public void ssh(
            @ShellOption(value = "-s", defaultValue = "default-srv")
            String remoteServer) {

        log.info(">>> Logged to machine '{}'", remoteServer);
    }

    @ShellMethod(value = "add keys")
    public void sshAdd(@ShellOption(value = "-k", arity = 2) String[] keys) {
        log.info(">>> Adding keys '{}' '{}'", keys[0], keys[1]);
    }

    @ShellMethod(key = "login", value = "Sign in")
    public void sshLogin(
            @ShellOption(value = "-n", defaultValue = "tecuser")
            String username,
            @ShellOption(value = "-r", defaultValue = "false")
            boolean rememberMe) {

        log.info(">>> Logging {} in and remember me option is {}",
                username, rememberMe);
    }

    @ShellMethod(key = "ssha", value = "ssh agent")
    public void sshAgent(
            @ShellOption(value = "-a") @Size(min = 2, max = 10)
            String agent) {

        log.info(">>> Adding agent '{}'", agent);
    }

}///:~