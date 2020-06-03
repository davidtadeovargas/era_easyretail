package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SuppliersValidatorsExceptions;
import com.era.models.Supplier;
import com.era.repositories.RepositoryFactory;

public class SuppliersValidator extends IValidate{

   private String account;
   public void setAccount(String property){
       this.account = property;
   }

   private String bank;
   public void setBank(String property){
       this.bank = property;
   }

   private String bloq;
   public void setBloq(String property){
       this.bloq = property;
   }

   private String bloqlimcred;
   public void setBloqlimcred(String property){
       this.bloqlimcred = property;
   }

   private String celphone;
   public void setCelphone(String property){
       this.celphone = property;
   }

   private String city;
   public void setCity(String property){
       this.city = property;
   }

   private String clasificationCode;
   public void setClasificationCode(String property){
       this.clasificationCode = property;
   }

   private String claveBank;
   public void setClaveBank(String property){
       this.claveBank = property;
   }

   private String code;
   public void setCode(String property){
       this.code = property;
   }

   private String colony;
   public void setColony(String property){
       this.colony = property;
   }

   private String contableAccount;
   public void setContableAccount(String property){
       this.contableAccount = property;
   }

   private String contac4;
   public void setContac4(String property){
       this.contac4 = property;
   }

   private String country;
   public void setCountry(String property){
       this.country = property;
   }

   private String cp;
   public void setCp(String property){
       this.cp = property;
   }

   private String creditDays;
   public void setCreditDays(String property){
       this.creditDays = property;
   }

   private String deliverCP;
   public void setDeliverCP(String property){
       this.deliverCP = property;
   }

   private String deliverCellphone;
   public void setDeliverCellphone(String property){
       this.deliverCellphone = property;
   }

   private String deliverCity;
   public void setDeliverCity(String property){
       this.deliverCity = property;
   }

   private String deliverColony;
   public void setDeliverColony(String property){
       this.deliverColony = property;
   }

   private String deliverCountry;
   public void setDeliverCountry(String property){
       this.deliverCountry = property;
   }

   private String deliverEmail1;
   public void setDeliverEmail1(String property){
       this.deliverEmail1 = property;
   }

   private String deliverEmail2;
   public void setDeliverEmail2(String property){
       this.deliverEmail2 = property;
   }

   private String deliverEmail3;
   public void setDeliverEmail3(String property){
       this.deliverEmail3 = property;
   }

   private String deliverEstate;
   public void setDeliverEstate(String property){
       this.deliverEstate = property;
   }

   private String deliverInternalNumber;
   public void setDeliverInternalNumber(String property){
       this.deliverInternalNumber = property;
   }

   private String deliverLada;
   public void setDeliverLada(String property){
       this.deliverLada = property;
   }

   private String deliverStreet;
   public void setDeliverStreet(String property){
       this.deliverStreet = property;
   }

   private String deliveryExternalNumber;
   public void setDeliveryExternalNumber(String property){
       this.deliveryExternalNumber = property;
   }

   private String disccount;
   public void setDisccount(String property){
       this.disccount = property;
   }

   private String email1;
   public void setEmail1(String property){
       this.email1 = property;
   }

   private String email2;
   public void setEmail2(String property){
       this.email2 = property;
   }

   private String email3;
   public void setEmail3(String property){
       this.email3 = property;
   }

   private String estate;
   public void setEstate(String property){
       this.estate = property;
   }

   private String extension;
   public void setExtension(String property){
       this.extension = property;
   }

   private String externalNumber;
   public void setExternalNumber(String property){
       this.externalNumber = property;
   }

   private String giro;
   public void setGiro(String property){
       this.giro = property;
   }

   private String interiorNumber;
   public void setInteriorNumber(String property){
       this.interiorNumber = property;
   }

   private String jerarchyClasification;
   public void setJerarchyClasification(String property){
       this.jerarchyClasification = property;
   }

   private String lada;
   public void setLada(String property){
       this.lada = property;
   }

   private String name;
   public void setName(String property){
       this.name = property;
   }

   private String observations;
   public void setObservations(String property){
       this.observations = property;
   }

   private String paymentMethod;
   public void setPaymentMethod(String property){
       this.paymentMethod = property;
   }

   private String payments;
   public void setPayments(String property){
       this.payments = property;
   }

   private String pers;
   public void setPers(String property){
       this.pers = property;
   }

   private String personalPhone1;
   public void setPersonalPhone1(String property){
       this.personalPhone1 = property;
   }

   private String phone;
   public void setPhone(String property){
       this.phone = property;
   }

   private String revision;
   public void setRevision(String property){
       this.revision = property;
   }

   private String rfc;
   public void setRfc(String property){
       this.rfc = property;
   }

   private String serie;
   public void setSerie(String property){
       this.serie = property;
   }

   private String street;
   public void setStreet(String property){
       this.street = property;
   }

   private String telcon3;
   public void setTelcon3(String property){
       this.telcon3 = property;
   }

   private String telcon4;
   public void setTelcon4(String property){
       this.telcon4 = property;
   }

   private String telper3;
   public void setTelper3(String property){
       this.telper3 = property;
   }

   private String telper33;
   public void setTelper33(String property){
       this.telper33 = property;
   }

   private String webpage1;
   public void setWebpage1(String property){
       this.webpage1 = property;
   }

   private String webpage2;
   public void setWebpage2(String property){
       this.webpage2 = property;
   }

   private String zone;
   public void setZone(String property){
       this.zone = property;
   }


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

}