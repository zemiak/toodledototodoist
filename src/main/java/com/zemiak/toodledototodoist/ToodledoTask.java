package com.zemiak.toodledototodoist;

public class ToodledoTask {
    private String task;
    private String folder;
    private String context;
    private String goal;
    private String location;
    private String startDate;
    private String startTime;
    private String dueDate;
    private String dueTime;
    private String repeat;
    private String length;
    private String timer;
    private String priority;
    private String tag;
    private String status;
    private String star;
    private String note;

    public ToodledoTask() {
    }

    public ToodledoTask(String[] line) {
        task = line[0];
        folder = line[1];
        context = line[2];
        goal = line[3];
        location = line[4];
        startDate = line[5];
        startTime = line[6];
        dueDate = line[7];
        dueTime = line[8];
        repeat = line[9];
        length = line[10];
        timer = line[11];
        priority = line[12];
        tag = line[13];
        status = line[14];
        star = line[15];
        note = line[16];
    }

    @Override
    public String toString() {
        return "ToodledoTask{" + "task=" + task + ", folder=" + folder + ", context=" + context + ", goal=" + goal + ", location=" + location + ", startDate=" + startDate + ", startTime=" + startTime + ", dueDate=" + dueDate + ", dueTime=" + dueTime + ", repeat=" + repeat + ", length=" + length + ", timer=" + timer + ", priority=" + priority + ", tag=" + tag + ", status=" + status + ", star=" + star + ", note=" + note + '}';
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
