package com.era.easyretail.validators.exceptions;

public class PartordssValidatorsExceptions {

   private static PartordssValidatorsExceptions PartordssValidatorsExceptions;

   public static PartordssValidatorsExceptions getSigleton(){
       if(PartordssValidatorsExceptions==null){PartordssValidatorsExceptions = new PartordssValidatorsExceptions();}return PartordssValidatorsExceptions;
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

   public Exception getAlmaException(){
       return new Exception("Falta espeficiar Alma");
   }

   public Exception getCantException(){
       return new Exception("Falta espeficiar Cant");
   }

   public Exception getCodcotException(){
       return new Exception("Falta espeficiar Codcot");
   }

   public Exception getCodordException(){
       return new Exception("Falta espeficiar Codord");
   }

   public Exception getDescadException(){
       return new Exception("Falta espeficiar Descad");
   }

   public Exception getDescripException(){
       return new Exception("Falta espeficiar Descrip");
   }

   public Exception getDescuException(){
       return new Exception("Falta espeficiar Descu");
   }

   public Exception getFentException(){
       return new Exception("Falta espeficiar Fent");
   }

   public Exception getImpueException(){
       return new Exception("Falta espeficiar Impue");
   }

   public Exception getImpuevalException(){
       return new Exception("Falta espeficiar Impueval");
   }

   public Exception getMonException(){
       return new Exception("Falta espeficiar Mon");
   }

   public Exception getProdException(){
       return new Exception("Falta espeficiar Prod");
   }

   public Exception getUnidException(){
       return new Exception("Falta espeficiar Unid");
   }

}