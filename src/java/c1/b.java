package c1;

import a1.d0;
import java.util.List;

public abstract class b implements e
{
    private Boolean j(final String s) {
        final Object c = ((e)this).c(s);
        if (c instanceof Boolean) {
            return (Boolean)c;
        }
        return null;
    }
    
    private String l() {
        return (String)((e)this).c("sql");
    }
    
    private List<Object> m() {
        return (List<Object>)((e)this).c("arguments");
    }
    
    public d0 d() {
        return new d0(this.l(), (List)this.m());
    }
    
    public boolean e() {
        return Boolean.TRUE.equals(((e)this).c("noResult"));
    }
    
    public Boolean f() {
        return this.j("inTransaction");
    }
    
    public Integer g() {
        return (Integer)((e)this).c("transactionId");
    }
    
    public boolean h() {
        return ((e)this).i("transactionId") && this.g() == null;
    }
    
    public boolean k() {
        return Boolean.TRUE.equals(((e)this).c("continueOnError"));
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(((e)this).getMethod());
        sb.append(" ");
        sb.append(this.l());
        sb.append(" ");
        sb.append((Object)this.m());
        return sb.toString();
    }
}
