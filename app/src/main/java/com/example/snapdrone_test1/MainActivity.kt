package com.example.snapdrone_test1

import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
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
            //page 바뀌면 position으로 넘겨짐
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                when(position){
                    0 ->
                        textview.text = "drone request testpage"
                    1 ->
                        textview.text = "drone control testpage"
                }
            }

            override fun onPageScrollStateChanged(state: Int) { //

            }

            override fun onPageSelected(position: Int) { //page 선택 됐을때

            }
        })

        if(savedInstanceState != null){ //화면 가로로 돌아갔을 때

        }
    }

    inner class CustomAdapter : PagerAdapter(){
        override fun getCount(): Int { //전체 view 크기, 여기서는 2개
            return view_list.size
        }

        override fun isViewFromObject(view: View, obj : Any): Boolean {
            return view == obj
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            pager.addView(view_list[position]) //해당하는 페이지 뷰 보여주라는거
            return view_list[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            pager.removeView(obj as View) //이제 쓸모없는거는 보이지 말라는거 이거 없으면 안 돌아감

        }
    }

}
