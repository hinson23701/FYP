package android.exercise.com.fyp;

import android.graphics.RectF;

/**
 * Created by ssaurel on 15/03/2018.
 */
public class key {

    public int sound;
    public RectF rect;
    public boolean down;

    public key(RectF rect, int sound) {
        this.sound = sound;
        this.rect = rect;
    }
}