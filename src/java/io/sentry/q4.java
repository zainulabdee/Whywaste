package io.sentry;

import io.sentry.clientreport.i;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;
import java.util.Map$Entry;
import java.util.HashMap;
import java.io.File;
import io.sentry.util.p;
import java.util.ArrayList;
import io.sentry.internal.modules.e;
import io.sentry.clientreport.d;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.transport.t;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CopyOnWriteArrayList;
import io.sentry.transport.q;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import io.sentry.protocol.o;
import io.sentry.util.thread.b;
import javax.net.ssl.HostnameVerifier;
import io.sentry.cache.f;
import io.sentry.internal.debugmeta.a;
import java.util.List;
import io.sentry.clientreport.g;
import java.util.Set;

public class q4
{
    static final l4 DEFAULT_DIAGNOSTIC_LEVEL;
    private static final String DEFAULT_ENVIRONMENT = "production";
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;
    private a beforeBreadcrumb;
    private b beforeSend;
    private c beforeSendTransaction;
    private final Set<String> bundleIds;
    private String cacheDirPath;
    io.sentry.clientreport.g clientReportRecorder;
    private final List<i0> collectors;
    private int connectionTimeoutMillis;
    private final List<String> contextTags;
    private k3 dateProvider;
    private boolean debug;
    private io.sentry.internal.debugmeta.a debugMetaLoader;
    private final List<String> defaultTracePropagationTargets;
    private l4 diagnosticLevel;
    private String dist;
    private String distinctId;
    private String dsn;
    private String dsnHash;
    private boolean enableAutoSessionTracking;
    private boolean enableDeduplication;
    private boolean enableExternalConfiguration;
    private boolean enableNdk;
    private boolean enableScopeSync;
    private boolean enableShutdownHook;
    private boolean enableTimeToFullDisplayTracing;
    private Boolean enableTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private io.sentry.cache.f envelopeDiskCache;
    private j0 envelopeReader;
    private String environment;
    private final List<x> eventProcessors;
    private s0 executorService;
    private long flushTimeoutMillis;
    private final z fullyDisplayedReporter;
    private final List<io.sentry.internal.gestures.a> gestureTargetLocators;
    private HostnameVerifier hostnameVerifier;
    private Long idleTimeout;
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;
    private y0 instrumenter;
    private final List<Integration> integrations;
    private n0 logger;
    private io.sentry.util.thread.b mainThreadChecker;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;
    private f maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;
    private io.sentry.internal.modules.b modulesLoader;
    private final List<q0> observers;
    private final List<o0> optionsObservers;
    private boolean printUncaughtStackTrace;
    private Double profilesSampleRate;
    private d profilesSampler;
    private String proguardUuid;
    private e proxy;
    private int readTimeoutMillis;
    private String release;
    private Double sampleRate;
    private o sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private String sentryClientName;
    private t0 serializer;
    private String serverName;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;
    private SSLSocketFactory sslSocketFactory;
    private final Map<String, String> tags;
    private boolean traceOptionsRequests;
    private List<String> tracePropagationTargets;
    private boolean traceSampling;
    private Double tracesSampleRate;
    private g tracesSampler;
    private s5 transactionPerformanceCollector;
    private w0 transactionProfiler;
    private x0 transportFactory;
    private q transportGate;
    private final List<io.sentry.internal.viewhierarchy.a> viewHierarchyExporters;
    
    static {
        DEFAULT_DIAGNOSTIC_LEVEL = l4.DEBUG;
    }
    
    public q4() {
        this(false);
    }
    
    private q4(final boolean b) {
        final CopyOnWriteArrayList eventProcessors = new CopyOnWriteArrayList();
        this.eventProcessors = (List<x>)eventProcessors;
        this.ignoredExceptionsForType = (Set<Class<? extends Throwable>>)new CopyOnWriteArraySet();
        final CopyOnWriteArrayList integrations = new CopyOnWriteArrayList();
        this.integrations = (List<Integration>)integrations;
        this.bundleIds = (Set<String>)new CopyOnWriteArraySet();
        this.shutdownTimeoutMillis = 2000L;
        this.flushTimeoutMillis = 15000L;
        this.enableNdk = true;
        this.logger = (n0)u1.e();
        this.diagnosticLevel = q4.DEFAULT_DIAGNOSTIC_LEVEL;
        this.envelopeReader = (j0)new r((t0)new n1(this));
        this.serializer = (t0)new n1(this);
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = (List<String>)new CopyOnWriteArrayList();
        this.inAppIncludes = (List<String>)new CopyOnWriteArrayList();
        this.transportFactory = (x0)d2.b();
        this.transportGate = (q)t.b();
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000L;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = x1.e();
        this.connectionTimeoutMillis = 5000;
        this.readTimeoutMillis = 5000;
        this.envelopeDiskCache = (io.sentry.cache.f)io.sentry.transport.r.h();
        this.sendDefaultPii = false;
        this.observers = (List<q0>)new CopyOnWriteArrayList();
        this.optionsObservers = (List<o0>)new CopyOnWriteArrayList();
        this.tags = (Map<String, String>)new ConcurrentHashMap();
        this.maxAttachmentSize = 20971520L;
        this.enableDeduplication = true;
        this.maxSpans = 1000;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = f.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = 5242880L;
        this.transactionProfiler = (w0)c2.c();
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = (List<String>)Collections.singletonList((Object)".*");
        this.idleTimeout = 3000L;
        this.contextTags = (List<String>)new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = (io.sentry.clientreport.g)new io.sentry.clientreport.d(this);
        this.modulesLoader = (io.sentry.internal.modules.b)io.sentry.internal.modules.e.b();
        this.debugMetaLoader = (io.sentry.internal.debugmeta.a)io.sentry.internal.debugmeta.b.b();
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = y0.SENTRY;
        this.gestureTargetLocators = (List<io.sentry.internal.gestures.a>)new ArrayList();
        this.viewHierarchyExporters = (List<io.sentry.internal.viewhierarchy.a>)new ArrayList();
        this.mainThreadChecker = (io.sentry.util.thread.b)io.sentry.util.thread.d.d();
        this.traceOptionsRequests = true;
        this.dateProvider = (k3)new d3();
        this.collectors = (List<i0>)new ArrayList();
        this.transactionPerformanceCollector = (s5)b2.c();
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = z.a();
        if (!b) {
            this.executorService = (s0)new g4();
            ((List)integrations).add((Object)new UncaughtExceptionHandlerIntegration());
            ((List)integrations).add((Object)new ShutdownHookIntegration());
            ((List)eventProcessors).add((Object)new o1(this));
            ((List)eventProcessors).add((Object)new io.sentry.q(this));
            if (p.b()) {
                ((List)eventProcessors).add((Object)new r4());
            }
            this.setSentryClientName("sentry.java/6.25.2");
            this.setSdkVersion(this.createSdkVersion());
            this.addPackageInfo();
        }
    }
    
    private void addPackageInfo() {
        j4.c().b("maven:io.sentry:sentry", "6.25.2");
    }
    
    private o createSdkVersion() {
        final o o = new o("sentry.java", "6.25.2");
        o.k("6.25.2");
        return o;
    }
    
    static q4 empty() {
        return new q4(true);
    }
    
    public void addBundleId(String trim) {
        if (trim != null) {
            trim = trim.trim();
            if (!trim.isEmpty()) {
                this.bundleIds.add((Object)trim);
            }
        }
    }
    
    public void addCollector(final i0 i0) {
        this.collectors.add((Object)i0);
    }
    
    public void addContextTag(final String s) {
        this.contextTags.add((Object)s);
    }
    
    public void addEventProcessor(final x x) {
        this.eventProcessors.add((Object)x);
    }
    
    public void addIgnoredExceptionForType(final Class<? extends Throwable> clazz) {
        this.ignoredExceptionsForType.add((Object)clazz);
    }
    
    public void addInAppExclude(final String s) {
        this.inAppExcludes.add((Object)s);
    }
    
    public void addInAppInclude(final String s) {
        this.inAppIncludes.add((Object)s);
    }
    
    public void addIntegration(final Integration integration) {
        this.integrations.add((Object)integration);
    }
    
    public void addOptionsObserver(final o0 o0) {
        this.optionsObservers.add((Object)o0);
    }
    
    public void addScopeObserver(final q0 q0) {
        this.observers.add((Object)q0);
    }
    
    @Deprecated
    public void addTracingOrigin(final String s) {
        if (this.tracePropagationTargets == null) {
            this.tracePropagationTargets = (List<String>)new CopyOnWriteArrayList();
        }
        if (!s.isEmpty()) {
            this.tracePropagationTargets.add((Object)s);
        }
    }
    
    boolean containsIgnoredExceptionForType(final Throwable t) {
        return this.ignoredExceptionsForType.contains((Object)t.getClass());
    }
    
    public a getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }
    
    public b getBeforeSend() {
        return this.beforeSend;
    }
    
    public c getBeforeSendTransaction() {
        return this.beforeSendTransaction;
    }
    
    public Set<String> getBundleIds() {
        return this.bundleIds;
    }
    
    public String getCacheDirPath() {
        final String cacheDirPath = this.cacheDirPath;
        if (cacheDirPath != null && !cacheDirPath.isEmpty()) {
            String s;
            if (this.dsnHash != null) {
                s = new File(this.cacheDirPath, this.dsnHash).getAbsolutePath();
            }
            else {
                s = this.cacheDirPath;
            }
            return s;
        }
        return null;
    }
    
    public io.sentry.clientreport.g getClientReportRecorder() {
        return this.clientReportRecorder;
    }
    
    public List<i0> getCollectors() {
        return this.collectors;
    }
    
    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }
    
    public List<String> getContextTags() {
        return this.contextTags;
    }
    
    public k3 getDateProvider() {
        return this.dateProvider;
    }
    
    public io.sentry.internal.debugmeta.a getDebugMetaLoader() {
        return this.debugMetaLoader;
    }
    
    public l4 getDiagnosticLevel() {
        return this.diagnosticLevel;
    }
    
    public String getDist() {
        return this.dist;
    }
    
    public String getDistinctId() {
        return this.distinctId;
    }
    
    public String getDsn() {
        return this.dsn;
    }
    
    public Boolean getEnableTracing() {
        return this.enableTracing;
    }
    
    public io.sentry.cache.f getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }
    
    public j0 getEnvelopeReader() {
        return this.envelopeReader;
    }
    
    public String getEnvironment() {
        String environment = this.environment;
        if (environment == null) {
            environment = "production";
        }
        return environment;
    }
    
    public List<x> getEventProcessors() {
        return this.eventProcessors;
    }
    
    public s0 getExecutorService() {
        return this.executorService;
    }
    
    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }
    
    public z getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }
    
    public List<io.sentry.internal.gestures.a> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }
    
    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }
    
    public Long getIdleTimeout() {
        return this.idleTimeout;
    }
    
    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }
    
    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }
    
    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }
    
    public y0 getInstrumenter() {
        return this.instrumenter;
    }
    
    public List<Integration> getIntegrations() {
        return this.integrations;
    }
    
    public n0 getLogger() {
        return this.logger;
    }
    
    public io.sentry.util.thread.b getMainThreadChecker() {
        return this.mainThreadChecker;
    }
    
    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }
    
    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }
    
    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }
    
    public int getMaxDepth() {
        return this.maxDepth;
    }
    
    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }
    
    public f getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }
    
    public int getMaxSpans() {
        return this.maxSpans;
    }
    
    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }
    
    public io.sentry.internal.modules.b getModulesLoader() {
        return this.modulesLoader;
    }
    
    public List<o0> getOptionsObservers() {
        return this.optionsObservers;
    }
    
    public String getOutboxPath() {
        final String cacheDirPath = this.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "outbox").getAbsolutePath();
    }
    
    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }
    
    public d getProfilesSampler() {
        return this.profilesSampler;
    }
    
    public String getProfilingTracesDirPath() {
        final String cacheDirPath = this.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "profiling_traces").getAbsolutePath();
    }
    
    public String getProguardUuid() {
        return this.proguardUuid;
    }
    
    public e getProxy() {
        return this.proxy;
    }
    
    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }
    
    public String getRelease() {
        return this.release;
    }
    
    public Double getSampleRate() {
        return this.sampleRate;
    }
    
    public List<q0> getScopeObservers() {
        return this.observers;
    }
    
    public o getSdkVersion() {
        return this.sdkVersion;
    }
    
    public String getSentryClientName() {
        return this.sentryClientName;
    }
    
    public t0 getSerializer() {
        return this.serializer;
    }
    
    public String getServerName() {
        return this.serverName;
    }
    
    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }
    
    @Deprecated
    public long getShutdownTimeout() {
        return this.shutdownTimeoutMillis;
    }
    
    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }
    
    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }
    
    public Map<String, String> getTags() {
        return this.tags;
    }
    
    public List<String> getTracePropagationTargets() {
        List<String> list;
        if ((list = this.tracePropagationTargets) == null) {
            list = this.defaultTracePropagationTargets;
        }
        return list;
    }
    
    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }
    
    public g getTracesSampler() {
        return this.tracesSampler;
    }
    
    @Deprecated
    public List<String> getTracingOrigins() {
        return this.getTracePropagationTargets();
    }
    
    public s5 getTransactionPerformanceCollector() {
        return this.transactionPerformanceCollector;
    }
    
    public w0 getTransactionProfiler() {
        return this.transactionProfiler;
    }
    
    public x0 getTransportFactory() {
        return this.transportFactory;
    }
    
    public q getTransportGate() {
        return this.transportGate;
    }
    
    public final List<io.sentry.internal.viewhierarchy.a> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }
    
    public boolean isAttachServerName() {
        return this.attachServerName;
    }
    
    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }
    
    public boolean isAttachThreads() {
        return this.attachThreads;
    }
    
    public boolean isDebug() {
        return this.debug;
    }
    
    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }
    
    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }
    
    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }
    
    public boolean isEnableNdk() {
        return this.enableNdk;
    }
    
    public boolean isEnableScopeSync() {
        return this.enableScopeSync;
    }
    
    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }
    
    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }
    
    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }
    
    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }
    
    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }
    
    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }
    
    public boolean isProfilingEnabled() {
        return (this.getProfilesSampleRate() != null && this.getProfilesSampleRate() > 0.0) || this.getProfilesSampler() != null;
    }
    
    public boolean isSendClientReports() {
        return this.sendClientReports;
    }
    
    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }
    
    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }
    
    public boolean isTraceSampling() {
        return this.traceSampling;
    }
    
    public boolean isTracingEnabled() {
        final Boolean enableTracing = this.enableTracing;
        if (enableTracing != null) {
            return enableTracing;
        }
        return this.getTracesSampleRate() != null || this.getTracesSampler() != null;
    }
    
    public void merge(final y y) {
        if (y.l() != null) {
            this.setDsn(y.l());
        }
        if (y.p() != null) {
            this.setEnvironment(y.p());
        }
        if (y.y() != null) {
            this.setRelease(y.y());
        }
        if (y.k() != null) {
            this.setDist(y.k());
        }
        if (y.A() != null) {
            this.setServerName(y.A());
        }
        if (y.x() != null) {
            this.setProxy(y.x());
        }
        if (y.o() != null) {
            this.setEnableUncaughtExceptionHandler(y.o());
        }
        if (y.u() != null) {
            this.setPrintUncaughtStackTrace(y.u());
        }
        if (y.n() != null) {
            this.setEnableTracing(y.n());
        }
        if (y.D() != null) {
            this.setTracesSampleRate(y.D());
        }
        if (y.v() != null) {
            this.setProfilesSampleRate(y.v());
        }
        if (y.j() != null) {
            this.setDebug(y.j());
        }
        if (y.m() != null) {
            this.setEnableDeduplication(y.m());
        }
        if (y.z() != null) {
            this.setSendClientReports(y.z());
        }
        for (final Map$Entry map$Entry : ((Map)new HashMap((Map)y.B())).entrySet()) {
            this.tags.put((Object)map$Entry.getKey(), (Object)map$Entry.getValue());
        }
        final Iterator iterator2 = ((List)new ArrayList((Collection)y.t())).iterator();
        while (iterator2.hasNext()) {
            this.addInAppInclude((String)iterator2.next());
        }
        final Iterator iterator3 = ((List)new ArrayList((Collection)y.s())).iterator();
        while (iterator3.hasNext()) {
            this.addInAppExclude((String)iterator3.next());
        }
        final Iterator iterator4 = new HashSet((Collection)y.r()).iterator();
        while (iterator4.hasNext()) {
            this.addIgnoredExceptionForType((Class<? extends Throwable>)iterator4.next());
        }
        if (y.C() != null) {
            this.setTracePropagationTargets((List<String>)new ArrayList((Collection)y.C()));
        }
        final Iterator iterator5 = ((List)new ArrayList((Collection)y.i())).iterator();
        while (iterator5.hasNext()) {
            this.addContextTag((String)iterator5.next());
        }
        if (y.w() != null) {
            this.setProguardUuid(y.w());
        }
        if (y.q() != null) {
            this.setIdleTimeout(y.q());
        }
        final Iterator iterator6 = y.h().iterator();
        while (iterator6.hasNext()) {
            this.addBundleId((String)iterator6.next());
        }
    }
    
    public void setAttachServerName(final boolean attachServerName) {
        this.attachServerName = attachServerName;
    }
    
    public void setAttachStacktrace(final boolean attachStacktrace) {
        this.attachStacktrace = attachStacktrace;
    }
    
    public void setAttachThreads(final boolean attachThreads) {
        this.attachThreads = attachThreads;
    }
    
    public void setBeforeBreadcrumb(final a beforeBreadcrumb) {
        this.beforeBreadcrumb = beforeBreadcrumb;
    }
    
    public void setBeforeSend(final b beforeSend) {
        this.beforeSend = beforeSend;
    }
    
    public void setBeforeSendTransaction(final c beforeSendTransaction) {
        this.beforeSendTransaction = beforeSendTransaction;
    }
    
    public void setCacheDirPath(final String cacheDirPath) {
        this.cacheDirPath = cacheDirPath;
    }
    
    public void setConnectionTimeoutMillis(final int connectionTimeoutMillis) {
        this.connectionTimeoutMillis = connectionTimeoutMillis;
    }
    
    public void setDateProvider(final k3 dateProvider) {
        this.dateProvider = dateProvider;
    }
    
    public void setDebug(final boolean debug) {
        this.debug = debug;
    }
    
    public void setDebugMetaLoader(io.sentry.internal.debugmeta.a b) {
        if (b == null) {
            b = (io.sentry.internal.debugmeta.a)io.sentry.internal.debugmeta.b.b();
        }
        this.debugMetaLoader = b;
    }
    
    public void setDiagnosticLevel(l4 default_DIAGNOSTIC_LEVEL) {
        if (default_DIAGNOSTIC_LEVEL == null) {
            default_DIAGNOSTIC_LEVEL = q4.DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = default_DIAGNOSTIC_LEVEL;
    }
    
    public void setDist(final String dist) {
        this.dist = dist;
    }
    
    public void setDistinctId(final String distinctId) {
        this.distinctId = distinctId;
    }
    
    public void setDsn(final String dsn) {
        this.dsn = dsn;
        this.dsnHash = io.sentry.util.r.a(dsn, this.logger);
    }
    
    public void setEnableAutoSessionTracking(final boolean enableAutoSessionTracking) {
        this.enableAutoSessionTracking = enableAutoSessionTracking;
    }
    
    public void setEnableDeduplication(final boolean enableDeduplication) {
        this.enableDeduplication = enableDeduplication;
    }
    
    public void setEnableExternalConfiguration(final boolean enableExternalConfiguration) {
        this.enableExternalConfiguration = enableExternalConfiguration;
    }
    
    public void setEnableNdk(final boolean enableNdk) {
        this.enableNdk = enableNdk;
    }
    
    public void setEnableScopeSync(final boolean enableScopeSync) {
        this.enableScopeSync = enableScopeSync;
    }
    
    public void setEnableShutdownHook(final boolean enableShutdownHook) {
        this.enableShutdownHook = enableShutdownHook;
    }
    
    public void setEnableTimeToFullDisplayTracing(final boolean enableTimeToFullDisplayTracing) {
        this.enableTimeToFullDisplayTracing = enableTimeToFullDisplayTracing;
    }
    
    public void setEnableTracing(final Boolean enableTracing) {
        this.enableTracing = enableTracing;
    }
    
    public void setEnableUncaughtExceptionHandler(final boolean enableUncaughtExceptionHandler) {
        this.enableUncaughtExceptionHandler = enableUncaughtExceptionHandler;
    }
    
    public void setEnableUserInteractionBreadcrumbs(final boolean enableUserInteractionBreadcrumbs) {
        this.enableUserInteractionBreadcrumbs = enableUserInteractionBreadcrumbs;
    }
    
    public void setEnableUserInteractionTracing(final boolean enableUserInteractionTracing) {
        this.enableUserInteractionTracing = enableUserInteractionTracing;
    }
    
    public void setEnvelopeDiskCache(io.sentry.cache.f h) {
        if (h == null) {
            h = (io.sentry.cache.f)io.sentry.transport.r.h();
        }
        this.envelopeDiskCache = h;
    }
    
    public void setEnvelopeReader(j0 b) {
        if (b == null) {
            b = (j0)s1.b();
        }
        this.envelopeReader = b;
    }
    
    public void setEnvironment(final String environment) {
        this.environment = environment;
    }
    
    public void setExecutorService(final s0 executorService) {
        if (executorService != null) {
            this.executorService = executorService;
        }
    }
    
    public void setFlushTimeoutMillis(final long flushTimeoutMillis) {
        this.flushTimeoutMillis = flushTimeoutMillis;
    }
    
    public void setGestureTargetLocators(final List<io.sentry.internal.gestures.a> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll((Collection)list);
    }
    
    public void setHostnameVerifier(final HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }
    
    public void setIdleTimeout(final Long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }
    
    public void setInstrumenter(final y0 instrumenter) {
        this.instrumenter = instrumenter;
    }
    
    public void setLogger(final n0 n0) {
        Object e;
        if (n0 == null) {
            e = u1.e();
        }
        else {
            e = new m(this, n0);
        }
        this.logger = (n0)e;
    }
    
    public void setMainThreadChecker(final io.sentry.util.thread.b mainThreadChecker) {
        this.mainThreadChecker = mainThreadChecker;
    }
    
    public void setMaxAttachmentSize(final long maxAttachmentSize) {
        this.maxAttachmentSize = maxAttachmentSize;
    }
    
    public void setMaxBreadcrumbs(final int maxBreadcrumbs) {
        this.maxBreadcrumbs = maxBreadcrumbs;
    }
    
    public void setMaxCacheItems(final int maxCacheItems) {
        this.maxCacheItems = maxCacheItems;
    }
    
    public void setMaxDepth(final int maxDepth) {
        this.maxDepth = maxDepth;
    }
    
    public void setMaxQueueSize(final int maxQueueSize) {
        if (maxQueueSize > 0) {
            this.maxQueueSize = maxQueueSize;
        }
    }
    
    public void setMaxRequestBodySize(final f maxRequestBodySize) {
        this.maxRequestBodySize = maxRequestBodySize;
    }
    
    public void setMaxSpans(final int maxSpans) {
        this.maxSpans = maxSpans;
    }
    
    public void setMaxTraceFileSize(final long maxTraceFileSize) {
        this.maxTraceFileSize = maxTraceFileSize;
    }
    
    public void setModulesLoader(io.sentry.internal.modules.b b) {
        if (b == null) {
            b = (io.sentry.internal.modules.b)io.sentry.internal.modules.e.b();
        }
        this.modulesLoader = b;
    }
    
    public void setPrintUncaughtStackTrace(final boolean printUncaughtStackTrace) {
        this.printUncaughtStackTrace = printUncaughtStackTrace;
    }
    
    public void setProfilesSampleRate(final Double profilesSampleRate) {
        if (io.sentry.util.q.a(profilesSampleRate)) {
            this.profilesSampleRate = profilesSampleRate;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("The value ");
        sb.append((Object)profilesSampleRate);
        sb.append(" is not valid. Use null to disable or values between 0.0 and 1.0.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void setProfilesSampler(final d profilesSampler) {
        this.profilesSampler = profilesSampler;
    }
    
    @Deprecated
    public void setProfilingEnabled(final boolean b) {
        if (this.getProfilesSampleRate() == null) {
            Double value;
            if (b) {
                value = 1.0;
            }
            else {
                value = null;
            }
            this.setProfilesSampleRate(value);
        }
    }
    
    public void setProguardUuid(final String proguardUuid) {
        this.proguardUuid = proguardUuid;
    }
    
    public void setProxy(final e proxy) {
        this.proxy = proxy;
    }
    
    public void setReadTimeoutMillis(final int readTimeoutMillis) {
        this.readTimeoutMillis = readTimeoutMillis;
    }
    
    public void setRelease(final String release) {
        this.release = release;
    }
    
    public void setSampleRate(final Double sampleRate) {
        if (io.sentry.util.q.c(sampleRate)) {
            this.sampleRate = sampleRate;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("The value ");
        sb.append((Object)sampleRate);
        sb.append(" is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void setSdkVersion(final o sdkVersion) {
        this.sdkVersion = sdkVersion;
    }
    
    public void setSendClientReports(final boolean sendClientReports) {
        this.sendClientReports = sendClientReports;
        if (sendClientReports) {
            this.clientReportRecorder = (io.sentry.clientreport.g)new io.sentry.clientreport.d(this);
        }
        else {
            this.clientReportRecorder = (io.sentry.clientreport.g)new i();
        }
    }
    
    public void setSendDefaultPii(final boolean sendDefaultPii) {
        this.sendDefaultPii = sendDefaultPii;
    }
    
    public void setSentryClientName(final String sentryClientName) {
        this.sentryClientName = sentryClientName;
    }
    
    public void setSerializer(t0 g) {
        if (g == null) {
            g = (t0)y1.g();
        }
        this.serializer = g;
    }
    
    public void setServerName(final String serverName) {
        this.serverName = serverName;
    }
    
    public void setSessionTrackingIntervalMillis(final long sessionTrackingIntervalMillis) {
        this.sessionTrackingIntervalMillis = sessionTrackingIntervalMillis;
    }
    
    @Deprecated
    public void setShutdownTimeout(final long shutdownTimeoutMillis) {
        this.shutdownTimeoutMillis = shutdownTimeoutMillis;
    }
    
    public void setShutdownTimeoutMillis(final long shutdownTimeoutMillis) {
        this.shutdownTimeoutMillis = shutdownTimeoutMillis;
    }
    
    public void setSslSocketFactory(final SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }
    
    public void setTag(final String s, final String s2) {
        this.tags.put((Object)s, (Object)s2);
    }
    
    public void setTraceOptionsRequests(final boolean traceOptionsRequests) {
        this.traceOptionsRequests = traceOptionsRequests;
    }
    
    public void setTracePropagationTargets(final List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
        }
        else {
            final ArrayList tracePropagationTargets = new ArrayList();
            for (final String s : list) {
                if (!s.isEmpty()) {
                    ((List)tracePropagationTargets).add((Object)s);
                }
            }
            this.tracePropagationTargets = (List<String>)tracePropagationTargets;
        }
    }
    
    @Deprecated
    public void setTraceSampling(final boolean traceSampling) {
        this.traceSampling = traceSampling;
    }
    
    public void setTracesSampleRate(final Double tracesSampleRate) {
        if (io.sentry.util.q.d(tracesSampleRate)) {
            this.tracesSampleRate = tracesSampleRate;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("The value ");
        sb.append((Object)tracesSampleRate);
        sb.append(" is not valid. Use null to disable or values between 0.0 and 1.0.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void setTracesSampler(final g tracesSampler) {
        this.tracesSampler = tracesSampler;
    }
    
    @Deprecated
    public void setTracingOrigins(final List<String> tracePropagationTargets) {
        this.setTracePropagationTargets(tracePropagationTargets);
    }
    
    public void setTransactionPerformanceCollector(final s5 transactionPerformanceCollector) {
        this.transactionPerformanceCollector = transactionPerformanceCollector;
    }
    
    public void setTransactionProfiler(w0 c) {
        if (c == null) {
            c = (w0)c2.c();
        }
        this.transactionProfiler = c;
    }
    
    public void setTransportFactory(x0 b) {
        if (b == null) {
            b = (x0)d2.b();
        }
        this.transportFactory = b;
    }
    
    public void setTransportGate(q b) {
        if (b == null) {
            b = (q)t.b();
        }
        this.transportGate = b;
    }
    
    public void setViewHierarchyExporters(final List<io.sentry.internal.viewhierarchy.a> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll((Collection)list);
    }
    
    public interface a
    {
        io.sentry.e a(final io.sentry.e p0, final a0 p1);
    }
    
    public interface b
    {
        e4 execute(final e4 p0, final a0 p1);
    }
    
    public interface c
    {
        io.sentry.protocol.x a(final io.sentry.protocol.x p0, final a0 p1);
    }
    
    public interface d
    {
        Double a(final q2 p0);
    }
    
    public static final class e
    {
        private String a;
        private String b;
        private String c;
        private String d;
        
        public e(final String a, final String b, final String c, final String d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public String a() {
            return this.a;
        }
        
        public String b() {
            return this.d;
        }
        
        public String c() {
            return this.b;
        }
        
        public String d() {
            return this.c;
        }
    }
    
    public enum f
    {
        private static final f[] $VALUES;
        
        ALWAYS, 
        MEDIUM, 
        NONE, 
        SMALL;
        
        private static /* synthetic */ f[] $values() {
            return new f[] { f.NONE, f.SMALL, f.MEDIUM, f.ALWAYS };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    public interface g
    {
        Double a(final q2 p0);
    }
}
