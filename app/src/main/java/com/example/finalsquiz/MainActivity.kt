package com.example.finalsquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private lateinit var dotLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSkipActivity = findViewById<Button>(R.id.btnSkip)
        btnSkipActivity.setOnClickListener {
            val intent = Intent(this, SkipActivity::class.java)
            startActivity(intent)
        }

        val images: IntArray = intArrayOf(
            R.drawable.image_site,
            R.drawable.image_css,
            R.drawable.image_iss
        )

        val title: Array<String> = arrayOf(
            "Information Technology",
            "Computer Science",
            "Information Systems"
        )

        val subtitle: Array<String> = arrayOf(
            "Society of Information Technology Enthusiasts",
            "Computer Science Society",
            "Information Systems Society"
        )



        val viewPager: ViewPager = findViewById<View>(R.id.pager) as ViewPager
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout).setupWithViewPager(viewPager, true)

        val adapter: PagerAdapter = ImagePageAdapter(this, images, title, subtitle)

        viewPager.adapter = adapter






    }


}