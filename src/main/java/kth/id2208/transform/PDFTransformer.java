/**
 * 
 */
package kth.id2208.transform;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kth.id2208.service.DocumentOutput;
import kth.id2208.util.B64Encoder;

/**
 * @author pradeeppeiris
 *
 */
public class PDFTransformer extends XSLTranformer {

	private static final Logger log = LoggerFactory.getLogger(PDFTransformer.class);
	
	
	private static PDFTransformer instance;

	private FopFactory fopFactory;

	private PDFTransformer() {
		fopFactory = FopFactory.newInstance(new File(".").toURI());
	}

	public static PDFTransformer getInstance() {
		if (instance == null) {
			instance = new PDFTransformer();
		}
		return instance;
	}

	@Override
	public DocumentOutput transform(String template, String data) throws Exception {
		log.info("Transform to pdf document");
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] content = null;
		try {
			
			String xslfo = xslTransform(template, data);

			System.out.println(xslfo);
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outStream);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();

			Source src = new StreamSource(new StringReader(xslfo));
			Result res = new SAXResult(fop.getDefaultHandler());

			transformer.transform(src, res);
			content = outStream.toByteArray();
		} finally {
			outStream.close();
		}

		DocumentOutput output = new DocumentOutput();
		output.setType("pdf");
		output.setData(B64Encoder.encode(content));
		
		return output;
	}
}
