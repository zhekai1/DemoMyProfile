package sg.edu.rp.c346.id21024750.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    Button buttonSave;
    RadioButton radioButtonGenderMale;
    RadioButton radioButtonGenderFemale;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGPA = findViewById(R.id.etGPA);
        buttonSave = findViewById(R.id.buttonSave);
        radioButtonGenderMale = findViewById(R.id.radioButtonGenderMale);
        radioButtonGenderFemale = findViewById(R.id.radioButtonGenderFemale);
        rgGender = findViewById(R.id.rgGender);

    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float gpa= Float.parseFloat(etGPA.getText().toString());
        String gender = rgGender.toString();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putString("gender", gender);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name", "John");
        float gpa = prefs.getFloat("gpa", 0);
        String gender = prefs.getString("gender", "gender");
        etName.setText(strName);
        etGPA.setText(gpa + "");

        if ( gender.equals("Male")) {
            rgGender.check(R.id.radioButtonGenderMale);
        } else if ( gender.equals("Female")){
            rgGender.check(R.id.radioButtonGenderFemale);
        }
    }
}

