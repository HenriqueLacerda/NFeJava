
/**
 * NfeRecepcao2CallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.2  Built on : Sep 06, 2010 (09:42:01 CEST)
 */

    package br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeRecepcao2;

    /**
     *  NfeRecepcao2CallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HNfeRecepcao2CallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HNfeRecepcao2CallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HNfeRecepcao2CallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for nfeRecepcaoLote2 method
            * override this method for handling normal response from nfeRecepcaoLote2 operation
            */
           public void receiveResultnfeRecepcaoLote2(
                    br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeRecepcao2.HNfeRecepcao2Stub.NfeRecepcaoLote2Result result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from nfeRecepcaoLote2 operation
           */
            public void receiveErrornfeRecepcaoLote2(java.lang.Exception e) {
            }
                


    }
    