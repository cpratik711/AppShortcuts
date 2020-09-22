package com.pratik.appshortcuts

import android.annotation.TargetApi
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        val SHORTCUT_1 = "shortcut_one"
        val SHORTCUT_2 = "shortcut_two"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createShorcut()
    }

    @TargetApi(25)
    private fun createShorcut() {
        val shorcutManager = getSystemService(ShortcutManager::class.java)
        val intent1 = Intent(applicationContext, ShortcutActivity::class.java)
        intent1.apply {
            action = Intent.ACTION_VIEW
        }

        val shortcut1 = ShortcutInfo.Builder(this, SHORTCUT_1)
            .setIntent(intent1)
            .setShortLabel("Dynamic 1 Short Label")
            .setDisabledMessage("Dynamic 1 Disable message")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_eco))
            .build()


        val shortcut2 = ShortcutInfo.Builder(this, SHORTCUT_2)
            .setIntent(intent1)
            .setShortLabel("Dynamic 2 Short Label")
            .setLongLabel("Dynamic 2 Long Label")
            .setDisabledMessage("Dynamic 2 Disable message")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_eco))
            .build()



        shorcutManager.dynamicShortcuts = Arrays.asList(shortcut1, shortcut2)
        shorcutManager.disableShortcuts(Collections.singletonList(SHORTCUT_1))
    }


}