package com.bdd.soap.implementation;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class CucumberIntegration {

//	AddTwoNumbersService service;
//	AddTwoNumbers webmethod;
//	service = new AddTwoNumbersService();
//	webmethod = service.getAddTwoNumbers();
//	result = webmethod.addNumbers(a, b);

	HttpResponse response;
	String responseXml;
	int result;

	public void getNumbers(int int1, int int2) throws IOException {

		HttpClient httpclient = HttpClients.createDefault();
		StringEntity xmlEntity = new StringEntity(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.soap.bdd.com\"> <soapenv:Header/> <soapenv:Body> <ser:addNumbers> <ser:num1>"
						+ int1 + "</ser:num1> <ser:num2>" + int2
						+ "</ser:num2> </ser:addNumbers> </soapenv:Body> </soapenv:Envelope>");

		HttpPost post = new HttpPost("http://localhost:9090/soap-demo/services/AddTwoNumbers");
		post.setEntity(xmlEntity);
		post.setHeader("Content-type", "text/xml; charset=UTF-8");
		post.setHeader("SOAPAction", "");
		response = httpclient.execute(post);

		try {
			//HttpEntity entity = response.getEntity();
			responseXml = EntityUtils.toString(response.getEntity(), "UTF-8");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(responseXml)));
			doc.getDocumentElement().normalize();
			NodeList properties = doc.getElementsByTagName("addNumbersResponse");

			for (int itr = 0; itr < properties.getLength(); itr++) {
				Node node = properties.item(itr);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					result = Integer
							.parseInt(eElement.getElementsByTagName("addNumbersReturn").item(0).getTextContent());
				}
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
