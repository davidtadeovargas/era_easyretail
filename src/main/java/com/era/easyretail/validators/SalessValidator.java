package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SalessValidatorsExceptions;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;

public class SalessValidator extends IValidate{

   private String account;
   public void setAccount(String property){
       this.account = property;
   }

   private String certsat;
   public void setCertsat(String property){
       this.certsat = property;
   }

   private String codeCotizacion;
   public void setCodeCotizacion(String property){
       this.codeCotizacion = property;
   }

   private String coinID;
   public void setCoinID(String property){
       this.coinID = property;
   }

   private String companyCode;
   public void setCompanyCode(String property){
       this.companyCode = property;
   }

   private String deliverDate;
   public void setDeliverDate(String property){
       this.deliverDate = property;
   }

   private String deliverEmail1;
   public void setDeliverEmail1(String property){
       this.deliverEmail1 = property;
   }

   private String documentType;
   public void setDocumentType(String property){
       this.documentType = property;
   }

   private String emisionDate;
   public void setEmisionDate(String property){
       this.emisionDate = property;
   }

   private String estatus;
   public void setEstatus(String property){
       this.estatus = property;
   }

   private String fiscalFolio;
   public void setFiscalFolio(String property){
       this.fiscalFolio = property;
   }

   private String invoiced;
   public void setInvoiced(String property){
       this.invoiced = property;
   }

   private String noser;
   public void setNoser(String property){
       this.noser = property;
   }

   private String observation;
   public void setObservation(String property){
       this.observation = property;
   }

   private String paymentForm;
   public void setPaymentForm(String property){
       this.paymentForm = property;
   }

   private String paymentMethod;
   public void setPaymentMethod(String property){
       this.paymentMethod = property;
   }

   private String razon;
   public void setRazon(String property){
       this.razon = property;
   }

   private String referenceNumber;
   public void setReferenceNumber(String property){
       this.referenceNumber = property;
   }

   private String salesMan;
   public void setSalesMan(String property){
       this.salesMan = property;
   }

   private String sector;
   public void setSector(String property){
       this.sector = property;
   }

   private String sell;
   public void setSell(String property){
       this.sell = property;
   }

   private String sellsat;
   public void setSellsat(String property){
       this.sellsat = property;
   }

   private String serie;
   public void setSerie(String property){
       this.serie = property;
   }

   private String subramo;
   public void setSubramo(String property){
       this.subramo = property;
   }

   private String subtotal;
   public void setSubtotal(String property){
       this.subtotal = property;
   }

   private String tax;
   public void setTax(String property){
       this.tax = property;
   }

   private String ticket;
   public void setTicket(String property){
       this.ticket = property;
   }

   private String total;
   public void setTotal(String property){
       this.total = property;
   }

   private String totalTranslade;
   public void setTotalTranslade(String property){
       this.totalTranslade = property;
   }

   private String transactionID;
   public void setTransactionID(String property){
       this.transactionID = property;
   }

   private String typeExchange;
   public void setTypeExchange(String property){
       this.typeExchange = property;
   }

   private String usocfdi;
   public void setUsocfdi(String property){
       this.usocfdi = property;
   }


   @Override
   public void validateInsert() throws Exception {

       if(account==null || account.isEmpty()){
           throw new SalessValidatorsExceptions().getAccountException();
       }

       if(certsat==null || certsat.isEmpty()){
           throw new SalessValidatorsExceptions().getCertsatException();
       }

       if(codeCotizacion==null || codeCotizacion.isEmpty()){
           throw new SalessValidatorsExceptions().getCodeCotizacionException();
       }

       if(coinID==null || coinID.isEmpty()){
           throw new SalessValidatorsExceptions().getCoinIDException();
       }

       if(companyCode==null || companyCode.isEmpty()){
           throw new SalessValidatorsExceptions().getCompanyCodeException();
       }

       if(deliverDate==null || deliverDate.isEmpty()){
           throw new SalessValidatorsExceptions().getDeliverDateException();
       }

       if(deliverEmail1==null || deliverEmail1.isEmpty()){
           throw new SalessValidatorsExceptions().getDeliverEmail1Exception();
       }

       if(documentType==null || documentType.isEmpty()){
           throw new SalessValidatorsExceptions().getDocumentTypeException();
       }

       if(emisionDate==null || emisionDate.isEmpty()){
           throw new SalessValidatorsExceptions().getEmisionDateException();
       }

       if(estatus==null || estatus.isEmpty()){
           throw new SalessValidatorsExceptions().getEstatusException();
       }

       if(fiscalFolio==null || fiscalFolio.isEmpty()){
           throw new SalessValidatorsExceptions().getFiscalFolioException();
       }

       if(invoiced==null || invoiced.isEmpty()){
           throw new SalessValidatorsExceptions().getInvoicedException();
       }

       if(noser==null || noser.isEmpty()){
           throw new SalessValidatorsExceptions().getNoserException();
       }

       if(observation==null || observation.isEmpty()){
           throw new SalessValidatorsExceptions().getObservationException();
       }

       if(paymentForm==null || paymentForm.isEmpty()){
           throw new SalessValidatorsExceptions().getPaymentFormException();
       }

       if(paymentMethod==null || paymentMethod.isEmpty()){
           throw new SalessValidatorsExceptions().getPaymentMethodException();
       }

       if(razon==null || razon.isEmpty()){
           throw new SalessValidatorsExceptions().getRazonException();
       }

       if(referenceNumber==null || referenceNumber.isEmpty()){
           throw new SalessValidatorsExceptions().getReferenceNumberException();
       }

       if(salesMan==null || salesMan.isEmpty()){
           throw new SalessValidatorsExceptions().getSalesManException();
       }

       if(sector==null || sector.isEmpty()){
           throw new SalessValidatorsExceptions().getSectorException();
       }

       if(sell==null || sell.isEmpty()){
           throw new SalessValidatorsExceptions().getSellException();
       }

       if(sellsat==null || sellsat.isEmpty()){
           throw new SalessValidatorsExceptions().getSellsatException();
       }

       if(serie==null || serie.isEmpty()){
           throw new SalessValidatorsExceptions().getSerieException();
       }

       if(subramo==null || subramo.isEmpty()){
           throw new SalessValidatorsExceptions().getSubramoException();
       }

       if(subtotal==null || subtotal.isEmpty()){
           throw new SalessValidatorsExceptions().getSubtotalException();
       }

       if(tax==null || tax.isEmpty()){
           throw new SalessValidatorsExceptions().getTaxException();
       }

       if(ticket==null || ticket.isEmpty()){
           throw new SalessValidatorsExceptions().getTicketException();
       }

       if(total==null || total.isEmpty()){
           throw new SalessValidatorsExceptions().getTotalException();
       }

       if(totalTranslade==null || totalTranslade.isEmpty()){
           throw new SalessValidatorsExceptions().getTotalTransladeException();
       }

       if(transactionID==null || transactionID.isEmpty()){
           throw new SalessValidatorsExceptions().getTransactionIDException();
       }

       if(typeExchange==null || typeExchange.isEmpty()){
           throw new SalessValidatorsExceptions().getTypeExchangeException();
       }

       if(usocfdi==null || usocfdi.isEmpty()){
           throw new SalessValidatorsExceptions().getUsocfdiException();
       }

       if(IInsertValidation!=null){
            final boolean response = IInsertValidation.validate();
            if(!response){
                throw new SalessValidatorsExceptions().getCustomVaidationNotPassedException();
            }                
        }

   }

   @Override
   public void validateUpdate() throws Exception {

       this.validateInsert();

       if(IUpdateValidation!=null){
           final boolean response = IUpdateValidation.validate();
           if(!response){
               throw new SalessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
   }

}