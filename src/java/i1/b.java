package i1;

public final class b
{
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    final boolean g;
    
    public b(String s, final String s2, final String s3, final String s4, final String s5, final String f, final boolean g) {
        String a = s;
        if (s == null) {
            a = "libapp.so";
        }
        this.a = a;
        if ((s = s2) == null) {
            s = "vm_snapshot_data";
        }
        this.b = s;
        if ((s = s3) == null) {
            s = "isolate_snapshot_data";
        }
        this.c = s;
        if ((s = s4) == null) {
            s = "flutter_assets";
        }
        this.d = s;
        this.f = f;
        if ((s = s5) == null) {
            s = "";
        }
        this.e = s;
        this.g = g;
    }
}
