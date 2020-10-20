package com.example.snapchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snapchat.ui.main.SnapFragment

class SnapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snap_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SnapFragment.newInstance())
                .commitNow()
        }
    }
}