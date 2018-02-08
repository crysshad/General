/**
 * 
 */
package xmlToJson.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.JSONObject;
import org.json.XML;

/**
 * @author Jing
 *
 */
public class Xml2Json {

	/**
	 * 
	 */
	public Xml2Json() {
		super();
	}

	/**
	 * @param args
	 */
	
	private static final int PRETTY_PRINT_INDENT_FACTOR = 4;
	public static void main(String[] args) {

		// get file
		File xmlFile = new File("src/xml.xml");
		Reader fileReader;
		String xml2String = null;
		
		try {
			fileReader = new FileReader(xmlFile);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			StringBuilder sb = new StringBuilder();
			String line = bufferedReader.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = bufferedReader.readLine();
			}
			xml2String = sb.toString();

			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jsonObject = XML.toJSONObject(xml2String);
		
		String jsonPrettyPrintString = jsonObject.toString(PRETTY_PRINT_INDENT_FACTOR);
		System.out.println(jsonPrettyPrintString);
	}

}
