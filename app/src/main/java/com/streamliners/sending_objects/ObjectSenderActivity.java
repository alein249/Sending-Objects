package com.streamliners.sending_objects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.streamliners.sending_objects.Models.Student;
import com.streamliners.sending_objects.databinding.ActivityObjectSenderBinding;

public class ObjectSenderActivity extends AppCompatActivity {

    ActivityObjectSenderBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initializing binding object
        bind = ActivityObjectSenderBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        //Setting the title of activity
        setTitle("Enter Details");

        setupOnClickListenerForButton();
        setupActionListener();

        //Call method to hide error
        setupHideErrorForEditText();

    }

    /**
     *  To setup on click listener for button
     */
    private void setupOnClickListenerForButton() {
        bind.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    /**
     * To setup the listener for the mobile text field
     */
    private void setupActionListener() {
        bind.mobileNumberTextField.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    sendData();
                }
                return true;
            }
        });
    }

    private void setupHideErrorForEditText() {
        //Text watcher for name text field
        bind.nameTextField.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bind.nameTextField.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Text watcher for mobile number text field
        bind.mobileNumberTextField.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bind.mobileNumberTextField.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Text watcher for roll number text field
        bind.rollNumberTextField.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bind.rollNumberTextField.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    //Get details of student using user input
    private Student getDetails(){
        //Name of student
        String name = bind.nameTextField.getEditText().getText().toString().trim();
        if(name.isEmpty()){
            bind.nameTextField.setError("Please enter the name");
            return null;
        }

        //Gender of student
        String gender;

        //Type of item chosen in radio button
        int type = bind.genderRadioGrp.getCheckedRadioButtonId();
        if(type == bind.femaleRadioButton.getId()){
            gender = "Female";
        }
        else if(type == bind.maleRadioButton.getId()){
            gender = "Male";
        }
        else{
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
            return null;
        }

        //Roll number of student
        String rollNumber = bind.rollNumberTextField.getEditText().getText().toString().trim();
        if(rollNumber.isEmpty()){
            bind.rollNumberTextField.setError("Please enter roll number");
            return null;
        }
        else if(!rollNumber.matches("^\\d{2}[a-zA-Z]*\\d{3}")){
            bind.rollNumberTextField.setError("Please enter valid roll number");
            return null;
        }

        //Mobile number of student
        String mobileNumber = bind.mobileNumberTextField.getEditText().getText().toString().trim();
        if(mobileNumber.isEmpty()){
            bind.mobileNumberTextField.setError("Please enter mobile number");
            return null;
        }
        else if(!mobileNumber.matches("^\\d{10}")){
            bind.mobileNumberTextField.setError("Please enter valid mobile number");
            return null;
        }
        return new Student(name,gender,rollNumber,mobileNumber);
    }

    /**
     * to sent the data to another activity
     */
    public void sendData() {
        //Student object with entered details
        Student student = getDetails();

        //Checking student if null then returns
        if(student == null){
            return;
        }
        Intent intent = new Intent(this, ObjectViewerActivity.class);
        intent.putExtra(Constants.STUDENT_KEY, student);
        startActivity(intent);
    }
}