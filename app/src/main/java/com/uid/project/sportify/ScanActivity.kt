package com.uid.project.sportify

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import com.uid.project.sportify.QR.QRCodeFoundListener
import com.uid.project.sportify.QR.QRCodeImageAnalyzer
import de.hdodenhof.circleimageview.CircleImageView
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorService


class ScanActivity : AppCompatActivity() {
    private lateinit var viewFinder : PreviewView


    private val code = 1
    private var participantCode : String = ""

    private lateinit var textStatus : TextView
    private lateinit var buttonScan : Button
    private var qrCode: String? = null
    private var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_scan_codes)

        textStatus = findViewById(R.id.textView18)
        viewFinder = findViewById(R.id.viewFinder)
        buttonScan = findViewById(R.id.button2)
        cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        // Request camera permissions
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }
        var titleEvent = findViewById<TextView>(R.id.textView2)
        var dateEvent = findViewById<TextView>(R.id.textView)
        var location = findViewById<TextView>(R.id.textView37)
        var image = findViewById<CircleImageView>(R.id.imageView15)

        titleEvent.text = intent.getStringExtra("eventName")
        location.text = intent.getStringExtra("eventLocation")
        var dateTime = intent.getStringExtra("eventDate") + " at " +
                intent.getStringExtra("timeStart") +
                getString(R.string.dashLabel) +
                intent.getStringExtra("timeEnd")
        dateEvent.text = dateTime


        if (intent.getStringExtra("image") == null){
            image.setImageResource(intent.getIntExtra("image", R.drawable.event_picture))
        }else{
            image.setImageURI(Uri.parse(intent.getStringExtra("image")))
        }


    }

    private fun startCamera() {
        cameraProviderFuture?.addListener({
            try {
                val cameraProvider: ProcessCameraProvider = cameraProviderFuture!!.get()
                bindCameraPreview(cameraProvider)
            } catch (e: ExecutionException) {
                Toast.makeText(this, "Error starting camera ", Toast.LENGTH_SHORT).show()
            } catch (e: InterruptedException) {
                Toast.makeText(this, "Error starting camera ", Toast.LENGTH_SHORT).show()
            }
        }, ContextCompat.getMainExecutor(this))
    }

    private fun bindCameraPreview(cameraProvider : ProcessCameraProvider ) {
        viewFinder.preferredImplementationMode = PreviewView.ImplementationMode.SURFACE_VIEW;

        val preview = Preview.Builder()
            .build()

        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        preview.setSurfaceProvider(viewFinder.createSurfaceProvider());

        val imageAnalysis =
            ImageAnalysis.Builder()
            .setTargetResolution(Size(1280, 720))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()

        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this), QRCodeImageAnalyzer( QRCodeFoundListener{
                qrCode = it
                verifyCode(it)
        }))

        val camera = cameraProvider.bindToLifecycle(this, cameraSelector, imageAnalysis, preview);
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                Toast.makeText(
                    this,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it
        ) == PackageManager.PERMISSION_GRANTED
    }



    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val TAG = "CameraXBasic"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    fun finished(view: View){
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun enterCodeManually(view: View){
        val intent = Intent(this, VerificationCodeActivity::class.java)
        startActivityForResult(intent, code)
    }

    fun verifyCode(receivedCode :String ){
        if (receivedCode == "1574"){
            textStatus.text = getString(R.string.check_in_success)
            textStatus.setTextColor(getColor(R.color.quantum_googgreen))
            buttonScan.text = getString(R.string.scan_new)
        } else {
            textStatus.text = getString(R.string.check_in_fail)
            textStatus.setTextColor(getColor(R.color.red))
            buttonScan.text = getString(R.string.retype_code)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == code) if (data != null) {
            participantCode = data.getStringExtra("code").toString()
            verifyCode(participantCode)
        }
    }
}