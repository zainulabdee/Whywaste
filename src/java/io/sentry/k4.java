package io.sentry;

import java.util.Locale;
import io.sentry.clientreport.b;
import io.sentry.protocol.x;

public enum k4 implements m1
{
    private static final k4[] $VALUES;
    
    Attachment("attachment"), 
    ClientReport("client_report"), 
    Event("event"), 
    Profile("profile"), 
    ReplayEvent("replay_event"), 
    ReplayRecording("replay_recording"), 
    Session("session"), 
    Transaction("transaction"), 
    Unknown("__unknown__"), 
    UserFeedback("user_report");
    
    private final String itemType;
    
    private static /* synthetic */ k4[] $values() {
        return new k4[] { k4.Session, k4.Event, k4.UserFeedback, k4.Attachment, k4.Transaction, k4.Profile, k4.ClientReport, k4.ReplayEvent, k4.ReplayRecording, k4.Unknown };
    }
    
    static {
        $VALUES = $values();
    }
    
    private k4(final String itemType) {
        this.itemType = itemType;
    }
    
    public static k4 resolve(final Object o) {
        if (o instanceof e4) {
            return k4.Event;
        }
        if (o instanceof x) {
            return k4.Transaction;
        }
        if (o instanceof a5) {
            return k4.Session;
        }
        if (o instanceof b) {
            return k4.ClientReport;
        }
        return k4.Attachment;
    }
    
    public static k4 valueOfLabel(final String s) {
        for (final k4 k4 : values()) {
            if (k4.itemType.equals((Object)s)) {
                return k4;
            }
        }
        return k4.Unknown;
    }
    
    public String getItemType() {
        return this.itemType;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.v(this.itemType);
    }
    
    static final class a implements c1<k4>
    {
        public k4 b(final i1 i1, final n0 n0) {
            return k4.valueOfLabel(i1.v().toLowerCase(Locale.ROOT));
        }
    }
}
