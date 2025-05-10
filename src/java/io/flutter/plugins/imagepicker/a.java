package io.flutter.plugins.imagepicker;

import java.util.Iterator;
import android.util.Log;
import java.util.Arrays;

class a
{
    private static void b(final androidx.exifinterface.media.a a, final androidx.exifinterface.media.a a2, final String s) {
        if (a.d(s) != null) {
            a2.T(s, a.d(s));
        }
    }
    
    void a(final String s, final String s2) {
        try {
            final androidx.exifinterface.media.a a = new androidx.exifinterface.media.a(s);
            final androidx.exifinterface.media.a a2 = new androidx.exifinterface.media.a(s2);
            final Iterator iterator = Arrays.asList((Object[])new String[] { "FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model", "Orientation" }).iterator();
            while (iterator.hasNext()) {
                b(a, a2, (String)iterator.next());
            }
            a2.P();
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Error preserving Exif data on selected image: ");
            sb.append((Object)ex);
            Log.e("ExifDataCopier", sb.toString());
        }
    }
}
