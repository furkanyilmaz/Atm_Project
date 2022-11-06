package com.furkanyilmaz.logManager;

import com.furkanyilmaz.data.entity.Customer;
import com.furkanyilmaz.fileManager.FileException;
public interface ILogger {// abstract ??
    void Log() throws FileException;


}

