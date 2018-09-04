package com.ssh.toutiaoshipei.toutiaoshipei;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

public class AutoScreenUtils {
    private static float originalScaledDensity;

    public static int DEFAULT_STANDARD = 375;//默认标准

    public static void AdjustDensity(final Application application) {
        final DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        final float originalDensity = displayMetrics.density;
        originalScaledDensity = displayMetrics.scaledDensity;
        application.registerComponentCallbacks(new ComponentCallbacks() {
            @Override
            public void onConfigurationChanged(Configuration newConfig) {
                if (newConfig != null && newConfig.fontScale > 0) {
                    originalScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                }
            }

            @Override
            public void onLowMemory() {
            }
        });

        /**
         * px = density * dp;
         density = dpi / 160;
         px = dp * (dpi / 160);*/

        float targetDensity = (float) displayMetrics.widthPixels / DEFAULT_STANDARD;
        float targetScaledDensity = targetDensity * (originalScaledDensity / originalDensity);
        int targetDensityDpi = (int) (160 * targetDensity);

        displayMetrics.density = targetDensity;
        displayMetrics.scaledDensity = targetScaledDensity;
        displayMetrics.densityDpi = targetDensityDpi;
    }

}
