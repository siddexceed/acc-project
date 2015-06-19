package com.iexceed.appzillon.utils;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;

public class JsonToXMLConverter {

	public static String jsonToXml(String str) {
		InputStream input = null;
		XMLEventReader reader = null;
		XMLEventWriter writer = null;

		try {
			input = new ByteArrayInputStream(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		StringWriter output = new StringWriter();

		JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false)
				.build();
		try {

			reader = new JsonXMLInputFactory(config)
					.createXMLEventReader(input);
			writer = XMLOutputFactory.newInstance()
					.createXMLEventWriter(output);
			writer.add(reader);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
				input.close();
				reader.close();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return output.toString();
	}
}
