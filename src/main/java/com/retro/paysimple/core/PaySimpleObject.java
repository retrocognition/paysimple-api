package com.retro.paysimple.core;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * base class for all pay simple objects
 */
@SuppressWarnings("serial")
public abstract class PaySimpleObject implements Serializable {
    public static final long NULL = 0;
    // common to pay simple objects
    private Long id;
    // meta data
    @JsonProperty(value="CreatedOn")
    private DateTime created;
    @JsonProperty(value="LastModified")
    private DateTime updated;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public DateTime getCreated() {
        return created;
    }
    public void setCreated(DateTime created) {
        this.created = created;
    }
    public DateTime getUpdated() {
        return updated;
    }
    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

    /**
     * generic <tt>Object.toString()</tt> implementation
     */
    @SuppressWarnings("rawtypes")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        result.append(this.getClass().getName());
        result.append(" {");
        result.append(newLine);
        // determine fields declared in this class only (no fields of
        // superclass)
        Class clazz = this.getClass();
        do {
            Field[] fields = clazz.getDeclaredFields();
            // requires access to private field:
            AccessibleObject.setAccessible(fields, true);
            // print field names paired with their values
            for (Field field : fields) {
                result.append("  ");
                try {
                    result.append(field.getName());
                    result.append(": ");
                    if(field.getType().equals(Long.TYPE)) {
                        result.append(Long.toString(field.getLong(this)));
                    } else {
                        result.append(field.get(this));
                    }
                } catch (IllegalAccessException ex) {
                    System.err.println(ex);
                }
                result.append(newLine);
            }
            clazz = clazz.getSuperclass();
        } while (clazz != null && clazz != Object.class);

        result.append("}");

        return result.toString();
    }
}
