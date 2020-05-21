/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.MissingAlmacenException;
import com.era.easyretail.validators.exceptions.MissingUserException;
import com.era.easyretail.validators.exceptions.NotExistsUserException;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class UpdateUsersValidator implements IValidate {

    private JTextField user;
    private JTextField almacen;
    
    
    @Override
    public void validate() throws Exception {
        
        //Validate empty fields
        if(user.getText().isEmpty()){
            throw new MissingUserException();
        }
        if(almacen.getText().isEmpty()){
            throw new MissingAlmacenException();
        }
        
        //Validate that the user not exists
        final String userCode = user.getText().trim();
        final User User = RepositoryFactory.getInstance().getUsersRepository().getUsrByCode(userCode);
        if(User == null){
            throw new NotExistsUserException();
        }
        
        //All is correct
    }       
}
