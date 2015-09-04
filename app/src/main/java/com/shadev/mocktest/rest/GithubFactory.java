package com.shadev.mocktest.rest;

/**
 * Created by devinshine on 15/9/4.
 *
 */
public class GithubFactory {
    protected static final Object monitor = new Object();
    static Github sSingleton = null;

    public static Github getSingleton() {
        synchronized (monitor) {
            if (sSingleton == null) {
                sSingleton = new GithubRetrofit().getService();
            }
            return sSingleton;
        }
    }
}
