package com.itsfrz.runtimepermissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : BaseActivity() {



    val TAG = "PERMISSION"
    
    private lateinit var readBtn : Button;
    private lateinit var writeBtn : Button;
    private lateinit var locationBtn : Button;
    private lateinit var cameraBtn : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readBtn = findViewById(R.id.read)
        writeBtn = findViewById(R.id.write)
        cameraBtn = findViewById(R.id.camera)
        locationBtn = findViewById(R.id.location)


        readBtn.setOnClickListener {
            if(requestRunTimePermission(this, arrayOf(Manifest.permission.READ_CONTACTS),READ_CONTACT_RQ)){
                Toast.makeText(this, "Read Hello World", Toast.LENGTH_SHORT).show()
            }
        }

        writeBtn.setOnClickListener {
            if (requestRunTimePermission(this, arrayOf(Manifest.permission.WRITE_CONTACTS),WRITE_CONTACT_RQ)){
                Toast.makeText(this, "Write Hello World", Toast.LENGTH_SHORT).show()
            }
        }
    }

}