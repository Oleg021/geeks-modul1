package com.vyrvykhvost;

import com.vyrvykhvost.service.ServiceApp;



public class Main {
    private static final ServiceApp SERVICE_APP = new ServiceApp();
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        SERVICE_APP.serviceMenu();
    }
}
