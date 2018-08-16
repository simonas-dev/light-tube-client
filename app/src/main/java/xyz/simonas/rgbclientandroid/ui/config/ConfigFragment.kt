package xyz.simonas.rgbclientandroid.ui.config

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sdsmdg.harjot.crollerTest.Croller
import xyz.simonas.rgbclientandroid.R
import xyz.simonas.rgbclientandroid.widgets.ColorBar

class ConfigFragment : Fragment(),
        ConfigContract.View {

    val presenter = ConfigPresenter(this)

    lateinit var multiBar: Croller
    lateinit var noteBar: Croller
    lateinit var fadeBar: Croller
    lateinit var colorBar: ColorBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_config_2, container, false)
    }

    override fun setNoteMix(ratio: Float) {
        noteBar.apply {
            progress = (ratio * max).toInt()
        }
    }

    override fun setMultiplier(ratio: Float) {
        multiBar.apply {
            progress = (ratio * max).toInt()
        }
    }

    override fun setFade(ratio: Float) {
        fadeBar.apply {
            progress = (ratio * max).toInt()
        }
    }

    override fun setColorPallete(colorList: List<String>) {
        colorBar.setColors(colorList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.startButton).setOnClickListener {
            presenter.startServer()
        }

        view.findViewById<View>(R.id.resetButton).setOnClickListener {
            presenter.resetConfig()
        }

        multiBar = view.findViewById<Croller>(R.id.fadeBar).apply {
            val maxF = 1000f
            max = maxF.toInt()
            setOnProgressChangedListener { progress ->
                presenter.setMultiplier(progress / maxF)
            }
        }

        noteBar = view.findViewById<Croller>(R.id.noteBar).apply {
            val maxF = 1000f
            max = maxF.toInt()
            setOnProgressChangedListener { progress ->
                presenter.setNoteMix(progress / maxF)
            }
        }

        fadeBar = view.findViewById<Croller>(R.id.multiplyBar).apply {
            val maxF = 1000f
            max = maxF.toInt()
            setOnProgressChangedListener { progress ->
                presenter.setFade(progress / maxF)
            }
        }

        colorBar = view.findViewById<ColorBar>(R.id.colorContainer).apply {
            selectedColorsListener = { colorList ->
                presenter.setColorPallete(colorList)
            }
        }


        presenter.show()
    }
}