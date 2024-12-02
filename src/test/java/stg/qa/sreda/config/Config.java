package stg.qa.sreda.config;

public interface Config {


    static Config  getInstance(){
        return LocalConfig.instance;
    }

    String frontUrl();

}
