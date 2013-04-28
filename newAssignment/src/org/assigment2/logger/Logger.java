package org.assigment2.logger;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Logger {
    public static void log(String message)  throws Exception { 
      PrintWriter out = new PrintWriter(new FileWriter("output.txt"), true);
      out.write(message);
      out.close();
    }
}
