package com.iexceed.appzillon.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import antlr.Utils;

public class JAXBUtils {

    public static Logger log = LoggerUtils.getLogger();

    public static Object getUnMarshalled(String p_inputXMLStr,
            String p_qualifiedClassName) {
        Object l_respObject = null;

        try {
            @SuppressWarnings("rawtypes")
            Class l_c = Class.forName(p_qualifiedClassName);
            log.debug("Class Loaded::" + l_c);
            JAXBContext l_jaxbContext = JAXBContext.newInstance(l_c);
            log.debug("l_jaxbContext::" + l_jaxbContext);
            Unmarshaller l_jaxbUnmarshaller = l_jaxbContext
                    .createUnmarshaller();
            StringReader l_inStringReader = new StringReader(p_inputXMLStr);
            l_respObject = l_jaxbUnmarshaller.unmarshal(l_inStringReader);
        } catch (ClassNotFoundException p_cnfex) {
            p_cnfex.printStackTrace();
        } catch (JAXBException p_jaxex) {
            p_jaxex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("l_respObject:::"+l_respObject);
        return l_respObject;
    }

    public static String getMarshalled(Object p_responseObj,
            String p_qualifiedClassName) {

        String l_response = null;
        try {

            @SuppressWarnings("rawtypes")
            Class l_c = Class.forName(p_qualifiedClassName);

            JAXBContext l_jaxbContext = JAXBContext.newInstance(l_c);

            StringWriter stringWriter = new StringWriter();

            Marshaller l_jaxbmarshaller = l_jaxbContext.createMarshaller();
            l_jaxbmarshaller
                    .setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            l_jaxbmarshaller.marshal(p_responseObj, stringWriter);
            l_response = stringWriter.toString();
        } catch (JAXBException p_jaxex) {
            p_jaxex.printStackTrace();
        } catch (ClassNotFoundException p_cnfex) {
            p_cnfex.printStackTrace();
        }
        return l_response;
    }

}
