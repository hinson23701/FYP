package android.exercise.com.fyp;

import static android.exercise.com.fyp.R.drawable.*;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PianoActivity extends AppCompatActivity {
    private ImageView imagebyXML,bar;
    protected void onCreate(Bundle savedInstanceState) {

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                AlertDialog.Builder builder = new AlertDialog.Builder(PianoActivity.this);

                // Set the message show for the Alert time
                builder.setMessage("Do you restart the games?");

                // Set Alert Title
                builder.setTitle("Restart game");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Yes!", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                });

                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // If user click no then dialog box is canceled.
                    dialog.cancel();
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();

                return true;
            case R.id.help:
                // do something
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    public void changeimage() {
        imagebyXML = (ImageView)findViewById(R.id.image);
        imagebyXML.setImageResource(ode_to_joy);
    }
}