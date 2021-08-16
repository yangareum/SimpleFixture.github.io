package io.github.simplefixture.valuegenerator;

import io.github.simplefixture.utils.ClassUtils;
import io.github.simplefixture.Fixture;
import io.github.simplefixture.config.FixtureConfig;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionValueGenerator implements ValueGenerator<List>{

    private Type[] types;
    private FixtureConfig config;
    private Field field;

    public CollectionValueGenerator(Type[] types){
        this.types = types;
    }

    @Override
    public CollectionValueGenerator config(FixtureConfig config) {
        this.config = config;
        return this;
    }

    @Override
    public CollectionValueGenerator field(Field field) {
        this.field = field;
        return this;
    }

    @Override
    public List create() {
        try{
            List l = new ArrayList();
            int loopCount = config.getMaxCollectionSize();
            if(loopCount==0){
                return l;
            }
            for(int i=0;i<loopCount;i++){
                l.add(new Fixture().field(field).config(config).create(ClassUtils.castToClass(types[0])));
            }
            return l;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}