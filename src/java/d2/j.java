package d2;

import java.util.Arrays;
import java.util.List;

class j
{
    static <T> List<T> a(final T[] array) {
        return (List<T>)Arrays.asList((Object[])array);
    }
}
