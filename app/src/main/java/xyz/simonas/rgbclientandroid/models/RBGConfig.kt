package xyz.simonas.rgbclientandroid.models

import com.google.gson.annotations.SerializedName

data class RBGConfig(
    @SerializedName("note_ratio")
    val noteRatio: Float,
    @SerializedName("min_energy_subraction")
    val minEnergySubraction: Boolean,
    @SerializedName("max_level")
    val maxLevel: Float,
    @SerializedName("min_level")
    val minLevel: Float,
    @SerializedName("pre_power")
    val prePower: Float,
    @SerializedName("multi")
    val multi: Float,
    @SerializedName("post_power")
    val postPower: Float,
    @SerializedName("tint_alpha")
    val tintAlpha: Float,
    @SerializedName("fade_ratio")
    val fadeRatio: Float,
    @SerializedName("tint_color")
    val tintColor: String,
    @SerializedName("note_colors")
    val noteColors: List<String>

) {

    companion object {
        fun default() = RBGConfig(
                noteRatio = 0.95f,
                minEnergySubraction = true,
                maxLevel = 1.0f,
                minLevel = 0.0f,
                prePower = 1.1f,
                multi = 0.9f,
                postPower = 1.0f,
                tintAlpha = 0.2f,
                fadeRatio = 0.05f,
                tintColor = "ff0000",
                noteColors = listOf(
                        "FF0000",
                        "FF7F00",
                        "FFFF00",
                        "7FFF00",
                        "00FF00",
                        "00FF7F",
                        "00FFFF",
                        "007FFF",
                        "0000FF",
                        "7F00FF",
                        "FF00FF",
                        "FF007F"
                )
        )
    }
}
