package com.furkanyilmaz;

import com.furkanyilmaz.data.entity.Customer;
import com.furkanyilmaz.fileManager.FileException;
import com.furkanyilmaz.logManager.FileLog;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) throws FileException, IOException {

		Customer admin = new Customer();
		admin.setUsername("admin@gmail.com");
		admin.setPassword("root");
		admin.setBakiye(1000);

		CustomerService cs = new CustomerService();
		cs.GirisYap(admin);
		cs.AddLog(new FileLog());
	}
}
