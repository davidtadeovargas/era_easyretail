package com.era.easyretail.validators.exceptions;

public class SalessValidatorsExceptions {

   private static SalessValidatorsExceptions SalessValidatorsExceptions;

   public static SalessValidatorsExceptions getSigleton(){
       if(SalessValidatorsExceptions==null){SalessValidatorsExceptions = new SalessValidatorsExceptions();}return SalessValidatorsExceptions;
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

   public Exception getCertsatException(){
       return new Exception("Falta espeficiar Certsat");
   }

   public Exception getCodeCotizacionException(){
       return new Exception("Falta espeficiar CodeCotizacion");
   }

   public Exception getCoinIDException(){
       return new Exception("Falta espeficiar CoinID");
   }

   public Exception getCompanyCodeException(){
       return new Exception("Falta espeficiar CompanyCode");
   }

   public Exception getDeliverDateException(){
       return new Exception("Falta espeficiar DeliverDate");
   }

   public Exception getDeliverEmail1Exception(){
       return new Exception("Falta espeficiar DeliverEmail1");
   }

   public Exception getDocumentTypeException(){
       return new Exception("Falta espeficiar DocumentType");
   }

   public Exception getEmisionDateException(){
       return new Exception("Falta espeficiar EmisionDate");
   }

   public Exception getEstatusException(){
       return new Exception("Falta espeficiar Estatus");
   }

   public Exception getFiscalFolioException(){
       return new Exception("Falta espeficiar FiscalFolio");
   }

   public Exception getInvoicedException(){
       return new Exception("Falta espeficiar Invoiced");
   }

   public Exception getNoserException(){
       return new Exception("Falta espeficiar Noser");
   }

   public Exception getObservationException(){
       return new Exception("Falta espeficiar Observation");
   }

   public Exception getPaymentFormException(){
       return new Exception("Falta espeficiar PaymentForm");
   }

   public Exception getPaymentMethodException(){
       return new Exception("Falta espeficiar PaymentMethod");
   }

   public Exception getRazonException(){
       return new Exception("Falta espeficiar Razon");
   }

   public Exception getReferenceNumberException(){
       return new Exception("Falta espeficiar ReferenceNumber");
   }

   public Exception getSalesManException(){
       return new Exception("Falta espeficiar SalesMan");
   }

   public Exception getSectorException(){
       return new Exception("Falta espeficiar Sector");
   }

   public Exception getSellException(){
       return new Exception("Falta espeficiar Sell");
   }

   public Exception getSellsatException(){
       return new Exception("Falta espeficiar Sellsat");
   }

   public Exception getSerieException(){
       return new Exception("Falta espeficiar Serie");
   }

   public Exception getSubramoException(){
       return new Exception("Falta espeficiar Subramo");
   }

   public Exception getSubtotalException(){
       return new Exception("Falta espeficiar Subtotal");
   }

   public Exception getTaxException(){
       return new Exception("Falta espeficiar Tax");
   }

   public Exception getTicketException(){
       return new Exception("Falta espeficiar Ticket");
   }

   public Exception getTotalException(){
       return new Exception("Falta espeficiar Total");
   }

   public Exception getTotalTransladeException(){
       return new Exception("Falta espeficiar TotalTranslade");
   }

   public Exception getTransactionIDException(){
       return new Exception("Falta espeficiar TransactionID");
   }

   public Exception getTypeExchangeException(){
       return new Exception("Falta espeficiar TypeExchange");
   }

   public Exception getUsocfdiException(){
       return new Exception("Falta espeficiar Usocfdi");
   }

}