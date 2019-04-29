package ru.clearline.instagram.screens

import android.app.Application
import ru.clearline.instagram.common.firebase.FirebaseAuthManager
import ru.clearline.instagram.data.firebase.FirebaseFeedPostsRepository
import ru.clearline.instagram.data.firebase.FirebaseNotificationsRepository
import ru.clearline.instagram.data.firebase.FirebaseSearchRepository
import ru.clearline.instagram.data.firebase.FirebaseUsersRepository
import ru.clearline.instagram.screens.notifications.NotificationsCreator
import ru.clearline.instagram.screens.search.SearchPostsCreator

class InstagramApp : Application() {
    val usersRepo by lazy { FirebaseUsersRepository() }
    val feedPostsRepo by lazy { FirebaseFeedPostsRepository() }
    val notificationsRepo by lazy { FirebaseNotificationsRepository() }
    val authManager by lazy { FirebaseAuthManager() }
    val searchRepo by lazy { FirebaseSearchRepository() }

    override fun onCreate() {
        super.onCreate()
        NotificationsCreator(notificationsRepo, usersRepo, feedPostsRepo)
        SearchPostsCreator(searchRepo)
    }
}