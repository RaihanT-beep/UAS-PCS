package com.example.test_uas.home

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.test_uas.R
import com.example.test_uas.base.BaseAdapter
import com.example.test_uas.databinding.ItemNewsBinding
import com.example.test_uas.model.User

class HomeAdapter(private val context: Context) : BaseAdapter<User>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: User) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.avatarUrl).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: User) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.putExtra(HomeActivity, data)
        context.startActivity(intent)
    }
}