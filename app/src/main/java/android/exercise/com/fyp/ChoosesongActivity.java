package android.exercise.com.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChoosesongActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosesong);

    }
    public void onClickplayabc(View view) {
        Intent intent = new Intent(this, PianoActivity.class );
        startActivity(intent);


    }


    public void onClickplayode(View view) {
        //to typo
    }
}
