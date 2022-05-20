package me.patrick.laboratory.singleton;

public class Settings {

    public static void main(String[] args) {

    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static class InnerSettings {

        private static InnerSettings innerSettings;

        private InnerSettings(){

        }

        public static InnerSettings getInstance(){
            if(innerSettings == null){
                synchronized (InnerSettings.class) {
                    if(innerSettings == null){
                        innerSettings = new InnerSettings();
                    }
                }
            }
            return innerSettings;
        }

    }
}
