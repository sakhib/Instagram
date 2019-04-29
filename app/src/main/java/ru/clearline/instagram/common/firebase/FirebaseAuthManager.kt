package ru.clearline.instagram.common.firebase

import ru.clearline.instagram.common.AuthManager
import ru.clearline.instagram.common.toUnit
import ru.clearline.instagram.data.firebase.common.auth
import com.google.android.gms.tasks.Task

class FirebaseAuthManager : AuthManager {
    override fun signOut() {
        auth.signOut()
    }

    override fun signIn(email: String, password: String): Task<Unit> =
        auth.signInWithEmailAndPassword(email, password).toUnit()
}