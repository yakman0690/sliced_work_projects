/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.util;

/**
 *
 * @author Admin
 */
public enum UtmStates {
    UTM_READY,
    UTM_STOPPED,
    UTM_RSA_PROBLEM,
    UTM_UNKNOWN_PROBLEM,
    UTM_UPDATE_STATE;

    public String getName() {
        if (null != this) {
            switch (this) {
                case UTM_READY:
                    return "УТМ: запущен и готов к работе. ";
                case UTM_RSA_PROBLEM:
                    return "УТМ: ошибка ключа RSA.";
                case UTM_UNKNOWN_PROBLEM:
                    return "УТМ: запущен, но работает с ошибками. Проверьте ключ RSA.";
                case UTM_STOPPED:
                    return "УТМ: остановлен.";
                case UTM_UPDATE_STATE:
                    return "УТМ: запущен, уточнение статуса...";
                default:
                    return "УТМ: статус неизвестен.";
            }
        }
        return "УТМ: статус неизвестен.";
    }
    
    protected static UtmStates previousState;
    
    public static UtmStates getPreviousState(){
        return previousState;
    }

    public static void setPreviousState(UtmStates state){
        previousState = state;
    }

}
