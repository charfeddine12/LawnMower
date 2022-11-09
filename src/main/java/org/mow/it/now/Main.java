package org.mow.it.now;

import org.mow.it.now.service.impl.LawnServiceImpl;

public class Main {
    public static void main(String[] args) {
        LawnServiceImpl lawnService = new LawnServiceImpl();
        lawnService.mow(args[0]);
    }
}