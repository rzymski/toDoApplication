package pl.edu.pb.todoapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks;

    private TaskStorage() {
        tasks = new ArrayList<>();
        for(int i=0; i<= 150; i++)
        {
            Task task = new Task();
            task.setName("Pilne zadanie numer: " + i);
            task.setDone(i%3 == 0);
            tasks.add(task);
        }
    }
    public static TaskStorage getInstance() { return taskStorage; }
    public List<Task> getTasks() { return tasks; }
    public Task getTaskById(int id)
    {
        return tasks.get(id);
    }

    /*@RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<Task> getTask(UUID id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }*/

    public Task getTask(UUID id) {
        for(int i=0; i<tasks.size(); i++)
            if(tasks.get(i).getId() == id)
                return tasks.get(i);
        return null;
    }
}
