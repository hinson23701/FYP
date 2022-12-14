package android.exercise.com.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button GamePlay, minigames, video, Close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        GamePlay = findViewById(R.id.btn_play);
        minigames = findViewById(R.id.btn_minigames);
        video = findViewById(R.id.btn_video);

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.my_options_menu, menu);

        return true;

    }
    public void onClickplay(View view) {
        Intent intent = new Intent(this, ChoosesongActivity.class );
        startActivity(intent);


    }

    public void onClickVideo(View view) {
        Intent intent = new Intent(this, VideoActivity.class );
        startActivity(intent);
    }
}