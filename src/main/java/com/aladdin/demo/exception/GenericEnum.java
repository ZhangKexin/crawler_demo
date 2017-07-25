package com.aladdin.demo.exception;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zkx on 2017/7/25.
 */
public class GenericEnum<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final TreeMap<E, String> enumMap = new TreeMap<E, String>();

    public GenericEnum() {}

    public String getName(E value) {
        return enumMap.get(value);
    }

    public E getValue(String name) {
        E value = null;
        if (enumMap.containsValue(name)) {
            Iterator<E> i = enumMap.keySet().iterator();
            while (i.hasNext()) {
                E key = (E) i.next();
                String enumName = enumMap.get(key);
                if (enumName.equals(name)) {
                    value = key;
                    break;
                }
            }
        } else {
            throw new UserException("[" + this.getClass().getSimpleName() + "]" + name);
        }
        return value;
    }

    public String[] getAllNames() {
        String[] names = new String[enumMap.size()];
        enumMap.values().toArray(names);
        return names;
    }

    public void putEnum(E value, String name) {
        enumMap.put(value, name);
    }

    public Map<E, String> getAllEnum() {
        return this.enumMap;
    }

    public boolean containsKey(E key) {
        return this.enumMap.containsKey(key);
    }
}

