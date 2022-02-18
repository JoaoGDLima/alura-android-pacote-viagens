package com.example.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.aluraviagens.model.Pacote;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String DrawableEmTexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(DrawableEmTexto, DRAWABLE, context.getPackageName());
        Drawable drawableImagemPacote= resources.getDrawable(idDrawable);
        return drawableImagemPacote;
    }
}
