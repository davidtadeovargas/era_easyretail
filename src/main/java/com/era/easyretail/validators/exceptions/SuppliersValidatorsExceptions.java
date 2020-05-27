package com.era.easyretail.validators.exceptions;

public class SuppliersValidatorsExceptions {

   private static SuppliersValidatorsExceptions SuppliersValidatorsExceptions;

   public static SuppliersValidatorsExceptions getSigleton(){
       if(SuppliersValidatorsExceptions==null){SuppliersValidatorsExceptions = new SuppliersValidatorsExceptions();}return SuppliersValidatorsExceptions;
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

   public Exception getAccountException(){
       return new Exception("Falta espeficiar Account");
   }

   public Exception getBankException(){
       return new Exception("Falta espeficiar Bank");
   }

   public Exception getBloqException(){
       return new Exception("Falta espeficiar Bloq");
   }

   public Exception getBloqlimcredException(){
       return new Exception("Falta espeficiar Bloqlimcred");
   }

   public Exception getCelphoneException(){
       return new Exception("Falta espeficiar Celphone");
   }

   public Exception getCityException(){
       return new Exception("Falta espeficiar City");
   }

   public Exception getClasificationCodeException(){
       return new Exception("Falta espeficiar ClasificationCode");
   }

   public Exception getClaveBankException(){
       return new Exception("Falta espeficiar ClaveBank");
   }

   public Exception getColonyException(){
       return new Exception("Falta espeficiar Colony");
   }

   public Exception getContableAccountException(){
       return new Exception("Falta espeficiar ContableAccount");
   }

   public Exception getContac4Exception(){
       return new Exception("Falta espeficiar Contac4");
   }

   public Exception getCountryException(){
       return new Exception("Falta espeficiar Country");
   }

   public Exception getCpException(){
       return new Exception("Falta espeficiar Cp");
   }

   public Exception getCreditDaysException(){
       return new Exception("Falta espeficiar CreditDays");
   }

   public Exception getDeliverCPException(){
       return new Exception("Falta espeficiar DeliverCP");
   }

   public Exception getDeliverCellphoneException(){
       return new Exception("Falta espeficiar DeliverCellphone");
   }

   public Exception getDeliverCityException(){
       return new Exception("Falta espeficiar DeliverCity");
   }

   public Exception getDeliverColonyException(){
       return new Exception("Falta espeficiar DeliverColony");
   }

   public Exception getDeliverCountryException(){
       return new Exception("Falta espeficiar DeliverCountry");
   }

   public Exception getDeliverEmail1Exception(){
       return new Exception("Falta espeficiar DeliverEmail1");
   }

   public Exception getDeliverEmail2Exception(){
       return new Exception("Falta espeficiar DeliverEmail2");
   }

   public Exception getDeliverEmail3Exception(){
       return new Exception("Falta espeficiar DeliverEmail3");
   }

   public Exception getDeliverEstateException(){
       return new Exception("Falta espeficiar DeliverEstate");
   }

   public Exception getDeliverInternalNumberException(){
       return new Exception("Falta espeficiar DeliverInternalNumber");
   }

   public Exception getDeliverLadaException(){
       return new Exception("Falta espeficiar DeliverLada");
   }

   public Exception getDeliverStreetException(){
       return new Exception("Falta espeficiar DeliverStreet");
   }

   public Exception getDeliveryExternalNumberException(){
       return new Exception("Falta espeficiar DeliveryExternalNumber");
   }

   public Exception getDisccountException(){
       return new Exception("Falta espeficiar Disccount");
   }

   public Exception getEmail1Exception(){
       return new Exception("Falta espeficiar Email1");
   }

   public Exception getEmail2Exception(){
       return new Exception("Falta espeficiar Email2");
   }

   public Exception getEmail3Exception(){
       return new Exception("Falta espeficiar Email3");
   }

   public Exception getEstateException(){
       return new Exception("Falta espeficiar Estate");
   }

   public Exception getExtensionException(){
       return new Exception("Falta espeficiar Extension");
   }

   public Exception getExternalNumberException(){
       return new Exception("Falta espeficiar ExternalNumber");
   }

   public Exception getGiroException(){
       return new Exception("Falta espeficiar Giro");
   }

   public Exception getInteriorNumberException(){
       return new Exception("Falta espeficiar InteriorNumber");
   }

   public Exception getJerarchyClasificationException(){
       return new Exception("Falta espeficiar JerarchyClasification");
   }

   public Exception getLadaException(){
       return new Exception("Falta espeficiar Lada");
   }

   public Exception getNameException(){
       return new Exception("Falta espeficiar Name");
   }

   public Exception getObservationsException(){
       return new Exception("Falta espeficiar Observations");
   }

   public Exception getPaymentMethodException(){
       return new Exception("Falta espeficiar PaymentMethod");
   }

   public Exception getPaymentsException(){
       return new Exception("Falta espeficiar Payments");
   }

   public Exception getPersException(){
       return new Exception("Falta espeficiar Pers");
   }

   public Exception getPersonalPhone1Exception(){
       return new Exception("Falta espeficiar PersonalPhone1");
   }

   public Exception getPhoneException(){
       return new Exception("Falta espeficiar Phone");
   }

   public Exception getRevisionException(){
       return new Exception("Falta espeficiar Revision");
   }

   public Exception getRfcException(){
       return new Exception("Falta espeficiar Rfc");
   }

   public Exception getSerieException(){
       return new Exception("Falta espeficiar Serie");
   }

   public Exception getStreetException(){
       return new Exception("Falta espeficiar Street");
   }

   public Exception getTelcon3Exception(){
       return new Exception("Falta espeficiar Telcon3");
   }

   public Exception getTelcon4Exception(){
       return new Exception("Falta espeficiar Telcon4");
   }

   public Exception getTelper3Exception(){
       return new Exception("Falta espeficiar Telper3");
   }

   public Exception getTelper33Exception(){
       return new Exception("Falta espeficiar Telper33");
   }

   public Exception getWebpage1Exception(){
       return new Exception("Falta espeficiar Webpage1");
   }

   public Exception getWebpage2Exception(){
       return new Exception("Falta espeficiar Webpage2");
   }

   public Exception getZoneException(){
       return new Exception("Falta espeficiar Zone");
   }

}