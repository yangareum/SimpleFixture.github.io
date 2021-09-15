package io.github.simplefixture.cache;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class MetaCache {
    private final Field f;
    private AtomicInteger assignCount = new AtomicInteger(1);

    public MetaCache(Field f){
        this.f = f;
    }

    public void increaseAssignCount(){
        assignCount.getAndIncrement();
    }

    public int getAssignCount(){
        return assignCount.intValue();
    }
}
