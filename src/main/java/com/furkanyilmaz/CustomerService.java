package com.furkanyilmaz;

import com.furkanyilmaz.data.entity.Customer;
import com.furkanyilmaz.fileManager.FileException;
import com.furkanyilmaz.logManager.EmailLog;
import com.furkanyilmaz.logManager.ILogger;

import java.util.Scanner;
public class CustomerService {
    static Scanner klavye = new Scanner(System.in);
    public static void AddLog(ILogger ilogger) throws FileException{
        ilogger.Log();
    }
    public static void ParaGoruntule(Customer customer){
        System.out.println("bakiyeniz : "+customer.getBakiye() + " TL");
        if(customer.getBakiye() ==0){
            System.out.println("para eklemelisiniz...");
        }
    }
    public static void ParaYatir(Customer customer){
        System.out.println("Ne kadar para yatırmak istiyorsunuz ?");
        int eklenenMiktar = klavye.nextInt();
        System.out.println(eklenenMiktar + " TL yatırılıyor...");
        int toplamPara = eklenenMiktar+customer.getBakiye();
        System.out.println("Son bakiyeniz: " +toplamPara);
    }
    public static void ParaCek(Customer customer) throws FileException {
        System.out.println("Ne kadar para çekmek istiyorsunuz ?");
        int cekilenMiktar = klavye.nextInt();
        if(cekilenMiktar> customer.getBakiye() ==true){
            System.out.println("bakiye yetersiz, " +customer.getBakiye()+ " TL ya da daha az miktar tuşlayınız.");
            GirisYap(customer);

        }
        else {
            System.out.println(cekilenMiktar + " Tl hesabınızdan çekiliyor...");
            int kalanPara = customer.getBakiye() - cekilenMiktar;
            System.out.println("Hesabınızda " + kalanPara + " TL kaldı.");
        }
    }
    public static void HavaleYap(Customer customer){
        System.out.println("Ne kadar havale yapmak istiyorsunuz ?");
        int cekilenMiktar = klavye.nextInt();
        System.out.println(cekilenMiktar +" Tl hesabınızdan Havale ediliyor...");
        int kalanPara = customer.getBakiye() - cekilenMiktar;
        System.out.println("Hesabınızda "+ kalanPara + " TL kaldı.");
        System.out.println("E mail adresinize gönderildi...");
    }
    public static void EftYap(Customer customer){
        System.out.println("Ne kadar EFT yapmak istiyorsunuz ?");
        int cekilenMiktar = klavye.nextInt();
        System.out.println(cekilenMiktar +" Tl hesabınızdan EFT yapılıyor...");
        int kalanPara = customer.getBakiye() - cekilenMiktar;
        System.out.println("Hesabınızda "+ kalanPara + " TL kaldı.");
        System.out.println("E mail adresinize gönderildi...");
    }
    public static void CikisYap(Customer customer){
        System.out.println("Çıkış yapıldı.");
    }


    public static void GirisYap(Customer customer) throws FileException {

        Scanner klavye = new Scanner(System.in);

        String kullanici_adi, sifre;
        int i =2;
        for ( i = 2; i >= 0; i--) {
            System.out.println("Username giriniz:");
            kullanici_adi=klavye.next();
            System.out.println("Password giriniz:");
            sifre=klavye.next();
            if(customer.getUsername().equals(kullanici_adi) && customer.getPassword().equals(sifre)){
                System.out.println("Hoşgeldin " + customer.getUsername());
                System.out.println("Sisteme Başarıyla Girildi!\n1-)Bakiye Görüntüle\n2-)Para Yatırma\n3-)Para Çekme\n4-)Havale yap\n5-)EFT yap\n6-)Mail gönder\n7-)Çıkış Yap\n");
                System.out.print("Lütfen Seçiminizi Yapınız :");

                int chooise=0;
                chooise = klavye.nextInt();
                switch (chooise){
                    case 1:
                        ParaGoruntule(customer);
                        break;
                    case 2:
                        ParaYatir(customer);
                        break;
                    case 3:
                        ParaCek(customer);
                        break;
                    case 4:
                        HavaleYap(customer);
                        break;
                    case 5:
                        EftYap(customer);
                        break;
                    case 6:
                        AddLog(new EmailLog());
                        break;
                    case 7:
                        CikisYap(customer);
                        break;
                }
                break;
            }
            System.out.println(i + " hakkınız kaldı..");
            if(i ==0 ) {
                System.out.println( customer.getUsername()+" hesabı bloke oldu.");
            }
        }
    }
}
