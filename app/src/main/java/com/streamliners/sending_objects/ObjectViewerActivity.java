package com.streamliners.sending_objects;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.streamliners.sending_objects.Models.Student;
import com.streamliners.sending_objects.databinding.ActivityObjectViewerBinding;

public class ObjectViewerActivity extends AppCompatActivity {

    ActivityObjectViewerBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityObjectViewerBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        // Set the title of the activity
        setTitle("View Details");

        //Getting data through the intents
        getData();
    }

    /**
     * Receive data from ObjectSenderActivity
     */
    private void getData() {
        //Validate student object which is coming through the intent
        Student student = getIntent().getExtras().getParcelable(Constants.STUDENT_KEY);

        //Checking that the student is not null
        if(student == null){
            Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
            return;
        }

        //Showing data in text fields
        bind.showNameTextField.setText(student.getName());
        bind.showGenderTextField.setText(student.getGender());
        bind.showRollNumberTextField.setText(student.getRollNumber());
        bind.showMobileNumberTextField.setText(student.getMobileNumber());
    }
}