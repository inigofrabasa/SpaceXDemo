@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
package com.inigofrabasa.spacexdemo.core.adapters

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.inigofrabasa.spacexdemo.AndroidApplication
import com.inigofrabasa.spacexdemo.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("rocketImage")
fun bindRocketImage(view: ImageView, url: String?) {
    url?.apply {
        Glide.with(AndroidApplication.instance.appContext)
                .load(this)
                .placeholder(R.drawable.ic_rocket)
                .error(R.drawable.ic_rocket)
                .into(view)
    }
}

@BindingAdapter("successStatus")
fun bindSuccessStatus(view: ImageView, value: Boolean?) {
    value?.apply {
        when(this){
            true -> view.setImageDrawable(ContextCompat.getDrawable(AndroidApplication.instance.appContext, R.drawable.ic_checkmark))
            false ->view.setImageDrawable(ContextCompat.getDrawable(AndroidApplication.instance.appContext, R.drawable.ic_error_launch))
        }

    }
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
@BindingAdapter("dateFormat")
fun bindDateFormat(textView: TextView, date: String?) {
    date?.apply {
        val fmt = SimpleDateFormat("yyyy-MM-dd")
        val dateFmt: Date = fmt.parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = dateFmt

        val dateBuild = "${calendar.get(Calendar.DAY_OF_MONTH)}-${calendar.get(Calendar.MONTH)+1}-${calendar.get(Calendar.YEAR)}"
        textView.text = dateBuild
    } ?: run{
        textView.text = "No date available"
    }
}