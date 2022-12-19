package android.exercise.com.fyp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoosesongActivity extends AppCompatActivity {
    PianoActivity piano;

    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosesong);

    }
    public void onClickplayabc(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChoosesongActivity.this);

        // Set the message show for the Alert time
        builder.setMessage("Welcome to ABC song practice/games,Do you want play now?");

        // Set Alert Title
        builder.setTitle("ABC Song playing");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Play!", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
            Intent intent = new Intent(this, PianoActivity.class );
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



    }


    public void onClickplayode(View view) {
        //to typo
        Intent intent = new Intent(this, PianoActivity.class );
        startActivity(intent);

    }


}
