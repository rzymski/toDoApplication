package pl.edu.pb.todoapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class TaskFragment extends Fragment {
    private Task task;
    public static final String ARG_TASK_ID = "ARG_TASK_ID";

    public static TaskFragment newInstance(UUID taskId){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_TASK_ID, taskId);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(bundle);
        return taskFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TaskFragment","Wywolano: onCreateTaskFragment");
        //task = new Task();
        UUID taskID = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        task = TaskStorage.getInstance().getTask(taskID);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("TaskFragment","Wywolano: onCreateView");
        if (container != null) {
            EditText nameField = container.findViewById(R.id.task_name);
            if(nameField != null) {
                nameField.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        Log.d("TaskFragment","Wywolano: onCreateView beforeTextChanged");
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        task.setName(charSequence.toString());
                        Log.d("TaskFragment","Wywolano: onCreateView onTextChanged");
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        Log.d("TaskFragment","Wywolano: onCreateView afterTextChanged");
                    }
                });
            }

            Button dateButton = container.findViewById(R.id.task_date);
            if (dateButton != null) {
                dateButton.setText(task.getDate().toString());
                dateButton.setEnabled(false);
                Log.d("TaskFragment","Wywolano: onCreateView button click");
            }

            CheckBox doneCheckBox = container.findViewById(R.id.task_done);
            if (doneCheckBox != null) {
                doneCheckBox.setChecked(task.isDone());
                doneCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> task.setDone(isChecked));
                Log.d("TaskFragment","Wywolano: onCreateView check change");
            }
        }

        /*if (container != null) {
            EditText nameField = container.findViewById(R.id.task_name);
            if(nameField != null) {
                nameField.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        Log.d("TaskFragment","Wywolano: onCreateView beforeTextChanged");
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        task.setName(charSequence.toString());
                        Log.d("TaskFragment","Wywolano: onCreateView onTextChanged");
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        Log.d("TaskFragment","Wywolano: onCreateView afterTextChanged");
                    }
                });
            }

            Button dateButton = container.findViewById(R.id.task_date);
            if (dateButton != null) {
                dateButton.setText(task.getDate().toString());
                dateButton.setEnabled(false);
            }
            CheckBox doneCheckBox = container.findViewById(R.id.task_done);
            if (doneCheckBox != null) {
                doneCheckBox.setChecked(task.isDone());
                doneCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> task.setDone(isChecked));
            }
        }*/
        Log.d("TaskFragment","Wywolano: onCreateView end");
        return inflater.inflate(R.layout.fragment_task, container, false);
        //return inflater.inflate(R.layout.fragment_task, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

}
