package stg.qa.sreda.config;

public enum LocalConfig implements Config {
    instance;

    @Override
    public String frontUrl() {
        return "https://dev-stroytransgaz.april-inn.ru";
    }

}
