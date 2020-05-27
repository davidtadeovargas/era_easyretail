package com.era.easyretail.validators;

import com.era.easyretail.validators.exceptions.SalessValidatorsExceptions;
import com.era.models.Sales;
import com.era.repositories.RepositoryFactory;

public class SalessValidator extends IValidate{

   private String code;
   private String account;
   private String cashNumber;
   private String certsat;
   private String codeCotizacion;
   private String coinID;
   private String companyCode;
   private String deliverDate;
   private String deliverEmail1;
   private String documentType;
   private String editedDate;
   private String emisionDate;
   private String estatus;
   private String fiscalFolio;
   private String invoiced;
   private String noser;
   private String observation;
   private String paymentForm;
   private String paymentMethod;
   private String razon;
   private String referenceNumber;
   private String salesMan;
   private String sector;
   private String sell;
   private String sellsat;
   private String serie;
   private String station;
   private String subramo;
   private String subtotal;
   private String sucursal;
   private String tax;
   private String ticket;
   private String total;
   private String totalTranslade;
   private String transactionID;
   private String typeExchange;
   private String usocfdi;

   @Override
   public void validateInsert() throws Exception {

       if(account==null || account.isEmpty()){
           throw new SalessValidatorsExceptions().getAccountException();
       }

       if(cashNumber==null || cashNumber.isEmpty()){
           throw new SalessValidatorsExceptions().getCashNumberException();
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

       if(editedDate==null || editedDate.isEmpty()){
           throw new SalessValidatorsExceptions().getEditedDateException();
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

       if(station==null || station.isEmpty()){
           throw new SalessValidatorsExceptions().getStationException();
       }

       if(subramo==null || subramo.isEmpty()){
           throw new SalessValidatorsExceptions().getSubramoException();
       }

       if(subtotal==null || subtotal.isEmpty()){
           throw new SalessValidatorsExceptions().getSubtotalException();
       }

       if(sucursal==null || sucursal.isEmpty()){
           throw new SalessValidatorsExceptions().getSucursalException();
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

       final Sales Sales = (Sales) RepositoryFactory.getInstance().getSalessRepository().getByCode(code);
       if(Sales != null){            
           throw new SalessValidatorsExceptions().getModelExistsException();
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

   @Override
   public void validateDelete() throws Exception {

       if(code==null || code.isEmpty()){
           throw new SalessValidatorsExceptions().getCodeException();
       }

       final Sales Sales = (Sales) RepositoryFactory.getInstance().getSalessRepository().getByCode(code);
       if(Sales == null){            
           throw new SalessValidatorsExceptions().getModelNotExistsException();
       }

       if(IDeleteValidation!=null){
           final boolean response = IDeleteValidation.validate();
           if(!response){
               throw new SalessValidatorsExceptions().getCustomVaidationNotPassedException();
           }
       }
    }
}