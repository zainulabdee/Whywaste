package q;

import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;

public class b0
{
    public static final a$b A;
    public static final a$b B;
    public static final a$d C;
    public static final a$b D;
    public static final a$b E;
    public static final a$b F;
    public static final a$b G;
    public static final a$e H;
    public static final a$e I;
    public static final a$h J;
    public static final a$h K;
    public static final a$g L;
    public static final y$b M;
    public static final y$a N;
    public static final a$h O;
    public static final a$i P;
    public static final a$d Q;
    public static final a$d R;
    public static final a$d S;
    public static final a$h T;
    public static final a$d U;
    public static final a$d V;
    public static final a$d W;
    public static final a$d X;
    public static final a$d Y;
    public static final a$d Z;
    public static final a$b a;
    public static final a$d a0;
    public static final a$b b;
    public static final a$d b0;
    public static final a$e c;
    public static final a$c d;
    public static final a$f e;
    @Deprecated
    public static final a$f f;
    @Deprecated
    public static final a$f g;
    public static final a$f h;
    public static final a$f i;
    public static final a$f j;
    public static final a$c k;
    public static final a$c l;
    public static final a$c m;
    public static final a$c n;
    public static final a$c o;
    public static final a$c p;
    public static final a$b q;
    public static final a$b r;
    public static final a$c s;
    public static final a$f t;
    public static final a$c u;
    public static final a$b v;
    public static final a$b w;
    public static final a$f x;
    public static final a$f y;
    public static final a$f z;
    
    static {
        a = new a$b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
        b = new a$b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
        c = new a$e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
        d = new a$c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
        e = new a$f("START_SAFE_BROWSING", "START_SAFE_BROWSING");
        f = new a$f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
        g = new a$f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
        h = new a$f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
        i = new a$f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
        j = new a$f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
        k = new a$c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
        l = new a$c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
        m = new a$c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
        n = new a$c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
        o = new a$c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
        p = new a$c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
        q = new a$b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
        r = new a$b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
        s = new a$c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
        t = new a$f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
        u = new a$c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
        v = new a$b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        w = new a$b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
        x = new a$f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
        y = new a$f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
        z = new a$f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        A = new a$b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
        B = new a$b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
        C = new a$d("WEB_MESSAGE_GET_MESSAGE_PAYLOAD", "WEB_MESSAGE_GET_MESSAGE_PAYLOAD");
        D = new a$b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        E = new a$b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
        F = new a$b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
        G = new a$b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
        H = new a$e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
        I = new a$e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
        J = new a$h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
        K = new a$h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
        L = new a$g("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
        M = new y$b("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
        N = new y$a("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");
        O = new a$h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
        P = (a$i)new b0$a("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        Q = new a$d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
        R = new a$d("SUPPRESS_ERROR_PAGE", "SUPPRESS_ERROR_PAGE");
        S = new a$d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
        T = new a$h("FORCE_DARK", "FORCE_DARK");
        U = new a$d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
        V = new a$d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
        W = new a$d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
        X = new a$d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
        Y = new a$d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
        Z = new a$d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
        a0 = new a$d("GET_COOKIE_INFO", "GET_COOKIE_INFO");
        b0 = new a$d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
    }
    
    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }
    
    public static boolean b(final String s) {
        return c(s, (java.util.Collection<v>)q.a.e());
    }
    
    public static <T extends v> boolean c(final String s, final Collection<T> collection) {
        final HashSet set = new HashSet();
        for (final v v : collection) {
            if (v.a().equals((Object)s)) {
                ((Set)set).add((Object)v);
            }
        }
        if (!((Set)set).isEmpty()) {
            final Iterator iterator2 = ((Set)set).iterator();
            while (iterator2.hasNext()) {
                if (((v)iterator2.next()).b()) {
                    return true;
                }
            }
            return false;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown feature ");
        sb.append(s);
        throw new RuntimeException(sb.toString());
    }
}
