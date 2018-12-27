package com.zemiak.toodledototodoist;

import java.util.HashMap;
import java.util.Map;

public class TodoistTask {
    private String type;
    private String content;
    private String priority;
    private String indent;
    private String author;
    private String responsible;
    private String date;
    private String dateLang;
    private String timezone;
    private String note;

    private static final Map<String, String> PRIORITY_MAP;

    static {
        PRIORITY_MAP = new HashMap<>();
        PRIORITY_MAP.put("3", "1");
        PRIORITY_MAP.put("2", "2");
        PRIORITY_MAP.put("1", "3");
        PRIORITY_MAP.put("0", "4");
        PRIORITY_MAP.put("", "4");
        PRIORITY_MAP.put(null, "4");
    }

    public TodoistTask() {
    }

    public TodoistTask(ToodledoTask t) {
        indent = "1";
        responsible = "";
        dateLang = "en";
        type = "task";
        author = "";
        timezone = "";

        this.content = t.getTask();
        if (null != t.getTag() && !"".equals(t.getTag())) {
            this.content = this.content + " @" + t.getTag();
        }

        this.priority = PRIORITY_MAP.get(t.getPriority());
        this.note = t.getNote();
        this.date = t.getDueDate();

        if (!"".equals(t.getRepeat())) {
            this.date = TodoistRepeatable.get(date, t.getRepeat().toLowerCase());
        }
    }

    public static String getHeader() {
        return "TYPE,CONTENT,PRIORITY,INDENT,AUTHOR,RESPONSIBLE,DATE,DATE_LANG,TIMEZONE";
    }

    public String getCsvLine() {
        return "\"" + type + "\"," +
                "\"" + content + "\"," +
                "\"" + priority + "\"," +
                "\"" + indent + "\"," +
                "\"" + author + "\"," +
                "\"" + responsible + "\"," +
                "\"" + date + "\"," +
                "\"" + dateLang + "\"," +
                "\"" + timezone + "\"" +
                ((null == note || "".equals(note)) ? "" : "\n\"note\",\"" + note + "\",,,,,,,");
    }

    @Override
    public String toString() {
        return "TodoistTask{" + "type=" + type + ", content=" + content + ", priority=" + priority + ", indent=" + indent + ", author=" + author + ", responsible=" + responsible + ", date=" + date + ", dateLang=" + dateLang + ", timezone=" + timezone + '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateLang() {
        return dateLang;
    }

    public void setDateLang(String dateLang) {
        this.dateLang = dateLang;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
