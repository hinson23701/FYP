package android.exercise.com.fyp;

import static android.exercise.com.fyp.R.drawable.*;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PianoActivity extends AppCompatActivity {
    private ImageView imagebyXML,bar;
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        imagebyXML = (ImageView)findViewById(R.id.image);
        bar= (ImageView)findViewById(R.id.imageView);
        // Load the animation like this
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);

// Start the animation like this
        bar.startAnimation(animSlide);
    }


    public void changeimage() {
        imagebyXML = (ImageView)findViewById(R.id.image);
        imagebyXML.setImageResource(ode_to_joy);
    }
}