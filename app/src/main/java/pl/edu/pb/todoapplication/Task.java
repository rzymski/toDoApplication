package pl.edu.pb.todoapplication;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task()
    {
        id = UUID.randomUUID();
        date = new Date();
    }

    public Date getDate()
    {
        return date;
    }
    public String getName() {return name; }

    public boolean isDone()
    {
        return done;
    }

    public void setDone(boolean value)
    {
        done = value;
    }
    public void setName(String value) { name = value; }
    public UUID getId() { return id; }
}
