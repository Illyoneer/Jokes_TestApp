package ru.glushko.testingjokeapp.presentation.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.glushko.testingjokeapp.databinding.FragmentWebBinding

class WebFragment : Fragment() {

    private lateinit var _webFBinding: FragmentWebBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _webFBinding = FragmentWebBinding.inflate(inflater, container, false)
        _webFBinding.webView.settings.javaScriptEnabled = true

        if(savedInstanceState != null){
            _webFBinding.webView.restoreState(savedInstanceState)
        } else {
            if(isOnline(requireContext()))
                _webFBinding.webView.loadUrl("https://www.icndb.com/api/")
            else
                Toast.makeText(context, "Проверьте интернет соединение!", Toast.LENGTH_SHORT).show()
        }

        return _webFBinding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        _webFBinding.webView.saveState(outState)
    }

    private fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}