package org.peace.notitle.emiacore.controller;

public class EmiaRunnable implements Runnable {

    private Thread thread = null;
    private String name = null;

    public EmiaRunnable(String name) {
        this.name = name;
    }

    public EmiaRunnable() {
        this.name = "never named";
    }

    public void start() {
        if (thread == null) thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {

    }
}
