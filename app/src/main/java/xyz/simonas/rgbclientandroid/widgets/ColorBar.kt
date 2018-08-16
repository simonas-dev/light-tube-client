package xyz.simonas.rgbclientandroid.widgets

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class ColorBar(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    var selectedColorsListener: (List<Int>) -> Unit = {}

    fun setColors(hexList: List<String>) {
        removeAllViews()
        val colorList = hexList.map { "#$it" }.map { Color.parseColor(it) }
        val selectedColorMap = colorList.associate { it to true }.toMutableMap()
        colorList.map { color ->
            addView(View(context).apply {
                layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0, 1f)
                setBackgroundColor(color)
                setOnClickListener {
                    val isEnabled = selectedColorMap[color]!!.not()
                    selectedColorMap[color] = isEnabled
                    alpha = if(isEnabled) 1f else 0.1f
                    selectedColorsListener(selectedColorMap.filter { it.value }.map { it.key })
                }
            })
        }
    }
}
