/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iexceed.appzillon.accountservice;

import com.iexceed.appzillon.jaxb.AccountCreationReq;
import com.iexceed.appzillon.utils.JAXBUtils;
import static com.iexceed.appzillon.utils.JAXBUtils.log;
import com.iexceed.appzillon.utils.LoggerUtils;
import java.io.StringReader;
import java.util.logging.Level;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;

/**
 *
 * @author admin
 */
public class TestJAXB {

    public static Logger log = LoggerUtils.getLogger();

    public void testJAXB() throws JAXBException, ClassNotFoundException {
        Class l_c = Class.forName("com.iexceed.appzillon.jaxb.AccountCreationReq");

        log.debug(
                "Class Loaded::" + l_c);
        JAXBContext l_jaxbContext = JAXBContext.newInstance(l_c);

        log.debug(
                "l_jaxbContext::" + l_jaxbContext);
        Unmarshaller l_jaxbUnmarshaller = l_jaxbContext
                .createUnmarshaller();
        StringReader l_inStringReader = new StringReader("<?xml version='1.0' encoding='UTF-8'?><AccountCreationReq><ClearingAmt>150</ClearingAmt><LineAmt>100</LineAmt><CurrentBal>200</CurrentBal><LastTransactionDate>2014-01-02</LastTransactionDate><AccountAddress>iexceed</AccountAddress><AccountType>saving</AccountType><AccountName>sai</AccountName><CustomerId>234</CustomerId><WithdrawableBal>100</WithdrawableBal><AccountNum>456</AccountNum><CreationDate>2014-01-02</CreationDate><AccountCurrency>rupee</AccountCurrency></AccountCreationReq>");
        AccountCreationReq accountCreationReq = (AccountCreationReq)l_jaxbUnmarshaller.unmarshal(l_inStringReader);
        System.out.println("accountCreationReq"+accountCreationReq.toString());
    }
    
    public static void main(String args[]) {
        try {
            new TestJAXB().testJAXB();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
