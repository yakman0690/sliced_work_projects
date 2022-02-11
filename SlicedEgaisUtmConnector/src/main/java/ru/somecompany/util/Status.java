/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.util;

/**
 *
 * @author Alexandra
 */
public enum Status {

        NEW,
        PENDING_ACCEPT,
        PENDING_DECLINE,
        PENDING_DISAGREE,
        PROCESSED_ACCEPT,
        PROCESSED_DEECLINE,
        PROCESSED_DISAGREE,
        DISAGREE_APPROVED,
        DISAGREE_REJECTED,
        SENT,
        CONFIRMED,
        CANCELED,
        ERROR,
        ACCEPTED_BY_SERVER,
        PENDING_REPEAL,
        PROCESSED_REPEAL
    }
