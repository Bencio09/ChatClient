package com.itismeucci.bencinicangelosi;

public class ThreadOut extends Thread
{
    ClientStr client;
    @Override
    public void run(){
        try {
            for(;;){
                String txtMsg = client.tastiera.readLine();
                System.out.println("IO: " + txtMsg);
                client.outVersoServer.writeBytes(txtMsg + "\n");
            }
        } catch (Exception e) {
            e.getMessage();
            System.exit(1);
        }
    }
}
