package edu.brandeis.cs.dvilinsk.expenselog;

import java.util.Date;

public class ExpenseLogEntryData {
    private String notes;
    private String description;
    private Date timeEntered;

    public ExpenseLogEntryData() {
        this.timeEntered = new Date(System.currentTimeMillis());
    }

    public ExpenseLogEntryData(String notes, String description) {
        this.notes = notes;
        this.description = description;
        this.timeEntered = new Date(System.currentTimeMillis());
    }

    public Date getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(Date timeEntered) {
        this.timeEntered = timeEntered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
