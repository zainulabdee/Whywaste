package c0;

import java.util.Arrays;

final class y extends x
{
    private final byte[] g;
    
    y(final byte[] g) {
        super(Arrays.copyOfRange(g, 0, 25));
        this.g = g;
    }
    
    @Override
    final byte[] n() {
        return this.g;
    }
}
