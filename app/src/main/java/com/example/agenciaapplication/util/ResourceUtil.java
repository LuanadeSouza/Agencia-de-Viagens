package com.example.agenciaapplication.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String draWableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(draWableEmTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
