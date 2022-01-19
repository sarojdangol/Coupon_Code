package com.example.demo.model;

import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class StringPrefixedSequenceGenerator extends SequenceStyleGenerator {

    public static final String valuePrefixParameter="value Prefix";
    public static final String valueDefault="";
    private String valuePrefix;

}
