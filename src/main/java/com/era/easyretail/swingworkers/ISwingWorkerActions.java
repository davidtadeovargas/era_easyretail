/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.swingworkers;

/**
 *
 * @author PC
 */
public interface ISwingWorkerActions {
    public void before();
    public Object doinbackground();
    public void after(Object Object);
}
