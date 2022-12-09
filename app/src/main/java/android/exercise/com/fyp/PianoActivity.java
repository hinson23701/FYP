package android.exercise.com.fyp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PianoActivity extends AppCompatActivity {
    private ImageView imagebyXML;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        imagebyXML = (ImageView)findViewById(R.id.image);

    }





}