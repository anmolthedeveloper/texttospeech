package com.anmolthedeveloper.texttospeech;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;
    private LanguagesForSP expert = new LanguagesForSP();
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, this);

        // Refer 'Speak' button
        btnSpeak = (Button) findViewById(R.id.btnspeakout);
        // Refer 'Text' control
        txtText = (EditText) findViewById(R.id.edtTexttoSpeak);
        // Handle onClick event for button 'Speak'
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Method yet to be defined
                speakOut();
            }

        });
    }
    private void speakOut() {
        /*TextView TVlanguages = (TextView) findViewById(R.id.TV_Language);
        SPlanguages = (Spinner) findViewById(R.id.language_types);
        //Setting Text For Button
        String workout = String.valueOf(SPlanguages.getSelectedItem());
        //workouts.setText(workout);
        List<String> workoutList = expert.getWorkouts(workout);
        StringBuilder workoutsFormatted = new StringBuilder();
        for (String work : workoutList)
        {
            workoutsFormatted.append(work).append('\n');
        }
        TVlanguages.setText(workoutsFormatted);*/
        // Get the text typed
        String text = txtText.getText().toString();
        // If no text is typed, tts will read out 'You haven't typed text'
        // else it reads out the text you typed
        if (text.length() == 0) {
            tts.speak("You haven't typed text", TextToSpeech.QUEUE_FLUSH, null);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

        }

    }

    public void onDestroy() {
        // Don't forget to shutdown!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        // TTS is successfully initialized
        if (status == TextToSpeech.SUCCESS) {
           // SPlanguages = (Spinner) findViewById(R.id.language_types);
            // Setting speech language
            //String workout = String.valueOf(SPlanguages.getSelectedItem());
            result = tts.setLanguage(Locale.US);
            /*if (workout=="English"){
                result = tts.setLanguage(Locale.US);
            }

            else if (workout=="Chinese"){
                result = tts.setLanguage(Locale.CHINESE);
            }*/

            // If your device doesn't support language you set above
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Cook simple toast message with message
                Toast.makeText(getApplicationContext(), "Language not supported",
                        Toast.LENGTH_LONG).show();
                Log.e("TTS", "Language is not supported");
            }
            // Enable the button - It was disabled in main.xml (Go back and
            // Check it)
            else {
                btnSpeak.setEnabled(true);
            }
            // TTS is not initialized properly
        } else {
            Toast.makeText(this, "TTS Initilization Failed", Toast.LENGTH_LONG)
                    .show();
            Log.e("TTS", "Initilization Failed");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Developer_Activity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


