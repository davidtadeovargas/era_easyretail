package com.era.easyretail.validators.exceptions;

public class ModificaImpuestossValidatorsExceptions {

   private static ModificaImpuestossValidatorsExceptions ModificaImpuestossValidatorsExceptions;

   public static ModificaImpuestossValidatorsExceptions getSigleton(){
       if(ModificaImpuestossValidatorsExceptions==null){ModificaImpuestossValidatorsExceptions = new ModificaImpuestossValidatorsExceptions();}return ModificaImpuestossValidatorsExceptions;
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

}