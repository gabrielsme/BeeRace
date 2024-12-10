package com.example.beerace.ui.screens.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.beerace.ui.ScreenPreview

@Composable
fun WebViewScreen(
    loadUrl: String
) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                }
            }
        }
    }, update = {
        it.loadUrl(loadUrl)
    })
}

@Preview(showSystemUi = true)
@Composable
private fun WebViewScreenPreview() {
    ScreenPreview {
        WebViewScreen("https://www.google.com")
    }
}