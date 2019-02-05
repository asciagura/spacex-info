package io.rockets.android.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import io.rockets.android.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(toolbar, findNavController(R.id.nav_host_fragment))
        if (!isAlreadyOpened()) {
            AlertDialog.Builder(this)
                    .setTitle(R.string.welcome_dialog_title)
                    .setMessage(R.string.welcome_dialog_message)
                    .setPositiveButton(android.R.string.ok) { dialog, which -> dialog.dismiss() }
                    .show()

        }
    }

    private fun isAlreadyOpened(): Boolean = getSharedPreferences(DEFAULT_PREF, Context.MODE_PRIVATE).let {
        val opened = it.getBoolean(PREF_OPENED, false)
        if (!opened)
            it.edit { putBoolean(PREF_OPENED, true) }
        opened
    }

    companion object {
        private const val PREF_OPENED = "pref_opened"
        private const val DEFAULT_PREF = "defaults"
    }
}
