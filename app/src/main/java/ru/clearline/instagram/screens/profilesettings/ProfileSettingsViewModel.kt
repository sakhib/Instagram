package ru.clearline.instagram.screens.profilesettings

import ru.clearline.instagram.common.AuthManager
import ru.clearline.instagram.screens.common.BaseViewModel
import com.google.android.gms.tasks.OnFailureListener

class ProfileSettingsViewModel(private val authManager: AuthManager,
                               onFailureListener: OnFailureListener) :
        BaseViewModel(onFailureListener),
        AuthManager by authManager