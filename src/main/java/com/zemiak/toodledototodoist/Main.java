package com.zemiak.toodledototodoist;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] argv) throws IOException {
        Getopt opt = new Getopt(argv, "f:");

        String folder = opt.getArgumentString("-f");
        if (null == folder || "".equals(folder)) {
            folder = null;
        }

        CSVReader reader = new CSVReader(new InputStreamReader(System.in));
        String[] line;
        int lineNumber = 0;

        System.out.println(TodoistTask.getHeader());
        while ((line = reader.readNext()) != null) {
            lineNumber++;
            if (lineNumber == 1) continue; // skip the header

            ToodledoTask toodledoTask = new ToodledoTask(line);
            TodoistTask todoistTask = new TodoistTask(toodledoTask);

            if (null == folder) {
                System.out.println(todoistTask.getCsvLine());
            } else {
                if (toodledoTask.getFolder().equalsIgnoreCase(folder)) {
                    System.out.println(todoistTask.getCsvLine());
                }
            }
        }
    }
}
