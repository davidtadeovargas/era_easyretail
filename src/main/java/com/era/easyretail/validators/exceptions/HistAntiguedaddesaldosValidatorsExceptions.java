package com.era.easyretail.validators.exceptions;

public class HistAntiguedaddesaldosValidatorsExceptions {

   private static HistAntiguedaddesaldosValidatorsExceptions HistAntiguedaddesaldosValidatorsExceptions;

   public static HistAntiguedaddesaldosValidatorsExceptions getSigleton(){
       if(HistAntiguedaddesaldosValidatorsExceptions==null){HistAntiguedaddesaldosValidatorsExceptions = new HistAntiguedaddesaldosValidatorsExceptions();}return HistAntiguedaddesaldosValidatorsExceptions;
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

   public Exception getCodempException(){
       return new Exception("Falta espeficiar Codemp");
   }

   public Exception getIdCorteException(){
       return new Exception("Falta espeficiar IdCorte");
   }

   public Exception getNomException(){
       return new Exception("Falta espeficiar Nom");
   }

}