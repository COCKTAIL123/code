package com.im.im.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.im.im.R
import org.jetbrains.anko.sp

/**
 * Created by Administrator on 2018/3/29 0029.
 */
class SlideBar(context: Context?, attrs: AttributeSet?=null) : View(context, attrs) {
    var sectionHeight = 0F
    var textBaseline = 0F
    var paint = Paint()
    var onsectionChangeListener:OnSectionChangeListener?=null
    companion object {
        private val SECTIONS = arrayOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
    }
    init {
        paint.apply {
            color = resources.getColor(R.color.qq_section_text_color)
            textSize = sp(12).toFloat()
            textAlign = Paint.Align.CENTER
        }
    }
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        //计算每个字符的非配高度
        sectionHeight = h*1.0f/ SECTIONS.size
        //字体维度
        val fontMetrics = paint.fontMetrics
        //字体居中
        val textHeigth = fontMetrics.descent-fontMetrics.ascent
        textBaseline = sectionHeight/2+(textHeigth/2-fontMetrics.descent)
    }
    override fun onDraw(canvas: Canvas) {
        //绘制的起始位置？
        val x = width*1.0f/2F
        //

        var baseline = textBaseline
        //绘制所有字母
        SECTIONS.forEach {
            canvas.drawText(it,x,baseline,paint)
            baseline+=sectionHeight
        }

    }
    //点击背景的变化
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                setBackgroundColor(R.drawable.bg_slide_bar)
                //找到点击的字母
                val index = getTouchIndex(event)
                val firstLetter = SECTIONS[index]
                print(firstLetter)
                onsectionChangeListener?.OnSectionChange(firstLetter)

            }
            MotionEvent.ACTION_MOVE->{
                setBackgroundColor(R.drawable.bg_slide_bar)
                //找到点击的字母
                val index = getTouchIndex(event)
                val firstLetter = SECTIONS[index]
                print(firstLetter)
                onsectionChangeListener?.OnSectionChange(firstLetter)

            }
            MotionEvent.ACTION_UP->{

                setBackgroundColor(Color.TRANSPARENT)
                onsectionChangeListener?.onSlideFinish()

            }

        }
        return true//消费时间
    }

    private fun getTouchIndex(event: MotionEvent): Int {
        var index = (event.y/sectionHeight).toInt()
        //越界判断
        if (index<0){
            index = 0
        }else if(index>= SECTIONS.size){
            index = SECTIONS.size-1
        }
        return index
    }
    interface OnSectionChangeListener{
        fun OnSectionChange(firstLetter:String)
        fun onSlideFinish()//滑动结束
    }
}