package kth.id2208.client;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import kth.id2208.dao.Template;
import kth.id2208.service.DocumentOutput;
import sun.misc.BASE64Decoder;

public class Client {

	public static void main(String[] args) throws Exception {
		System.out.println("eDocument Client Application");
		System.out.println("============================");
		System.out.println("Available Services: ");
		System.out.println("[1] Create Template ");
		System.out.println("[2] List Templates ");
		System.out.println("[3] Create Document with selected template ");
		System.out.println("[4] Create Document with system auto selected template ");

		while (true) {
			System.out.print("Select the service: ");
			String serviceIn = new BufferedReader(new InputStreamReader(System.in)).readLine();
			if(serviceIn.equals("1")) {
				System.out.println("'Create Template service' is selected...");
				
			} else if(serviceIn.equals("2")) {
				System.out.println("'List Templates service' is selected...");
				listTemplates();
				
			} else if(serviceIn.equals("3")) {
				System.out.println("'Create Document with selected template' is selected...");
				createDocument();
				
			} else if(serviceIn.equals("4")) {
				System.out.println("'Create Document with system auto selected template' is selected...");
				createAutoDocument();
			} else {
				System.out.println("Invalid Service key");
				break;
			}
		}

	}
	
	private static void listTemplates() throws Exception {
		System.out.println("Available Templates: ");
		List<Template> templates = DocumentProxy.getInstance().listDocument();
		System.out.println("Template ID				Name			Description");
		System.out.println("----------------------------------------------------------------------------------------------");
		for(Template t: templates) {
			System.out.println(t.getId());
		}
		System.out.println("");
	}
	
	private static void createDocument() throws Exception {
		System.out.println("Enter Data file path: ");
		String dataPath = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Read file... ");
		String data = readFile(dataPath);
		System.out.println("Enter Template Id: ");
		String templateId = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Enter Output file path: ");
		String outputPath = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		DocumentOutput output = DocumentProxy.getInstance().createDocument(templateId, data);
		if(output != null) {
			outputPath = outputPath + "/" + System.currentTimeMillis() + "." + output.getType();
			String outputData = output.getData();
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] content = decoder.decodeBuffer(output.getData());
			writeFile(outputPath, content);
			System.out.println("Response document saved at: " + outputPath);
		} else {
			System.out.println("Error in document response");
		}
		
	}
	
	private static void createAutoDocument() throws Exception {
		System.out.println("Enter Data file path: ");
		String dataPath = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Read file... ");
		String data = readFile(dataPath);
		System.out.println("Enter Output file path: ");
		String outputPath = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		DocumentOutput output = DocumentProxy.getInstance().createDocument(data);
		if(output != null) {
			outputPath = outputPath + "/" + System.currentTimeMillis() + "." + output.getType();
			String outputData = output.getData();
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] content = decoder.decodeBuffer(output.getData());
			writeFile(outputPath, content);
			System.out.println("Response document saved at: " + outputPath);
		} else {
			System.out.println("Error in document response");
		}
		
	}
	
	private static String readFile(String path) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
			
		} catch (IOException e) {
			System.out.println("File not found ");
		}  
		
		return new String(encoded, Charset.defaultCharset());
	}
	
	private static void writeFile(String path, byte[] content) throws Exception {
		FileOutputStream stream = new FileOutputStream(path);
		try {
		    stream.write(content);
		} finally {
		    stream.close();
		}
	}
}
