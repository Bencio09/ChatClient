package com.itismeucci.bencinicangelosi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadIn extends Thread {
    Socket socket;
    BufferedReader in;

    public ThreadIn(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            for (;;) {
                String txtMsg = in.readLine();
                if (txtMsg != null) {
                    System.out.println(txtMsg);
                }
            }
        } catch (Exception e) {
            e.getMessage();
            System.exit(1);
        }
    }

    public void close() {
        try {
            this.stop();
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.exit(0);
    }
}