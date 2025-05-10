package io.sentry;

public enum i
{
    private static final i[] $VALUES;
    
    All("__all__"), 
    Attachment("attachment"), 
    Default("default"), 
    Error("error"), 
    Profile("profile"), 
    Security("security"), 
    Session("session"), 
    Transaction("transaction"), 
    Unknown("unknown"), 
    UserReport("user_report");
    
    private final String category;
    
    private static /* synthetic */ i[] $values() {
        return new i[] { i.All, i.Default, i.Error, i.Session, i.Attachment, i.Profile, i.Transaction, i.Security, i.UserReport, i.Unknown };
    }
    
    static {
        $VALUES = $values();
    }
    
    private i(final String category) {
        this.category = category;
    }
    
    public String getCategory() {
        return this.category;
    }
}
