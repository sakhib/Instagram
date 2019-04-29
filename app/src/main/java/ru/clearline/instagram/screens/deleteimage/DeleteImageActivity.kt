package ru.clearline.instagram.screens.deleteimage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_delete_image.*
import ru.clearline.instagram.R
import ru.clearline.instagram.screens.common.*

class DeleteImageActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_image)

        setupAuthGuard {
            val viewModel = initViewModel<DeleteImageViewModel>()
            sign_out_text.setOnClickListener { viewModel.signOut() }
            //back_image.setOnClickListener { finish() }
        }
    }

    companion object {
        private const val EXTRA_POST_ID = "POST_ID"

        fun start(context: Context, postId: String) {
            val intent = Intent(context, DeleteImageActivity::class.java)
            intent.putExtra(EXTRA_POST_ID, postId)
            context.startActivity(intent)
        }
    }
}