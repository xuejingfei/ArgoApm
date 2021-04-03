package com.xjf.argo

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import java.io.File
import java.io.FileOutputStream

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            write()
        }
    }

    private fun write() {
        val sdkPath = Environment.getDataDirectory().absolutePath
        val saveFile = File(sdkPath, "aaaa.txt")
        if(!saveFile.exists()) {
            saveFile.createNewFile()
        }
        val  outStream =  FileOutputStream(saveFile)
        outStream.write("json数据".toByteArray())
        outStream.close()
    }
}

