package com.example.snapdrone_test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var view_list = ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_list.add(layoutInflater.inflate(R.layout.ingview,null))
        view_list.add(layoutInflater.inflate(R.layout.cameraview,null))


        pager.adapter = CustomAdapter()

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                when(position){
                    0 ->
                        textview.text = "drone request testpage"
                    1 ->
                        textview.text = "drone control testpage"
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {

            }
        })
    }

    inner class CustomAdapter : PagerAdapter(){
        override fun getCount(): Int {
            return view_list.size
        }

        override fun isViewFromObject(view: View, obj : Any): Boolean {
            return view == obj
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            pager.addView(view_list[position])
            return view_list[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            pager.removeView(obj as View)

        }
    }
}
