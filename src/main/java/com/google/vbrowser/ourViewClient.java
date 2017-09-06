package com.google.vbrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Ideapad on 17-06-2017.
 */

class ourViewClient extends WebViewClient {

    @SuppressWarnings("deprecetion")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
