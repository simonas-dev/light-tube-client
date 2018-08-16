package xyz.simonas.rgbclientandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import xyz.simonas.rgbclientandroid.ui.config.ConfigFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ConfigFragment())
                .commit()
    }
}
