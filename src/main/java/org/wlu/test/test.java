package org.wlu.test;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.concurrent.*;

public class test {

    public static final int i = 5;

    public static void main(String[] args){
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale);
    }



}

