package main;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


/**
 * Logger class containing the one static method to log data to a text file. 
 * @author xavierloeraflores
 */
public class Logger {

    /**
     * This function logs log in attempts to a file: login_activity.txt
     * @param valid Boolean value representing if the login attempt was successful
     * @param username String value to represent the account login attempt username 
     */
    public static void log(Boolean valid, String username) throws IOException {
        try {
            String successfulLogin = "Successful Login";
            if(!valid){successfulLogin="Failed Login";}

            String time = ZonedDateTime.now(ZoneOffset.UTC).toString();

            String logFile = "login_activity.txt";
            FileWriter fileWriter = new FileWriter(logFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.append(time + "-" + username + "-" + successfulLogin+ "\n");
            bufferedWriter.close();
        }catch (IOException error) {
            System.out.println("Error: "+ error);
        }
    }
}