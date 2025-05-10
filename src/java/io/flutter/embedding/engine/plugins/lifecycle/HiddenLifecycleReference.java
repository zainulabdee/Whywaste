package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.lifecycle.f;

public class HiddenLifecycleReference
{
    private final f lifecycle;
    
    public HiddenLifecycleReference(final f lifecycle) {
        this.lifecycle = lifecycle;
    }
    
    public f getLifecycle() {
        return this.lifecycle;
    }
}
