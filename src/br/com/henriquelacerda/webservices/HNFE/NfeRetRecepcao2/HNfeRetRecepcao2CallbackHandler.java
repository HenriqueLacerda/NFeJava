
/**
 * NfeRetRecepcao2CallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.2  Built on : Sep 06, 2010 (09:42:01 CEST)
 */

    package br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeRetRecepcao2;

    /**
     *  NfeRetRecepcao2CallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HNfeRetRecepcao2CallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HNfeRetRecepcao2CallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HNfeRetRecepcao2CallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for nfeRetRecepcao2 method
            * override this method for handling normal response from nfeRetRecepcao2 operation
            */
           public void receiveResultnfeRetRecepcao2(
                    br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeRetRecepcao2.HNfeRetRecepcao2Stub.NfeRetRecepcao2Result result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from nfeRetRecepcao2 operation
           */
            public void receiveErrornfeRetRecepcao2(java.lang.Exception e) {
            }
                


    }
    