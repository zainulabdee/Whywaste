package org.chromium.support_lib_boundary;

import java.util.concurrent.Callable;

public interface IsomorphicObjectBoundaryInterface
{
    Object getOrCreatePeer(final Callable<Object> p0);
}
