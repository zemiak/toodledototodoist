package com.zemiak.toodledototodoist;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSVReader implements Closeable {
    Scanner scanner;
    private String quote = "\"";
    private String delimiter = ",";
    private String newline = "\n";

    public CSVReader(Readable reader) {
        scanner = new Scanner(reader);
        scanner.useDelimiter("");
    }

    public CSVReader() {
    }

    public void setReader(Readable reader) {
        scanner = new Scanner(reader);
        scanner.useDelimiter("");
    }

    public String[] readNext() {
        String c;
        String field = "";
        boolean insideQuote = false;
        List<String> fields = new ArrayList<>();

        while (true) {
            try {
                c = scanner.next();
            } catch (NoSuchElementException ex) {
                break;
            }

            if (null == c) {
                break;
            }

            // double quote
            if (quote.equals(c) && scanner.hasNext(c)) {
                field = field + c;
                scanner.next(); // skip the second quote
                continue;
            }

            if (quote.equals(c)) {
                if (insideQuote) {
                    insideQuote = false;
                    fields.add(field);
                    field = "";

                    // skip the delimiter after quote
                    if (scanner.hasNext(delimiter)) {
                        scanner.next(delimiter);
                    }
                } else {
                    insideQuote = true;
                }

                continue;
            }

            if (delimiter.equals(c)) {
                if (!insideQuote) {
                    fields.add(field);
                    field = "";

                    continue;
                }
            }

            if (newline.equals(c)) {
                if (!insideQuote) {
                    fields.add(""); // a stupid hack for trailing delimiters

                    break;
                }
            }

            field = field + c;
        }

        return fields.isEmpty() ? null : fields.toArray(new String[]{});
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getNewline() {
        return newline;
    }

    public void setNewline(String newline) {
        this.newline = newline;
    }

    @Override
    public void close() throws IOException {
        if (null != scanner) {
            scanner.close();
        }
    }
}
