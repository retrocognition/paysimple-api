package com.retro.paysimple.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectorFactory {
    // logging
    private static final Logger _log = LoggerFactory.getLogger(ConnectorFactory.class);

//    /**
//     * returns the connector impl for this property management group
//     * @param manager
//     * @return
//     * @throws PlatformException 
//     */
//    public static UnitConnector getUnitConnector(PropertyManager manager, Community community) throws PlatformException {
//        _log.debug("looking up unit connector for property manager [{}]", manager);
//        Preconditions.checkNotNull(manager, "property manager cannot be null!");
//        // sanity check the integration type
//        if (manager.getBackendIntegrationType() == null) {
//            _log.warn("property manager has no integration type");
//            throw new PlatformException("property manager [" + manager + "] has no integration type");
//        }
//
//        // check the integration type
//        if (manager.getBackendIntegrationType().equalsIgnoreCase("ONESITE")) {
//            _log.debug("using onesite integration client");
//            OneSiteUnitViaPMConnector connector = new OneSiteUnitViaPMConnector(manager, community);
//            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
//            messageFactory.afterPropertiesSet();
//            return connector;
//        }
//        
//        if (manager.getBackendIntegrationType().equalsIgnoreCase("YARDIAPI")) {
//            _log.debug("using yardi api integration client");
//            YardiApiUnitConnector connector = new YardiApiUnitConnector(manager, community);
//            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
//            messageFactory.afterPropertiesSet();
//            return connector;
//        }
//
//        // yard clients
//        // message factory
//        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
//        messageFactory.afterPropertiesSet();
//        // web service template
//        WebServiceTemplate template = new WebServiceTemplate(messageFactory);
//        // set the properties
//        template.setDefaultUri(manager.getBackendIntegrationUrl());
//        // use our custom message sender
//        template.setMessageSender(new UrlFetchHttpsUrlConnectionMessageSender());
//        UnitConnector connector = null;
//        // finally the connector (check for echelon)
//        if (community.getPropertyManagerId() == 642) {
//            _log.debug("using echelon connector");
//            connector = new EchelonUnitConnector(manager, community);
//        } else {
//            // generic
//            _log.debug("using generic yardi connector");
//            connector = new YardiUnitConnector(manager, community);
//        }
//
//        // yardi cases
//        //            if community.propertyId == 56:
//        //                logging.debug("using parker integration client")
//        //                pwsClient = ParkerWebServiceClient(community)
//        //            else:
//        //                logging.debug("using default integration client")
//        //                # grab the default yardi client
//        //                pwsClient = PowerWebServiceClient(community)
//
//        return connector;
//    }
}
