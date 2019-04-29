package ru.clearline.instagram.screens.addfriends

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ru.clearline.instagram.data.FeedPostsRepository
import ru.clearline.instagram.data.UsersRepository
import ru.clearline.instagram.data.common.map
import ru.clearline.instagram.models.User
import ru.clearline.instagram.screens.common.BaseViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks

class AddFriendsViewModel(onFailureListener: OnFailureListener,
                          private val usersRepo: UsersRepository,
                          private val feedPostsRepo: FeedPostsRepository)
    : BaseViewModel(onFailureListener) {
    val userAndFriends: LiveData<Pair<User, List<User>>> =
            usersRepo.getUsers().map { allUsers ->
                val (userList, otherUsersList) = allUsers.partition {
                    it.uid == usersRepo.currentUid()
                }
                userList.first() to otherUsersList
            }

    fun setFollow(currentUid: String, uid: String, follow: Boolean): Task<Void> {
        return (if (follow) {
            Tasks.whenAll(
                    usersRepo.addFollow(currentUid, uid),
                    usersRepo.addFollower(currentUid, uid),
                    feedPostsRepo.copyFeedPosts(postsAuthorUid = uid, uid = currentUid))
        } else {
            Tasks.whenAll(
                    usersRepo.deleteFollow(currentUid, uid),
                    usersRepo.deleteFollower(currentUid, uid),
                    feedPostsRepo.deleteFeedPosts(postsAuthorUid = uid, uid = currentUid))
        }).addOnFailureListener(onFailureListener)
    }
}