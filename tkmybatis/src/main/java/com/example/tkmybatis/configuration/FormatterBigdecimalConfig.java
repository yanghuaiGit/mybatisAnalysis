package com.example.tkmybatis.configuration;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author penglu
 * @version 1.0.0
 * @date 2019/10/10
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
//@Component
public class FormatterBigdecimalConfig implements Formatter<String> {

    @Override
    public String print(String s, Locale locale) {
        return s;
    }

    @Override
    public String parse(String s, Locale locale) throws ParseException {
        return s+s;
    }
}
