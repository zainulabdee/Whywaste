package io.sentry.android.core;

import io.sentry.protocol.o;
import io.sentry.q4;

public final class SentryAndroidOptions extends q4
{
    private boolean anrEnabled;
    private boolean anrReportInDebug;
    private long anrTimeoutIntervalMillis;
    private boolean attachAnrThreadDump;
    private boolean attachScreenshot;
    private boolean attachViewHierarchy;
    private SentryAndroidOptions.SentryAndroidOptions$a beforeScreenshotCaptureCallback;
    private SentryAndroidOptions.SentryAndroidOptions$a beforeViewHierarchyCaptureCallback;
    private boolean collectAdditionalContext;
    private t0 debugImagesLoader;
    private boolean enableActivityLifecycleBreadcrumbs;
    private boolean enableActivityLifecycleTracingAutoFinish;
    private boolean enableAppComponentBreadcrumbs;
    private boolean enableAppLifecycleBreadcrumbs;
    private boolean enableAutoActivityLifecycleTracing;
    private boolean enableFramesTracking;
    private boolean enableNetworkEventBreadcrumbs;
    private boolean enableRootCheck;
    private boolean enableSystemEventBreadcrumbs;
    private String nativeSdkName;
    private int profilingTracesHz;
    private boolean reportHistoricalAnrs;
    private final long startupCrashDurationThresholdMillis;
    private long startupCrashFlushTimeoutMillis;
    
    public SentryAndroidOptions() {
        this.anrEnabled = true;
        this.anrTimeoutIntervalMillis = 5000L;
        this.anrReportInDebug = false;
        this.enableActivityLifecycleBreadcrumbs = true;
        this.enableAppLifecycleBreadcrumbs = true;
        this.enableSystemEventBreadcrumbs = true;
        this.enableAppComponentBreadcrumbs = true;
        this.enableNetworkEventBreadcrumbs = true;
        this.enableAutoActivityLifecycleTracing = true;
        this.enableActivityLifecycleTracingAutoFinish = true;
        this.profilingTracesHz = 101;
        this.debugImagesLoader = (t0)a1.b();
        this.collectAdditionalContext = true;
        this.startupCrashFlushTimeoutMillis = 5000L;
        this.startupCrashDurationThresholdMillis = 2000L;
        this.enableFramesTracking = true;
        this.nativeSdkName = null;
        this.enableRootCheck = true;
        this.reportHistoricalAnrs = false;
        this.attachAnrThreadDump = false;
        this.setSentryClientName("sentry.java.android/6.25.2");
        this.setSdkVersion(this.createSdkVersion());
        this.setAttachServerName(false);
        this.setEnableScopeSync(true);
    }
    
    private o createSdkVersion() {
        final o l = o.l(this.getSdkVersion(), "sentry.java.android", "6.25.2");
        l.d("maven:io.sentry:sentry-android-core", "6.25.2");
        return l;
    }
    
    public void enableAllAutoBreadcrumbs(final boolean enableNetworkEventBreadcrumbs) {
        this.enableActivityLifecycleBreadcrumbs = enableNetworkEventBreadcrumbs;
        this.enableAppComponentBreadcrumbs = enableNetworkEventBreadcrumbs;
        this.enableSystemEventBreadcrumbs = enableNetworkEventBreadcrumbs;
        this.enableAppLifecycleBreadcrumbs = enableNetworkEventBreadcrumbs;
        this.setEnableUserInteractionBreadcrumbs(this.enableNetworkEventBreadcrumbs = enableNetworkEventBreadcrumbs);
    }
    
    public long getAnrTimeoutIntervalMillis() {
        return this.anrTimeoutIntervalMillis;
    }
    
    public SentryAndroidOptions.SentryAndroidOptions$a getBeforeScreenshotCaptureCallback() {
        return this.beforeScreenshotCaptureCallback;
    }
    
    public SentryAndroidOptions.SentryAndroidOptions$a getBeforeViewHierarchyCaptureCallback() {
        return this.beforeViewHierarchyCaptureCallback;
    }
    
    public t0 getDebugImagesLoader() {
        return this.debugImagesLoader;
    }
    
    public String getNativeSdkName() {
        return this.nativeSdkName;
    }
    
    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }
    
    @Deprecated
    public int getProfilingTracesIntervalMillis() {
        return 0;
    }
    
    public long getStartupCrashDurationThresholdMillis() {
        return 2000L;
    }
    
    long getStartupCrashFlushTimeoutMillis() {
        return this.startupCrashFlushTimeoutMillis;
    }
    
    public boolean isAnrEnabled() {
        return this.anrEnabled;
    }
    
    public boolean isAnrReportInDebug() {
        return this.anrReportInDebug;
    }
    
    public boolean isAttachAnrThreadDump() {
        return this.attachAnrThreadDump;
    }
    
    public boolean isAttachScreenshot() {
        return this.attachScreenshot;
    }
    
    public boolean isAttachViewHierarchy() {
        return this.attachViewHierarchy;
    }
    
    public boolean isCollectAdditionalContext() {
        return this.collectAdditionalContext;
    }
    
    public boolean isEnableActivityLifecycleBreadcrumbs() {
        return this.enableActivityLifecycleBreadcrumbs;
    }
    
    public boolean isEnableActivityLifecycleTracingAutoFinish() {
        return this.enableActivityLifecycleTracingAutoFinish;
    }
    
    public boolean isEnableAppComponentBreadcrumbs() {
        return this.enableAppComponentBreadcrumbs;
    }
    
    public boolean isEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }
    
    public boolean isEnableAutoActivityLifecycleTracing() {
        return this.enableAutoActivityLifecycleTracing;
    }
    
    public boolean isEnableFramesTracking() {
        return this.enableFramesTracking;
    }
    
    public boolean isEnableNetworkEventBreadcrumbs() {
        return this.enableNetworkEventBreadcrumbs;
    }
    
    public boolean isEnableRootCheck() {
        return this.enableRootCheck;
    }
    
    public boolean isEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }
    
    public boolean isReportHistoricalAnrs() {
        return this.reportHistoricalAnrs;
    }
    
    public void setAnrEnabled(final boolean anrEnabled) {
        this.anrEnabled = anrEnabled;
    }
    
    public void setAnrReportInDebug(final boolean anrReportInDebug) {
        this.anrReportInDebug = anrReportInDebug;
    }
    
    public void setAnrTimeoutIntervalMillis(final long anrTimeoutIntervalMillis) {
        this.anrTimeoutIntervalMillis = anrTimeoutIntervalMillis;
    }
    
    public void setAttachAnrThreadDump(final boolean attachAnrThreadDump) {
        this.attachAnrThreadDump = attachAnrThreadDump;
    }
    
    public void setAttachScreenshot(final boolean attachScreenshot) {
        this.attachScreenshot = attachScreenshot;
    }
    
    public void setAttachViewHierarchy(final boolean attachViewHierarchy) {
        this.attachViewHierarchy = attachViewHierarchy;
    }
    
    public void setBeforeScreenshotCaptureCallback(final SentryAndroidOptions.SentryAndroidOptions$a beforeScreenshotCaptureCallback) {
        this.beforeScreenshotCaptureCallback = beforeScreenshotCaptureCallback;
    }
    
    public void setBeforeViewHierarchyCaptureCallback(final SentryAndroidOptions.SentryAndroidOptions$a beforeViewHierarchyCaptureCallback) {
        this.beforeViewHierarchyCaptureCallback = beforeViewHierarchyCaptureCallback;
    }
    
    public void setCollectAdditionalContext(final boolean collectAdditionalContext) {
        this.collectAdditionalContext = collectAdditionalContext;
    }
    
    public void setDebugImagesLoader(t0 b) {
        if (b == null) {
            b = (t0)a1.b();
        }
        this.debugImagesLoader = b;
    }
    
    public void setEnableActivityLifecycleBreadcrumbs(final boolean enableActivityLifecycleBreadcrumbs) {
        this.enableActivityLifecycleBreadcrumbs = enableActivityLifecycleBreadcrumbs;
    }
    
    public void setEnableActivityLifecycleTracingAutoFinish(final boolean enableActivityLifecycleTracingAutoFinish) {
        this.enableActivityLifecycleTracingAutoFinish = enableActivityLifecycleTracingAutoFinish;
    }
    
    public void setEnableAppComponentBreadcrumbs(final boolean enableAppComponentBreadcrumbs) {
        this.enableAppComponentBreadcrumbs = enableAppComponentBreadcrumbs;
    }
    
    public void setEnableAppLifecycleBreadcrumbs(final boolean enableAppLifecycleBreadcrumbs) {
        this.enableAppLifecycleBreadcrumbs = enableAppLifecycleBreadcrumbs;
    }
    
    public void setEnableAutoActivityLifecycleTracing(final boolean enableAutoActivityLifecycleTracing) {
        this.enableAutoActivityLifecycleTracing = enableAutoActivityLifecycleTracing;
    }
    
    public void setEnableFramesTracking(final boolean enableFramesTracking) {
        this.enableFramesTracking = enableFramesTracking;
    }
    
    public void setEnableNetworkEventBreadcrumbs(final boolean enableNetworkEventBreadcrumbs) {
        this.enableNetworkEventBreadcrumbs = enableNetworkEventBreadcrumbs;
    }
    
    public void setEnableRootCheck(final boolean enableRootCheck) {
        this.enableRootCheck = enableRootCheck;
    }
    
    public void setEnableSystemEventBreadcrumbs(final boolean enableSystemEventBreadcrumbs) {
        this.enableSystemEventBreadcrumbs = enableSystemEventBreadcrumbs;
    }
    
    public void setNativeSdkName(final String nativeSdkName) {
        this.nativeSdkName = nativeSdkName;
    }
    
    public void setProfilingTracesHz(final int profilingTracesHz) {
        this.profilingTracesHz = profilingTracesHz;
    }
    
    @Deprecated
    public void setProfilingTracesIntervalMillis(final int n) {
    }
    
    public void setReportHistoricalAnrs(final boolean reportHistoricalAnrs) {
        this.reportHistoricalAnrs = reportHistoricalAnrs;
    }
    
    void setStartupCrashFlushTimeoutMillis(final long startupCrashFlushTimeoutMillis) {
        this.startupCrashFlushTimeoutMillis = startupCrashFlushTimeoutMillis;
    }
}
