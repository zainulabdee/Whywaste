package io.sentry.clientreport;

public enum e
{
    private static final e[] $VALUES;
    
    BEFORE_SEND("before_send"), 
    CACHE_OVERFLOW("cache_overflow"), 
    EVENT_PROCESSOR("event_processor"), 
    NETWORK_ERROR("network_error"), 
    QUEUE_OVERFLOW("queue_overflow"), 
    RATELIMIT_BACKOFF("ratelimit_backoff"), 
    SAMPLE_RATE("sample_rate");
    
    private final String reason;
    
    private static /* synthetic */ e[] $values() {
        return new e[] { e.QUEUE_OVERFLOW, e.CACHE_OVERFLOW, e.RATELIMIT_BACKOFF, e.NETWORK_ERROR, e.SAMPLE_RATE, e.BEFORE_SEND, e.EVENT_PROCESSOR };
    }
    
    static {
        $VALUES = $values();
    }
    
    private e(final String reason) {
        this.reason = reason;
    }
    
    public String getReason() {
        return this.reason;
    }
}
