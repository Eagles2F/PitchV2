package magicbox.us.pitch.util;

import java.util.Random;

import magicbox.us.pitch.R;

/**
 * Created by evan on 12/9/15.
 */
public class Utils {
    public static int getDrawableId() {
        int [] images ={
            R.drawable.giraffe,
        R.drawable.kangroo,
        R.drawable.koala,
        R.drawable.korgi,
        R.drawable.lion,
        R.drawable.panda,
        R.drawable.purrito,
        R.drawable.shark,
        R.drawable.zebra};
        Random i = new Random();
        return images[i.nextInt(9)];
    }
}
