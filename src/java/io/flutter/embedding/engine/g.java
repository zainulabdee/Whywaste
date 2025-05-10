package io.flutter.embedding.engine;

import java.util.ArrayList;
import android.content.Intent;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g
{
    private Set<String> a;
    
    public g(final List<String> list) {
        this.a = (Set<String>)new HashSet((Collection)list);
    }
    
    public static g a(final Intent intent) {
        final ArrayList list = new ArrayList();
        if (intent.getBooleanExtra("trace-startup", false)) {
            list.add((Object)"--trace-startup");
        }
        if (intent.getBooleanExtra("start-paused", false)) {
            list.add((Object)"--start-paused");
        }
        final int intExtra = intent.getIntExtra("vm-service-port", 0);
        if (intExtra > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("--vm-service-port=");
            sb.append(Integer.toString(intExtra));
            list.add((Object)sb.toString());
        }
        else {
            final int intExtra2 = intent.getIntExtra("observatory-port", 0);
            if (intExtra2 > 0) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("--vm-service-port=");
                sb2.append(Integer.toString(intExtra2));
                list.add((Object)sb2.toString());
            }
        }
        if (intent.getBooleanExtra("disable-service-auth-codes", false)) {
            list.add((Object)"--disable-service-auth-codes");
        }
        if (intent.getBooleanExtra("endless-trace-buffer", false)) {
            list.add((Object)"--endless-trace-buffer");
        }
        if (intent.getBooleanExtra("use-test-fonts", false)) {
            list.add((Object)"--use-test-fonts");
        }
        if (intent.getBooleanExtra("enable-dart-profiling", false)) {
            list.add((Object)"--enable-dart-profiling");
        }
        if (intent.getBooleanExtra("enable-software-rendering", false)) {
            list.add((Object)"--enable-software-rendering");
        }
        if (intent.getBooleanExtra("skia-deterministic-rendering", false)) {
            list.add((Object)"--skia-deterministic-rendering");
        }
        if (intent.getBooleanExtra("trace-skia", false)) {
            list.add((Object)"--trace-skia");
        }
        final String stringExtra = intent.getStringExtra("trace-skia-allowlist");
        if (stringExtra != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("--trace-skia-allowlist=");
            sb3.append(stringExtra);
            list.add((Object)sb3.toString());
        }
        if (intent.getBooleanExtra("trace-systrace", false)) {
            list.add((Object)"--trace-systrace");
        }
        if (intent.getBooleanExtra("enable-impeller", false)) {
            list.add((Object)"--enable-impeller");
        }
        if (intent.getBooleanExtra("enable-vulkan-validation", false)) {
            list.add((Object)"--enable-vulkan-validation");
        }
        if (intent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
            list.add((Object)"--dump-skp-on-shader-compilation");
        }
        if (intent.getBooleanExtra("cache-sksl", false)) {
            list.add((Object)"--cache-sksl");
        }
        if (intent.getBooleanExtra("purge-persistent-cache", false)) {
            list.add((Object)"--purge-persistent-cache");
        }
        if (intent.getBooleanExtra("verbose-logging", false)) {
            list.add((Object)"--verbose-logging");
        }
        final int intExtra3 = intent.getIntExtra("msaa-samples", 0);
        if (intExtra3 > 1) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("--msaa-samples=");
            sb4.append(Integer.toString(intExtra3));
            list.add((Object)sb4.toString());
        }
        if (intent.hasExtra("dart-flags")) {
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("--dart-flags=");
            sb5.append(intent.getStringExtra("dart-flags"));
            list.add((Object)sb5.toString());
        }
        return new g((List<String>)list);
    }
    
    public String[] b() {
        return (String[])this.a.toArray((Object[])new String[this.a.size()]);
    }
}
