package com.github.lsteamer.contentretrieverdemo

import android.content.ContentProviderClient
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var rs: Cursor? = null

    val PROVIDER_NAME = "com.github.lsteamer.contentproviderdemo/AcronymProvider"
    val URL = "content://$PROVIDER_NAME/ACTABLE"
    val CONTENT_URI = Uri.parse(URL)

    val _ID = "_ID"
    val NAME = "NAME"
    val MEANING = "MEANING"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rs = contentResolver.query(CONTENT_URI, arrayOf(_ID, NAME, MEANING),null, null, null )


        button.setOnClickListener {

            rs?.let {
                it.moveToFirst()
                Log.d("wat", it.getString(1))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        rs?.close()
    }
}