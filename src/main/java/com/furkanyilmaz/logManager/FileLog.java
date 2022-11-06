package com.furkanyilmaz.logManager;

import com.furkanyilmaz.data.entity.Customer;
import com.furkanyilmaz.fileManager.FileException;
import com.furkanyilmaz.fileManager.FilePath;

import java.io.File;
import java.io.IOException;
public class FileLog implements ILogger  {

    @Override
    public void Log() throws FileException {
        File file=new File(FilePath.MY_PATH);
            try {
                if(file.createNewFile()){
                    System.out.println(FilePath.MY_PATH+" adresine işlem dosyası gönderilmiştir.");
                }else{
                    System.out.println("Böyle bir dosya bulunmaktadır.");
                }
            } catch (IOException e) {
                throw new FileException(e.toString());
            }
    }
}
