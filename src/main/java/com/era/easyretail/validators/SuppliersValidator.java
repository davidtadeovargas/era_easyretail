package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SuppliersValidatorsExceptions;
import com.era.models.Supplier;
import com.era.repositories.RepositoryFactory;

public class SuppliersValidator extends IValidate{

   private String code;
   private String account;
   private String bank;
   private String bloq;
   private String bloqlimcred;
   private String celphone;
   private String city;
   private String clasificationCode;
   private String claveBank;
   private String colony;
   private String contableAccount;
   private String contac4;
   private String country;
   private String cp;
   private String creditDays;
   private String deliverCP;
   private String deliverCellphone;
   private String deliverCity;
   private String deliverColony;
   private String deliverCountry;
   private String deliverEmail1;
   private String deliverEmail2;
   private String deliverEmail3;
   private String deliverEstate;
   private String deliverInternalNumber;
   private String deliverLada;
   private String deliverStreet;
   private String deliveryExternalNumber;
   private String disccount;
   private String email1;
   private String email2;
   private String email3;
   private String estate;
   private String extension;
   private String externalNumber;
   private String giro;
   private String interiorNumber;
   private String jerarchyClasification;
   private String lada;
   private String name;
   private String observations;
   private String paymentMethod;
   private String payments;
   private String pers;
   private String personalPhone1;
   private String phone;
   private String revision;
   private String rfc;
   private String serie;
   private String street;
   private String telcon3;
   private String telcon4;
   private String telper3;
   private String telper33;
   private String webpage1;
   private String webpage2;
   private String zone;

   @Override
   public void validateInsert() throws Exception {

       if(account==null || account.isEmpty()){
           throw new SuppliersValidatorsExceptions().getAccountException();
       }

       if(bank==null || bank.isEmpty()){
           throw new SuppliersValidatorsExceptions().getBankException();
       }

       if(bloq==null || bloq.isEmpty()){
           throw new SuppliersValidatorsExceptions().getBloqException();
       }

       if(bloqlimcred==null || bloqlimcred.isEmpty()){
           throw new SuppliersValidatorsExceptions().getBloqlimcredException();
       }

       if(celphone==null || celphone.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCelphoneException();
       }

       if(city==null || city.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCityException();
       }

       if(clasificationCode==null || clasificationCode.isEmpty()){
           throw new SuppliersValidatorsExceptions().getClasificationCodeException();
       }

       if(claveBank==null || claveBank.isEmpty()){
           throw new SuppliersValidatorsExceptions().getClaveBankException();
       }

       if(code==null || code.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCodeException();
       }

       if(colony==null || colony.isEmpty()){
           throw new SuppliersValidatorsExceptions().getColonyException();
       }

       if(contableAccount==null || contableAccount.isEmpty()){
           throw new SuppliersValidatorsExceptions().getContableAccountException();
       }

       if(contac4==null || contac4.isEmpty()){
           throw new SuppliersValidatorsExceptions().getContac4Exception();
       }

       if(country==null || country.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCountryException();
       }

       if(cp==null || cp.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCpException();
       }

       if(creditDays==null || creditDays.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCreditDaysException();
       }

       if(deliverCP==null || deliverCP.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverCPException();
       }

       if(deliverCellphone==null || deliverCellphone.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverCellphoneException();
       }

       if(deliverCity==null || deliverCity.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverCityException();
       }

       if(deliverColony==null || deliverColony.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverColonyException();
       }

       if(deliverCountry==null || deliverCountry.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverCountryException();
       }

       if(deliverEmail1==null || deliverEmail1.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverEmail1Exception();
       }

       if(deliverEmail2==null || deliverEmail2.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverEmail2Exception();
       }

       if(deliverEmail3==null || deliverEmail3.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverEmail3Exception();
       }

       if(deliverEstate==null || deliverEstate.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverEstateException();
       }

       if(deliverInternalNumber==null || deliverInternalNumber.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverInternalNumberException();
       }

       if(deliverLada==null || deliverLada.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverLadaException();
       }

       if(deliverStreet==null || deliverStreet.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliverStreetException();
       }

       if(deliveryExternalNumber==null || deliveryExternalNumber.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDeliveryExternalNumberException();
       }

       if(disccount==null || disccount.isEmpty()){
           throw new SuppliersValidatorsExceptions().getDisccountException();
       }

       if(email1==null || email1.isEmpty()){
           throw new SuppliersValidatorsExceptions().getEmail1Exception();
       }

       if(email2==null || email2.isEmpty()){
           throw new SuppliersValidatorsExceptions().getEmail2Exception();
       }

       if(email3==null || email3.isEmpty()){
           throw new SuppliersValidatorsExceptions().getEmail3Exception();
       }

       if(estate==null || estate.isEmpty()){
           throw new SuppliersValidatorsExceptions().getEstateException();
       }

       if(extension==null || extension.isEmpty()){
           throw new SuppliersValidatorsExceptions().getExtensionException();
       }

       if(externalNumber==null || externalNumber.isEmpty()){
           throw new SuppliersValidatorsExceptions().getExternalNumberException();
       }

       if(giro==null || giro.isEmpty()){
           throw new SuppliersValidatorsExceptions().getGiroException();
       }

       if(interiorNumber==null || interiorNumber.isEmpty()){
           throw new SuppliersValidatorsExceptions().getInteriorNumberException();
       }

       if(jerarchyClasification==null || jerarchyClasification.isEmpty()){
           throw new SuppliersValidatorsExceptions().getJerarchyClasificationException();
       }

       if(lada==null || lada.isEmpty()){
           throw new SuppliersValidatorsExceptions().getLadaException();
       }

       if(name==null || name.isEmpty()){
           throw new SuppliersValidatorsExceptions().getNameException();
       }

       if(observations==null || observations.isEmpty()){
           throw new SuppliersValidatorsExceptions().getObservationsException();
       }

       if(paymentMethod==null || paymentMethod.isEmpty()){
           throw new SuppliersValidatorsExceptions().getPaymentMethodException();
       }

       if(payments==null || payments.isEmpty()){
           throw new SuppliersValidatorsExceptions().getPaymentsException();
       }

       if(pers==null || pers.isEmpty()){
           throw new SuppliersValidatorsExceptions().getPersException();
       }

       if(personalPhone1==null || personalPhone1.isEmpty()){
           throw new SuppliersValidatorsExceptions().getPersonalPhone1Exception();
       }

       if(phone==null || phone.isEmpty()){
           throw new SuppliersValidatorsExceptions().getPhoneException();
       }

       if(revision==null || revision.isEmpty()){
           throw new SuppliersValidatorsExceptions().getRevisionException();
       }

       if(rfc==null || rfc.isEmpty()){
           throw new SuppliersValidatorsExceptions().getRfcException();
       }

       if(serie==null || serie.isEmpty()){
           throw new SuppliersValidatorsExceptions().getSerieException();
       }

       if(street==null || street.isEmpty()){
           throw new SuppliersValidatorsExceptions().getStreetException();
       }

       if(telcon3==null || telcon3.isEmpty()){
           throw new SuppliersValidatorsExceptions().getTelcon3Exception();
       }

       if(telcon4==null || telcon4.isEmpty()){
           throw new SuppliersValidatorsExceptions().getTelcon4Exception();
       }

       if(telper3==null || telper3.isEmpty()){
           throw new SuppliersValidatorsExceptions().getTelper3Exception();
       }

       if(telper33==null || telper33.isEmpty()){
           throw new SuppliersValidatorsExceptions().getTelper33Exception();
       }

       if(webpage1==null || webpage1.isEmpty()){
           throw new SuppliersValidatorsExceptions().getWebpage1Exception();
       }

       if(webpage2==null || webpage2.isEmpty()){
           throw new SuppliersValidatorsExceptions().getWebpage2Exception();
       }

       if(zone==null || zone.isEmpty()){
           throw new SuppliersValidatorsExceptions().getZoneException();
       }

       final Supplier Supplier = (Supplier) RepositoryFactory.getInstance().getSuppliersRepository().getByCode(code);
       if(Supplier != null){            
           throw new SuppliersValidatorsExceptions().getModelExistsException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SuppliersValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SuppliersValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SuppliersValidatorsExceptions().getCodeException();
       }

       final Supplier Supplier = (Supplier) RepositoryFactory.getInstance().getSuppliersRepository().getByCode(code);
       if(Supplier == null){            
           throw new SuppliersValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new SuppliersValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}