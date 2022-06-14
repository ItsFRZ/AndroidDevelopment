package com.itsfrz.contentprovider

import android.Manifest
import android.R
import android.app.Activity
import android.content.pm.PackageManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {

    protected val MY_PERMISSION_REQUEST_READ_CONTACTS = 10;
    protected val MY_PERMISSION_REQUEST_WRITE_CONTACTS = 20;


    protected fun hasWriteContactPermission() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED


    protected fun hasReadContactPermission() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED


    protected fun requestPermission(){
        var permissionToRequest = mutableListOf<String>()
        if(!hasWriteContactPermission()){
            permissionToRequest.add(Manifest.permission.WRITE_CONTACTS)
        }
        if(!hasReadContactPermission()){
            permissionToRequest.add(Manifest.permission.READ_CONTACTS)
        }

        if (permissionToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this,permissionToRequest.toTypedArray(),0)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()){
            for (i in grantResults.indices){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("GRANTED_PERMISSIONS", "onRequestPermissionsResult: ${permissions[i]}")
                }else{
                    requestPermission()
                }
            }
        }
    }


}