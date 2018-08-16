package xyz.simonas.rgbclientandroid.ui.config

import xyz.simonas.rgbclientandroid.ui.BasePresenter
import xyz.simonas.rgbclientandroid.ui.BaseView

interface ConfigContract {

    interface View : BaseView {
        fun setNoteMix(ratio: Float)
        fun setMultiplier(ratio: Float)
        fun setFade(ratio: Float)
        fun setColorPallete(colorList: List<String>)
    }

    interface Presenter : BasePresenter {
        fun startServer()
        fun buildServer()
        fun killServer()
        fun resetConfig()
        fun setNoteMix(ratio: Float)
        fun setPrePower(ratio: Float)
        fun setMultiplier(ratio: Float)
        fun setFade(ratio: Float)
        fun setColorPallete(colorList: List<Int>)
    }

}