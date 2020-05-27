package com.era.easyretail.validators.exceptions;

public class DocumentosOrigensValidatorsExceptions {

   private static DocumentosOrigensValidatorsExceptions DocumentosOrigensValidatorsExceptions;

   public static DocumentosOrigensValidatorsExceptions getSigleton(){
       if(DocumentosOrigensValidatorsExceptions==null){DocumentosOrigensValidatorsExceptions = new DocumentosOrigensValidatorsExceptions();}return DocumentosOrigensValidatorsExceptions;
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

   public Exception getNombreException(){
       return new Exception("Falta espeficiar Nombre");
   }

   public Exception getTipoException(){
       return new Exception("Falta espeficiar Tipo");
   }

}