package com.vipul.mypercentage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    EditText firstSem, secondSem, thirdSem, fourthSem, fifthSem, sixthSem;
    int firstSemMarks, secondSemMarks, thirdSemMarks, fourthSemMarks, fifthSemMarks, sixthSemMarks;
    String message;
//Maximum marks variables
    int firstSemMaxMarks = 750,
            secondSemMaxMarks = 1150,
            thirdSemMaxMarks = 1100,
            fourthSemMaxMarks = 1250,
            fifthSemMaxMarks = 1050,
            sixthSemMaxMarks = 1000;
/*
Calculate the total marks of any year and also take 20% marks from first year & 40% marks from 2nd and third years each.
In diploma delhi, the overall percentage of all three years are calculated by taking share of 20% marks from first year & 40% marks from 2nd and third years each.
 */
    double firstYearMaxTotal = (firstSemMaxMarks+secondSemMaxMarks)*0.20,
            secondYearMaxTotal = (thirdSemMaxMarks+fourthSemMaxMarks)*0.40,
            thirdYearMaxTotal= (fifthSemMaxMarks+sixthSemMaxMarks)*0.40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link java tio layouts
        firstSem = findViewById(R.id.sem1stEditText);
        secondSem = findViewById(R.id.sem2ndEditText);
        thirdSem = findViewById(R.id.sem3rdEditText);
        fourthSem = findViewById(R.id.sem4thEditText);
        fifthSem = findViewById(R.id.sem5thEditText);
        sixthSem = findViewById(R.id.sem6thEditText);
    }

    //This method will be executed when the "Calculate" button is being pressed.
    public void calculateResult(View view){
        //Check if any of the EditText fields are empty. If yes then it will show a toast. If not then it will execute further code.
        if (firstSem.getText().toString().isEmpty() | secondSem.getText().toString().isEmpty() | thirdSem.getText().toString().isEmpty() | fourthSem.getText().toString().isEmpty() | fifthSem.getText().toString().isEmpty() | sixthSem.getText().toString().isEmpty()){
            Toast.makeText(this, "Seriously? Fields can't be empty noob!", Toast.LENGTH_SHORT).show();
        } else {

            //Take values from EditTexts, convert them into integer and put them in variables
            firstSemMarks = Integer.parseInt(firstSem.getText().toString());
            secondSemMarks = Integer.parseInt(secondSem.getText().toString());
            thirdSemMarks = Integer.parseInt(thirdSem.getText().toString());
            fourthSemMarks = Integer.parseInt(fourthSem.getText().toString());
            fifthSemMarks = Integer.parseInt(fifthSem.getText().toString());
            sixthSemMarks = Integer.parseInt(sixthSem.getText().toString());

            /*
Calculate the total obtained marks of any year and also take 20% marks from first year & 40% marks from 2nd and third years each.
In diploma delhi, the overall percentage of all three years are calculated by taking share of 20% marks from first year & 40% marks from 2nd and third years each.
 */
            double firstYearTotal = (firstSemMarks + secondSemMarks) * 0.20,
                    secondYearTotal = (thirdSemMarks + fourthSemMarks) * 0.40,
                    thirdYearTotal = (fifthSemMarks + sixthSemMarks) * 0.40;

            //Calculate percentage
            double finalPercentageFull = (firstYearTotal + secondYearTotal + thirdYearTotal) / (firstYearMaxTotal + secondYearMaxTotal + thirdYearMaxTotal) * 100;

            //Only show 2 decimal places after decimal
            String finalPercentage = String.format("%.2f", finalPercentageFull);
            TextView resultText = findViewById(R.id.resultTextView);

            //check if it exceeds the max marks
            if (finalPercentageFull > 100) {
                Toast.makeText(this, "Enter values again, obtained marks are exceeding Max marks! ", Toast.LENGTH_LONG).show();
            } else {
                //Show message to students according to their marks
                if (finalPercentageFull >= 80 && finalPercentageFull <= 100) {
                    message = "Damn topper! You've got " + finalPercentage+"%";
                } else if (finalPercentageFull >= 70 && finalPercentageFull < 80) {
                    message = "You've got " + finalPercentage + "% hard worker!";
                } else if (finalPercentageFull >= 60 && finalPercentageFull < 70) {
                    message = "Well tried! You've got " + finalPercentage+"%";
                } else if (finalPercentageFull >= 40 && finalPercentageFull < 60) {
                    message = "You've got " + finalPercentage + "% Not bad!";
                } else {
                    message = "What a failure dude! You've got just " + finalPercentage+"%";
                }
                resultText.setText(message);

            }
        }
    }
}
