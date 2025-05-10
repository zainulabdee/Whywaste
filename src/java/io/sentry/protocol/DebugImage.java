package io.sentry.protocol;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import io.sentry.m1;

public final class DebugImage implements m1
{
    public static final String JVM = "jvm";
    public static final String PROGUARD = "proguard";
    private String arch;
    private String codeFile;
    private String codeId;
    private String debugFile;
    private String debugId;
    private String imageAddr;
    private Long imageSize;
    private String type;
    private Map<String, Object> unknown;
    private String uuid;
    
    public String getArch() {
        return this.arch;
    }
    
    public String getCodeFile() {
        return this.codeFile;
    }
    
    public String getCodeId() {
        return this.codeId;
    }
    
    public String getDebugFile() {
        return this.debugFile;
    }
    
    public String getDebugId() {
        return this.debugId;
    }
    
    public String getImageAddr() {
        return this.imageAddr;
    }
    
    public Long getImageSize() {
        return this.imageSize;
    }
    
    public String getType() {
        return this.type;
    }
    
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }
    
    public String getUuid() {
        return this.uuid;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.uuid != null) {
            k1.y("uuid").v(this.uuid);
        }
        if (this.type != null) {
            k1.y("type").v(this.type);
        }
        if (this.debugId != null) {
            k1.y("debug_id").v(this.debugId);
        }
        if (this.debugFile != null) {
            k1.y("debug_file").v(this.debugFile);
        }
        if (this.codeId != null) {
            k1.y("code_id").v(this.codeId);
        }
        if (this.codeFile != null) {
            k1.y("code_file").v(this.codeFile);
        }
        if (this.imageAddr != null) {
            k1.y("image_addr").v(this.imageAddr);
        }
        if (this.imageSize != null) {
            k1.y("image_size").u((Number)this.imageSize);
        }
        if (this.arch != null) {
            k1.y("arch").v(this.arch);
        }
        final Map<String, Object> unknown = this.unknown;
        if (unknown != null) {
            for (final String s : unknown.keySet()) {
                k1.y(s).z(n0, this.unknown.get((Object)s));
            }
        }
        k1.h();
    }
    
    public void setArch(final String arch) {
        this.arch = arch;
    }
    
    public void setCodeFile(final String codeFile) {
        this.codeFile = codeFile;
    }
    
    public void setCodeId(final String codeId) {
        this.codeId = codeId;
    }
    
    public void setDebugFile(final String debugFile) {
        this.debugFile = debugFile;
    }
    
    public void setDebugId(final String debugId) {
        this.debugId = debugId;
    }
    
    public void setImageAddr(final String imageAddr) {
        this.imageAddr = imageAddr;
    }
    
    public void setImageSize(final long n) {
        this.imageSize = n;
    }
    
    public void setImageSize(final Long imageSize) {
        this.imageSize = imageSize;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public void setUnknown(final Map<String, Object> unknown) {
        this.unknown = unknown;
    }
    
    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }
    
    public static final class a implements c1<DebugImage>
    {
        public DebugImage b(final i1 i1, final n0 n0) {
            final DebugImage debugImage = new DebugImage();
            i1.b();
            Map<String, Object> unknown = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 941842605: {
                        if (!r.equals((Object)"code_id")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 547804807: {
                        if (!r.equals((Object)"debug_id")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 3601339: {
                        if (!r.equals((Object)"uuid")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 3002454: {
                        if (!r.equals((Object)"arch")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case -1127437170: {
                        if (!r.equals((Object)"code_file")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1442803611: {
                        if (!r.equals((Object)"image_size")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1443345323: {
                        if (!r.equals((Object)"image_addr")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1840639000: {
                        if (!r.equals((Object)"debug_file")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o = unknown;
                        if (unknown == null) {
                            o = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        unknown = (Map<String, Object>)o;
                        continue;
                    }
                    case 8: {
                        debugImage.codeId = i1.U();
                        continue;
                    }
                    case 7: {
                        debugImage.debugId = i1.U();
                        continue;
                    }
                    case 6: {
                        debugImage.uuid = i1.U();
                        continue;
                    }
                    case 5: {
                        debugImage.type = i1.U();
                        continue;
                    }
                    case 4: {
                        debugImage.arch = i1.U();
                        continue;
                    }
                    case 3: {
                        debugImage.codeFile = i1.U();
                        continue;
                    }
                    case 2: {
                        debugImage.imageSize = i1.Q();
                        continue;
                    }
                    case 1: {
                        debugImage.imageAddr = i1.U();
                        continue;
                    }
                    case 0: {
                        debugImage.debugFile = i1.U();
                        continue;
                    }
                }
            }
            i1.h();
            debugImage.setUnknown(unknown);
            return debugImage;
        }
    }
}
