package hundreddaysofcode.solarsystem

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SolarSystemView : View {

    private val sunPaint by lazy { Paint(Paint.ANTI_ALIAS_FLAG) }
    private val earthPaint by lazy { Paint(Paint.ANTI_ALIAS_FLAG) }
    private val moonPaint by lazy { Paint(Paint.ANTI_ALIAS_FLAG) }

    private val sunRadius = 100f
    private val earthRadius = 50f
    private val moonRadius = 10f
    private val distance = 350f
    private val moonDistance = 100f

    private var sunX = 0f
    private var sunY = 0f

    private var earthX = 0f
    private var earthY = 0f

    private var moonX = 0f
    private var moonY = 0f

    private var angle = 0.0
    private var moonAngle = 0.0

    fun changeEarthAngle(amounth: Double) {
        angle -= amounth
    }

    fun changeMoonAngle(amounth: Double) {
        moonAngle -= amounth
    }

    val time = Thread {
        while (true) {
            Thread.sleep(10)
            changeEarthAngle(0.03)
            changeMoonAngle(0.1)
            postInvalidate()
        }
    }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        sunPaint.color = Color.YELLOW
        earthPaint.color = Color.GREEN
        moonPaint.color = Color.WHITE
        time.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        sunX = width / 2f
        sunY = height / 2f
        canvas.drawCircle(sunX, sunY, sunRadius, sunPaint)

        earthX = (sunX + distance * Math.cos(angle)).toFloat()
        earthY = (sunY + distance * Math.sin(angle)).toFloat()
        canvas.drawCircle(earthX, earthY, earthRadius, earthPaint)

        moonX = (earthX + moonDistance * Math.cos(moonAngle).toFloat())
        moonY = (earthY + moonDistance * Math.sin(moonAngle).toFloat())
        canvas.drawCircle(moonX, moonY, moonRadius, moonPaint)
    }


}
