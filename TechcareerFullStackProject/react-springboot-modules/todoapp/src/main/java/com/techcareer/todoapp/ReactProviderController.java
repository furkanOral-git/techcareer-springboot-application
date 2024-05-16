package com.techcareer.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ReactProviderController {
    /*
     * React'ın spring uygulamaya entegrasyonu için gerekli olan View Controller'ı
     * ve içerisindeki giriş endpointi.
     * Controller gelen isteği karşıladıktan sonra resources/static
     * içerisinde index.html dosyasını arar ve bunu kullanıcıya döndürür.
     */
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
}
