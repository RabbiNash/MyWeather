package dev.nashe.myweather.utils

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dev.nashe.myweather.R

class BindingUtil {

    companion object {

        @JvmStatic
        @BindingAdapter("iconId")
        fun setOpenWeatherIcon(imageView: ImageView?, id : String?){
            val url = "https://openweathermap.org/img/wn/${id}@2x.png"

            val options = RequestOptions()
                .error(R.drawable.ic_search)
                .centerInside()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

            if (imageView != null) {
                Glide.with(imageView).load(url).apply(options).into(imageView)
            }
        }

        @JvmStatic
        @BindingAdapter("forecastDate")
        fun setForecastDate(textView: TextView, timeInMillis : Long){
            textView.text = DateTimeUtils.getFormattedDate(timeInMillis)
        }

        @JvmStatic
        @BindingAdapter("android:visible_or_gone")
        fun setVisibleOrGone(view: View, visible: Boolean) {
            view.visibility = if (visible) View.VISIBLE else View.GONE
        }

    }
}