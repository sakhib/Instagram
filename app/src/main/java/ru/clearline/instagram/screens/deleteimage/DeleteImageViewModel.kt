package ru.clearline.instagram.screens.deleteimage

import com.google.android.gms.tasks.OnFailureListener
import ru.clearline.instagram.common.AuthManager
import ru.clearline.instagram.screens.common.BaseViewModel

class DeleteImageViewModel(private val authManager: AuthManager,
                               onFailureListener: OnFailureListener) :
        BaseViewModel(onFailureListener),
        AuthManager by authManager