package com.era.easyretail.validators.exceptions;

public class CompanysValidatorsExceptions {

   private static CompanysValidatorsExceptions CompanysValidatorsExceptions;

   public static CompanysValidatorsExceptions getSigleton(){
       if(CompanysValidatorsExceptions==null){CompanysValidatorsExceptions = new CompanysValidatorsExceptions();}return CompanysValidatorsExceptions;
   }

   public Exception getModelExistsException(){
       return new Exception("El registro ya existe");
   }

   public Exception getCustomVaidationNotPassedException(){
       return new Exception("El registro no paso las validaciones");
   }

   public Exception getModelNotExistsException(){
       return new Exception("El registro no existe");
   }

   public Exception getCodeException(){
       return new Exception("Falta espeficiar codigo");
   }

   public Exception getAppPathException(){
       return new Exception("Falta espeficiar AppPath");
   }

   public Exception getCompanyCodeException(){
       return new Exception("Falta espeficiar CompanyCode");
   }

   public Exception getNomException(){
       return new Exception("Falta espeficiar Nom");
   }

}