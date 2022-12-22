package android.exercise.com.fyp;

import static android.exercise.com.fyp.R.drawable.*;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class PianoActivity extends AppCompatActivity {
    private ImageView imagebyXML,bar;
    Animation animSlide;
    private boolean permissionToRecordAccepted = false;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);
        setContentView(R.layout.activity_piano);
        imagebyXML = (ImageView)findViewById(R.id.image);
        bar= (ImageView)findViewById(R.id.imageView);
        // Load the animation like this
         animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);

// Start the animation like this
        bar.startAnimation(animSlide);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted ) finish();

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
            case R.id.SongSpeed:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Please choose the song speed(bpm) for playing");
                builder.setIcon(ic_music);
                final String[] items = new String[]{"0.5", "normal", "1.25"};
                builder.setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {/*设置单选条件的点击事件*/
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PianoActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PianoActivity.this, "OK", Toast.LENGTH_SHORT).show();

                        }

                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PianoActivity.this, "CANCEL", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                builder.show();
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