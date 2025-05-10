package io.flutter.plugins.urllauncher;

import android.os.BaseBundle;
import android.webkit.WebView$WebViewTransport;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.view.View;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.BroadcastReceiver;
import android.app.Activity;

public class WebViewActivity extends Activity
{
    private final BroadcastReceiver e;
    private final WebViewClient f;
    WebView g;
    private final IntentFilter h;
    
    public WebViewActivity() {
        this.e = new BroadcastReceiver() {
            final WebViewActivity a;
            
            public void onReceive(final Context context, final Intent intent) {
                if ("close action".equals((Object)intent.getAction())) {
                    this.a.finish();
                }
            }
        };
        this.f = new WebViewClient() {
            final WebViewActivity a;
            
            public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
                webView.loadUrl(webResourceRequest.getUrl().toString());
                return false;
            }
            
            public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
                return super.shouldOverrideUrlLoading(webView, s);
            }
        };
        this.h = new IntentFilter("close action");
    }
    
    public static Intent a(final Context context, final String s, final boolean b, final boolean b2, final Bundle bundle) {
        return new Intent(context, (Class)WebViewActivity.class).putExtra("url", s).putExtra("enableJavaScript", b).putExtra("enableDomStorage", b2).putExtra("com.android.browser.headers", bundle);
    }
    
    public static Map<String, String> b(final Bundle bundle) {
        if (bundle == null) {
            return (Map<String, String>)Collections.emptyMap();
        }
        final HashMap hashMap = new HashMap();
        for (final String s : ((BaseBundle)bundle).keySet()) {
            ((Map)hashMap).put((Object)s, (Object)((BaseBundle)bundle).getString(s));
        }
        return (Map<String, String>)hashMap;
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView((View)(this.g = new WebView((Context)this)));
        final Intent intent = this.getIntent();
        final String stringExtra = intent.getStringExtra("url");
        final boolean booleanExtra = intent.getBooleanExtra("enableJavaScript", false);
        final boolean booleanExtra2 = intent.getBooleanExtra("enableDomStorage", false);
        this.g.loadUrl(stringExtra, (Map)b(intent.getBundleExtra("com.android.browser.headers")));
        this.g.getSettings().setJavaScriptEnabled(booleanExtra);
        this.g.getSettings().setDomStorageEnabled(booleanExtra2);
        this.g.setWebViewClient(this.f);
        this.g.getSettings().setSupportMultipleWindows(true);
        this.g.setWebChromeClient((WebChromeClient)new c());
        ((Context)this).registerReceiver(this.e, this.h);
    }
    
    protected void onDestroy() {
        super.onDestroy();
        ((Context)this).unregisterReceiver(this.e);
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.g.canGoBack()) {
            this.g.goBack();
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    class c extends WebChromeClient
    {
        final WebViewActivity a;
        
        c(final WebViewActivity a) {
            this.a = a;
        }
        
        public boolean onCreateWindow(final WebView webView, final boolean b, final boolean b2, final Message message) {
            final WebViewClient webViewClient = new WebViewClient(this) {
                final c a;
                
                public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
                    this.a.a.g.loadUrl(webResourceRequest.getUrl().toString());
                    return true;
                }
                
                public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
                    this.a.a.g.loadUrl(s);
                    return true;
                }
            };
            final WebView webView2 = new WebView(((View)this.a.g).getContext());
            webView2.setWebViewClient((WebViewClient)webViewClient);
            ((WebView$WebViewTransport)message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }
}
