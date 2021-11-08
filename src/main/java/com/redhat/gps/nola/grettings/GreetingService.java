package com.redhat.gps.nola.grettings;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    //protected final String[] langs=new String[]{"en","es","it","fr","po","ru"};
    //protected final String[] greetings=new String[]{"Hello","Hala","Ciao","Salut","Ola","Privet"};

    public String greeting(String name) {
        return "Hello " + name + "!";
        //return this.greetingLang("en", name);
    }

    /*
    public String getGreetingsLang(String lang){
        String greeting_lang="";
        for(int i=0; i<langs.length; i++) {
            if(lang.equals(langs[i])){
                greeting_lang=greetings[i];
                break;
            }
        }
        if(greeting_lang.equals("")){
            greeting_lang="Hello";
        }
        return greeting_lang;
    }

    public String greetingLang(String lang){
        return this.getGreetingsLang(lang)+"!";
    }
    
    public String greetingLang(String lang, String name) {
        return this.getGreetingsLang(lang)+" "+name+"!";
    }
    */
}