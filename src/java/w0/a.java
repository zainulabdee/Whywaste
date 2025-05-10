package w0;

public final class a extends IllegalStateException
{
    private a(final String s, final Throwable t) {
        super(s, t);
    }
    
    public static IllegalStateException a(final g<?> g) {
        if (!g.j()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        final Exception f = g.f();
        String concat;
        if (f != null) {
            concat = "failure";
        }
        else if (g.k()) {
            concat = "result ".concat(String.valueOf(g.g()));
        }
        else if (g.i()) {
            concat = "cancellation";
        }
        else {
            concat = "unknown issue";
        }
        String concat2;
        if (concat.length() != 0) {
            concat2 = "Complete with: ".concat(concat);
        }
        else {
            concat2 = new String("Complete with: ");
        }
        return new a(concat2, (Throwable)f);
    }
}
