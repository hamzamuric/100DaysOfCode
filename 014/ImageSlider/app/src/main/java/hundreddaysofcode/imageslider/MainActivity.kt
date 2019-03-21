package hundreddaysofcode.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = arrayOf(
            "https://www.wga.hu/art/m/mor/5gresham.jpg",
            "https://www.wga.hu/art/r/revoil/reneanjo.jpg",
            "https://www.wga.hu/art/t/thulden/educatio.jpg",
            "https://www.wga.hu/art/b/bassano/leandro/penelope.jpg",
            "https://www.wga.hu/art/r/renoir/3/3renoi21.jpg",
            "https://www.wga.hu/art/c/claudel/waltz1.jpg",
            "https://www.wga.hu/art/v/velde/willem/calmdutch.jpg",
            "https://www.wga.hu/art/m/momper/josse2/mountai1.jpg"
        )

        val viewpager = findViewById<ViewPager>(R.id.view_pager)
        val adapter = ViewPagerAdapter(this, images)
        viewpager.adapter = adapter
    }
}
