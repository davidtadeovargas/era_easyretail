/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MissingUserException;
import com.era.easyretail.validators.exceptions.NotExistsUserException;
import com.era.easyretail.validators.exceptions.WarehouseNotExistsException;
import com.era.models.User;
import com.era.models.Warehouse;
import com.era.repositories.RepositoryFactory;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class UpdateUsersValidator  {

    private JTextField user;
    private JTextField almacen;
    
        
    public void validate() throws Exception {
        
        //Validate empty fields
        if(user.getText().isEmpty()){
            throw new MissingUserException();
        }
        if(!almacen.getText().isEmpty()){
            
            //Validate if the warehouse exists
            final String warehouseCode = almacen.getText().trim();
            final Warehouse Warehouse_ = (Warehouse) RepositoryFactory.getInstance().getWarehousesRepository().getByCode(warehouseCode);
            if(Warehouse_ == null){
                throw new WarehouseNotExistsException();
            }            
        }
        
        //Validate that the user not exists
        final String userCode = user.getText().trim();
        final User User = (User) RepositoryFactory.getInstance().getUsersRepository().getByCode(userCode);
        if(User == null){
            throw new NotExistsUserException();
        }
        
        //All is correct
    }

    public void setUser(JTextField user) {
        this.user = user;
    }

    public void setAlmacen(JTextField almacen) {
        this.almacen = almacen;
    }
}
