package pl.edu.pb.todoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import java.util.UUID;

public class TaskListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        Log.d("TaskListActivity","Wywolano: TaskList createfragment crateFragment");
        //return new TaskFragment();
        UUID taskId = (UUID) getIntent().getSerializableExtra(TaskListFragment.KEY_EXTRA_TASK_ID);
        return TaskFragment.newInstance(taskId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_task);
        Log.d("TaskListActivity","Wywolano: createfragment TaskListActivity");
        //createFragment();

        setContentView(R.layout.activity_main);
    }
}