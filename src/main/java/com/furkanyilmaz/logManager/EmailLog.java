package com.furkanyilmaz.logManager;

import lombok.SneakyThrows;
public class EmailLog implements ILogger {
    @SneakyThrows//thred-sleep
    @Override
    public void Log (){

        System.out.println("Mail gönderiliyor.");
        Thread.sleep(1000);
        System.out.println("Mail gönderildi...");
    }
//    public void emailFile() throws IOException {
//        FileWriter email = new FileWriter(FilePath.MY_PATH);
//        email.write("işleminiz mail adresinize gönderildi...");
//        email.close();
//    }
}

