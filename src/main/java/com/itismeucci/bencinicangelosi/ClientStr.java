package com.itismeucci.bencinicangelosi;
import java.net.*;
import java.io.*;


public class ClientStr {
    String nomeServer = "localhost";
    int portaServer = 4335;
    Socket miosocket ;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;
    boolean isStopped = false;
    String nomeUtente = "";

    public Socket connetti(){
        System.out.println("2 CLIENT partito in esecuzione ...");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new  Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
            nomeUtente = tastiera.readLine();
            outVersoServer.writeBytes(nomeUtente);
        } catch (UnknownHostException e) {
            System.err.println("Host sconosciuto");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1);
        }
        return miosocket;
    }

    public void run(){
        try{
            comunica();
        }catch (Exception e) {
            
        }
    }

    public void comunica(){
        for(;;)
        try{
            System.out.println("4... Inserisci la stringa da trasmettere al server:" + "\n");
            stringaUtente = tastiera.readLine();

            System.out.println("5... invio la stringa ");
            outVersoServer.writeBytes(stringaUtente + '\n');

            stringaRicevutaDalServer = inDalServer.readLine();
            System.out.println("7 ... risposta dal server " + '\n' + stringaRicevutaDalServer);
            if(stringaUtente.equals("FINE") || stringaUtente.equals("STOP")){
                if(isStopped){
                    break;
                }
                System.out.println("8 CLIENT: termina elaborazione e chiude connessione");
                miosocket.close();
                isStopped = true;
                break;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server!");
            System.exit(1);
        }
    }
}