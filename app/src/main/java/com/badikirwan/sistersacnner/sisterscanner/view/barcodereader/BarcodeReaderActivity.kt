package com.badikirwan.sistersacnner.sisterscanner.view.barcodereader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.badikirwan.sistersacnner.sisterscanner.adapter.BarcodeAdapter
import com.badikirwan.sistersacnner.sisterscanner.model.Data
import com.google.firebase.FirebaseApp
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.otaliastudios.cameraview.CameraListener
import kotlinx.android.synthetic.main.activity_base_camera.*

class BarcodeReaderActivity : BaseCameraActivity(),
    BarcodeReaderView {

    private val datas: MutableList<Data> = mutableListOf()
    private lateinit var presenter: BarcodeReaderPresenter
    private lateinit var adapter: BarcodeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_barcode_reader)
        FirebaseApp.initializeApp(this)
        presenter = BarcodeReaderPresenter(this)
        rv_data.layoutManager = LinearLayoutManager(this)
        adapter = BarcodeAdapter(datas)
        rv_data.adapter = adapter

        cameraView.addCameraListener(object : CameraListener() {

            override fun onPictureTaken(jpeg: ByteArray?) {
                val bitmap = jpeg?.size?.let { BitmapFactory.decodeByteArray(jpeg,0, it) }
                bitmap?.let { getBarCodeDetails(it) }
                showPreview()
                imagePreview.setImageBitmap(bitmap)
            }
        })
    }

    override fun onClick(v: View?) {
        fabProgressCircel.show()
        cameraView.captureSnapshot()
    }

    private fun getBarCodeDetails(bitmap: Bitmap) {
        val image = FirebaseVisionImage.fromBitmap(bitmap)
        val options = FirebaseVisionBarcodeDetectorOptions.Builder()
            .setBarcodeFormats(FirebaseVisionBarcode.FORMAT_ALL_FORMATS)
            .build()
        val detector =  FirebaseVision.getInstance().getVisionBarcodeDetector(options)

        detector.detectInImage(image)
            .addOnSuccessListener {
                for (firebaseBarcode in it) {
                    presenter.getDataMahasiswa(firebaseBarcode.displayValue.toString())
                }
            }
            .addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(baseContext, "Sorry, something went wrong!", Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                fabProgressCircel.hide()
            }
    }

    override fun showDataMahasiswa(data: Data) {
        datas.clear()
        datas.addAll(listOf(data))
        adapter.notifyDataSetChanged()
    }
}
