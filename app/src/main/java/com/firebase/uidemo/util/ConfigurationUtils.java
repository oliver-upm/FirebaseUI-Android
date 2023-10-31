package com.firebase.uidemo.util;

import android.annotation.SuppressLint;
import android.content.Context;

import com.firebase.ui.auth.AuthUI;
import com.firebase.uidemo.R;
import com.google.firebase.auth.ActionCodeSettings;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

@SuppressLint("RestrictedApi")
public final class ConfigurationUtils {

    private ConfigurationUtils() {
        throw new AssertionError("No instance for you!");
    }

    @NonNull
    public static List<AuthUI.IdpConfig> getConfiguredProviders(@NonNull Context context) {
        List<AuthUI.IdpConfig> providers = new ArrayList<>();

        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                .setAndroidPackageName("com.firebase.uidemo", true, null)
                .setHandleCodeInApp(true)
                .setUrl("https://google.com")
                .build();

        providers.add(new AuthUI.IdpConfig.EmailBuilder()
                .setAllowNewAccounts(true)
                .enableEmailLinkSignIn()
                .setActionCodeSettings(actionCodeSettings)
                .build());

        return providers;
    }
}
