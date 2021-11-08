package com.itismeucci.bencinicangelosi;

import java.net.Socket;

public class MultiClient extends Thread{
    Socket socket = null;

    public MultiClient (Socket socket){
        this.socket = socket;
    }

    public void arrestati(){
        for(;;){
            try {
                sleep(2000);
                if(!socket.isConnected()){

                }
                if(socket.isClosed()){

                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}