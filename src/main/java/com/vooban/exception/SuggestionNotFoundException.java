package com.vooban.exception;

/**
 * Created by jnobert on 2016-11-27.
 */
public class SuggestionNotFoundException extends RuntimeException
{
    public SuggestionNotFoundException(String msg)
    {
        super(msg);
    }
}
