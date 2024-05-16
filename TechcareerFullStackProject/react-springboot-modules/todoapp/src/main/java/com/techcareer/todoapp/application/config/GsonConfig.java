package com.techcareer.todoapp.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.Gson;

@Configuration
public class GsonConfig {

    @Bean
    public Gson gson(){
        return new Gson();
    }
    //Controller'dan geri döndürülecek veriyi jsona çevirmesi için gson kütüphanesi kullanılıyor.
    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson());
        return converter;
    }
}
