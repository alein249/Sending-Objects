package com.streamliners.sending_objects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.streamliners.sending_objects.Models.Student;
import com.streamliners.sending_objects.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        //Getting data through the intents
        getData();
    }

    private void getData() {
        //Validate student object which is coming through the intent
        Student student = getIntent().getExtras().getParcelable(Constants.STUDENT_KEY);

        //Checking that the student is not null
        if(student == null){
            Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
            return;
        }

        //Showing data in text fields
        bind.showNameTextField.getEditText().setText(student.getName());
        bind.showGenderTextField.getEditText().setText(student.getGender());
        bind.showRollNumberTextField.getEditText().setText(student.getRollNumber());
        bind.showMobileNumberTextField.getEditText().setText(student.getMobileNumber());
    }
}