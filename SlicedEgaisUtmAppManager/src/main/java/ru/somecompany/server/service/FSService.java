/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.server.service;

/**
 *
 * @author Alexandra
 */
public interface FSService {
    /**
     * Returns hash sum of current working version
     * @return 
     */
    public String getCurrentVersionHash();
    /**
     * Returns hash sum of downloaded version, if exists a version that's downloaded, but not updated
     * @return 
     */
    public String getDownloadedVersionHash();
    /** 
     * Sets new version hash sum after update
     * @param hash 
     */
    public void updateCurrentHash(String hash);
     /** 
     * Sets hash sum of downloaded version after download
     * @param hash 
     */
    public void updateDownloadedHash(String hash);
    
    /** 
     * Unnzip and relocateing files
     * @param hash 
     */
    public boolean updateFiles();
}
