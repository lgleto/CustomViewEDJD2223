package ipca.example.customcontrol

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class VerticalSlider  : View {

    private var touchY = 0F
    var percent = 0F

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        val outerRect = Rect( 0, 0, width, height)
        canvas?.drawRect(outerRect, paint)

        paint.color = Color.BLUE
        val innerRect = Rect( 0, touchY.toInt(), width , height )
        canvas?.drawRect(innerRect, paint)

        paint.color = Color.WHITE
        paint.textSize = 60.0F

        val percent = ((height - touchY)/height)*100f
        canvas?.drawText("${percent.toInt()}%",0f, height.toFloat() - 20f, paint)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        val y = event?.y

        when(event?.action){
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_MOVE
            -> {
                y?.let {
                    var v = it
                    if (v <= 0f)  v = 0f
                    if (v >= height) v = height.toFloat()
                    touchY = v

                    percent = ((height - touchY)/height)*100f
                    invalidate()

                }
                return true
            }

        }

        return false

    }
}