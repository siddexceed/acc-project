package com.iexceed.appzillon.ejb;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import com.iexceed.appzillon.accountservice.AccountService;
import com.iexceed.appzillon.accountservice.ServiceController;
import com.iexceed.appzillon.jaxb.AccountMasterQueryReq;
import com.iexceed.appzillon.jaxb.AccountMasterQueryRes;
import com.iexceed.appzillon.utils.JAXBUtils;
import com.iexceed.appzillon.utils.JSONUtils;
import com.iexceed.appzillon.utils.JsonToXMLConverter;
import com.iexceed.appzillon.utils.LoggerUtils;
import com.iexceed.appzillon.utils.MapUtils;

/**
 * Message-Driven Bean implementation class for: AccoundMDB
 */
@MessageDriven(mappedName="jms/AppzillonAccountQueue",activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/AppzillonAccountQueue")})
public class AccountMDB implements MessageListener {

    public static Logger log = LoggerUtils.getLogger();

    @Resource(lookup = "jms/AppzillonAccountCF")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/AppzillonAccountQueueRes")
    private Queue queue;

    /**
     * Default constructor.
     */
    public AccountMDB() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {

        log.info("Message Reached MDB");
        System.out.println("Message Reached MDB");
        String jsonMessage;
        try {
            log.info("CorrelationID::" + message.getJMSCorrelationID());
            jsonMessage = ((TextMessage) message).getText();
            AccountMasterQueryReq accountCreationReq = (AccountMasterQueryReq) JAXBUtils
                    .getUnMarshalled(JsonToXMLConverter.jsonToXml(jsonMessage),
                            "com.iexceed.appzillon.jaxb.AccountMasterQueryReq");
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, 0);
            MessageProducer mproducer = session.createProducer(queue);
            TextMessage tmessage = session.createTextMessage();
            Map<String, String> accountResMap = MapUtils.convertObjectToMap(queryAccount(accountCreationReq));
            tmessage.setText(JSONUtils.getJsonStringFromMap(accountResMap));
            mproducer.send(tmessage);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public AccountMasterQueryRes queryAccount(AccountMasterQueryReq accCreatereq) {
        log.info("Entered EJB");
        log.info("Calling Account Save");
        AccountService accountService = (AccountService) ServiceController
                .getInstance().getService("AccountService");
        log.debug("Account Service Injected::" + accountService);
        return accountService.queryAccount(accCreatereq);

    }

}
