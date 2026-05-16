package fr.g123k.deviceapps.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class DrawableUtils {

    public static Bitmap getBitmapFromDrawable(Drawable drawable) {
        final int width = drawable.getIntrinsicWidth();
        final int height = drawable.getIntrinsicHeight();

        // Some drawables (e.g. ColorDrawable, broken vector/adaptive icons) report
        // an intrinsic size of -1. Bitmap.createBitmap would throw in that case, so
        // fall back to a 1x1 transparent bitmap to keep the icon contract stable.
        if (width <= 0 || height <= 0) {
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }

        final Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        final Canvas canvas = new Canvas(bmp);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bmp;
    }

}
