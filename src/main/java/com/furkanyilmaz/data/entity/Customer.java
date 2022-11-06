package com.furkanyilmaz.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data // getter-setter
@NoArgsConstructor
@AllArgsConstructor //parametreli const
public class Customer {
        private String username; //private ????????????
        private String password;
        private int bakiye;
}
