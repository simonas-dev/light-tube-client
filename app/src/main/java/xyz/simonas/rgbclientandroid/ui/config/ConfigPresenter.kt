package xyz.simonas.rgbclientandroid.ui.config

import android.util.Log
import com.google.gson.Gson
import io.socket.client.IO
import xyz.simonas.rgbclientandroid.models.RBGConfig

class ConfigPresenter(
        override val view: ConfigContract.View
): ConfigContract.Presenter {

    private val multiConst = 2f
    private val fadeConst = 0.5f
    private val noteConst = 1f

    internal val socket = IO.socket("http://192.168.88.173").connect().apply {
        on("*", { Log.d("wat", it.toString()) })
    }

    fun show() {
        view.setFade(currentConfig.fadeRatio / fadeConst)
        view.setMultiplier(currentConfig.multi / multiConst)
        view.setNoteMix(currentConfig.noteRatio / noteConst)
        view.setColorPallete(currentConfig.noteColors)
    }

    private var currentConfig = RBGConfig.default()
        set(value) {
            field = value
            socket.emit("config", Gson().toJson(value))
        }

    override fun startServer() {
        socket.emit("command", "start")
    }

    override fun buildServer() {
        socket.emit("command", "build")
    }

    override fun killServer() {
        socket.emit("command", "kill")
    }

    override fun resetConfig() {
        currentConfig = RBGConfig.default()
        show()
    }

    override fun setNoteMix(ratio: Float) {
        currentConfig = currentConfig.copy(noteRatio = ratio * noteConst)
    }

    override fun setPrePower(ratio: Float) {
        currentConfig = currentConfig.copy(prePower = ratio)
    }

    override fun setMultiplier(ratio: Float) {
        currentConfig = currentConfig.copy(multi = ratio * multiConst)
    }

    override fun setFade(ratio: Float) {
        currentConfig = currentConfig.copy(fadeRatio = ratio * fadeConst)
    }

    override fun setColorPallete(colorList: List<Int>) {
        currentConfig = currentConfig.copy(noteColors = colorList.map { Integer.toHexString(it) })
    }

}