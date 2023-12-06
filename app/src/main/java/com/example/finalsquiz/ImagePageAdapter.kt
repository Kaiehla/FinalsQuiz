package com.example.finalsquiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import org.w3c.dom.Text

class ImagePageAdapter(var context: Context, private var images: IntArray, private var titles: Array<String>, private var subtitles: Array<String>): PagerAdapter() {
    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image: ImageView
        val title: TextView
        val subtitle: TextView
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.pager_item, container, false)

        image = itemView.findViewById<ImageView>(R.id.imageView) as ImageView
        title = itemView.findViewById<TextView>(R.id.tvTitle) as TextView
        subtitle = itemView.findViewById<TextView>(R.id.tvSubtitle) as TextView

        image.setImageResource(images[position])
        title.text = "${titles[position]}"
        subtitle.text = "${subtitles[position]}"

        (container as ViewPager).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as RelativeLayout)
    }
}