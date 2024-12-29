package BasicTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppTest 
   
{

   @Test(dataProvider = "datap")
   public void run(HashMap<String, String> data)
   {
	   System.out.println("entered jenkins integration");
	   
	   System.out.println(data.get("name"));
	   System.out.println(data.get("son"));
   }
   
   @DataProvider
   public Object[][] datap() throws IOException {
	   
	   String dataFile= "C://Users//seeni//eclipse-workspace//jenkinsTraining//src//test//java//BasicTest//data.json";
	   
	   List<HashMap<String,String>> datas= getdata(dataFile);
	   
	   return new Object[][] {{datas.get(0)}};
   }

private List<HashMap<String, String>> getdata(String dataFile) throws IOException {
	// TODO Auto-generated method stub
	String str= FileUtils.readFileToString(new File(dataFile), StandardCharsets.UTF_8);
	ObjectMapper map= new ObjectMapper();
	List<HashMap<String,String>>mapData=map.readValue(str, new TypeReference<List<HashMap<String,String>>>() {});
	return mapData;
}
}
