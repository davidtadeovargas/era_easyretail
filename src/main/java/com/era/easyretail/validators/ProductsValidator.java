package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.ProductsValidatorsExceptions;
import com.era.models.Product;
import com.era.repositories.RepositoryFactory;

public class ProductsValidator extends IValidate{

   private String code;
   private String branchOffice;
   private String codeProduct;
   private String description;
   private String estation;
   private String keySAT;
   private String numberCash;

   @Override
   public void validateInsert() throws Exception {

       if(branchOffice==null || branchOffice.isEmpty()){
           throw new ProductsValidatorsExceptions().getBranchOfficeException();
       }

       if(codeProduct==null || codeProduct.isEmpty()){
           throw new ProductsValidatorsExceptions().getCodeProductException();
       }

       if(description==null || description.isEmpty()){
           throw new ProductsValidatorsExceptions().getDescriptionException();
       }

       if(estation==null || estation.isEmpty()){
           throw new ProductsValidatorsExceptions().getEstationException();
       }

       if(keySAT==null || keySAT.isEmpty()){
           throw new ProductsValidatorsExceptions().getKeySATException();
       }

       if(numberCash==null || numberCash.isEmpty()){
           throw new ProductsValidatorsExceptions().getNumberCashException();
       }

       final Product Product = (Product) RepositoryFactory.getInstance().getProductsRepository().getByCode(code);
       if(Product != null){            
           throw new ProductsValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new ProductsValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new ProductsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new ProductsValidatorsExceptions().getCodeException();
       }

       final Product Product = (Product) RepositoryFactory.getInstance().getProductsRepository().getByCode(code);
       if(Product == null){            
           throw new ProductsValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new ProductsValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}