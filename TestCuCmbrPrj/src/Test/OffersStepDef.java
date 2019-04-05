package Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class OffersStepDef {

	//Class Level Vars 
	int cls_numOffers = 0;
	JSONObject cls_jsonRslt = new JSONObject();
	JSONArray cls_jsonArray = new JSONArray();
	String cls_resJStr = "";
	String [] offerNodes = new String []{"offersList", "dataList", "optionalMessage", "links"};
	String [] dataListNodes = new String[] {"customer"};
	JSONObject cls_innerObject = new JSONObject();
	List<String> cls_offeridList  = new ArrayList<String>();
	List<String> cls_emailAddrList  = new ArrayList<String>();
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	// ==== Step Defs ====//
	
	
	@Given("^I have submitted a POST Request via uri$")  // Issue: need Deserialization 
	public void i_have_submitted_a_POST_Request_via() throws ClientProtocolException, IOException, JSONException {
		 long actl = 0;   long expd = 0;
		CloseableHttpClient client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost("http://hateos-test-hateos-test.7e14.starter-us-west-2.openshiftapps.com/offers");
	    
	    httpPost.setHeader("Content-type", "application/json");
	    httpPost.setHeader("Accept", "application/json");
	    String jsonstr = "{}";
	    StringEntity entity = new StringEntity(jsonstr);
	    httpPost.setEntity(entity);
        CloseableHttpResponse response = client.execute(httpPost);
	    
	    if (response.getEntity().getContentLength() != 0 ) {
		  	
	    	String resJStr = EntityUtils.toString(response.getEntity());
	    	System.out.println (">>== RAW  Response Body = "+ resJStr);
	    	
	    	// OPTN (1):  FAILS with  org.json.JSONException: A JSONObject text must begin with '{' at 1 [character 2 line 1]
		    /**/
		    	JSONObject jsonRslt = new JSONObject(resJStr);
		    	JSONArray jsonArray = jsonRslt.getJSONArray("array");
		  /*  */
	    	
	    	
		//TO DO: fix issue > A JSONObject text must begin with '{' at 0 [character 1 line 1]
	    	// impact: stops convert to Json object,
	    	//Capture the Response Body 
	       

		/*	// OPTN 4 
	    	ObjectMapper mapper = Json.mapper();
            TypeFactory typeFactory = mapper.getTypeFactory();
	    	
	    	MapType mapType = 
	    	    typeFactory.constructMapType((Class<? extends Map>) HashMap.class, String.class, Item.class);
	    	Map<String, Item> map = mapper.readValue(resJStr, mapType);
	    	
	    	List<Item> list = map.values();
	    */
	    	
	    
		// OTPN (2) FAILS with  begin with '{' err
		    	// Trim the JSon String via builder  
		    /*  StringBuilder strb  = new StringBuilder(resJStr);    
		       	strb.replace(1, 1, ""); 
		       	int index = strb.lastIndexOf("]");    
		    	strb.replace(index,(1 + index), "");    
		    	resJStr = strb.toString();
		      	System.out.println ("==>>> CLEANED Json Str resp = "+ strb.toString() );
		    */
	  	
	    // OPTN (3):  FAILS with  begin with '{' err
	    /*	BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
	    	String result ="";
	    	String output = null;
	        while ((result = br.readLine()) != null) {
	    	    output = result.replace("[", "").replace("]", "");
	    	    JSONObject jsonObject = new JSONObject(output); 
	    	    JSONArray jsonArray = new JSONArray(output); 
	    	}
	    */	
	   
	    	
	    		    	
	    	/*
	     	// Convert JsonString to JsonArray 
	        JSONObject jsonRslt = new JSONObject(resJStr);
	    	String[] offers = JSONObject.getNames(jsonRslt);
	        JSONArray jsonArray = jsonRslt.toJSONArray(new JSONArray(offers));
	        
	        */
	        
	    	System.out.println ("======");
	    	System.out.println (jsonArray);
	    	System.out.println ("=======");
	    	//System.out.println ("Number of Offers in JsonObj:" + jsonRslt.length() );
	 	    System.out.println ("Number of Offers in jsonArray :" + jsonArray.length() );
	    	
	        //Note the Number of Offer returned & Pass obj to Class 
	 		cls_numOffers = jsonArray.length();
	 		cls_jsonArray = jsonArray;
	 		cls_jsonRslt = jsonRslt;
	 		cls_resJStr = resJStr; 
	    }
	   else {
		
		   // When Failed Request or No data 
		  actl = -1;
	      assertEquals(" FAIL = POST Returned NO DATA = Status Code: "+ response.getStatusLine().getStatusCode(), expd, actl); 
	   
	   } 
	    
	   
	   
	    // Verify POST was Successful 
	    if (response.getStatusLine().getStatusCode() == 200) {
	    	actl = 0;
	    	assertEquals("PASS = POST was Successful...Status Code: "+ response.getStatusLine().getStatusCode(), expd, actl); 
	    } 
        else {
        	 actl = -1;
	    	 assertEquals(" FAIL = POST was Failed...Status Code: "+ response.getStatusLine().getStatusCode(), expd, actl); 
        } 
        
        	
	    client.close();
		System.out.println (" ======= Successful END: I have submitted a POST Request  ====== ");
	    
	}

	// Done - input Limits
	
	
	@When("^I verify or count the number of Offers JSON Objects returned$")
	public void i_verify_count_the_of_Offers_JSON_Objects_returned() {
	 		//  get  the current Offer Count 
		cls_numOffers = cls_jsonArray.length();
		
		System.out.println ("The number of Offers is equal to ("+ cls_jsonArray.length() +")");
	}

	@Then("^The total number of offers objects will be five$")
	public void the_total_number_of_offers_objects_will_be() {
		
		//assertThat(cls_numOffers, equals(5));
		 long actl = 0;   long expd = 0;
		 
		    // Verify number of offers  
		    if (cls_numOffers ==  5) {
		    	 actl = 0;
		    	 assertEquals(" PASS = number of offers...Value: "+ cls_numOffers, expd, actl); 
		    } 
	        else {
	        	 actl = -1;
		    	 assertEquals(" FAIL = number of offers not 5...Value: "+ cls_numOffers, expd, actl); 
	        } 
	 
		//System.out.println (" The total number of offers objects Actl: "+ cls_numOffers + " vs Expd: 5" );
	}

	//
	
	@When("^I verify or review the offer_id from the OfferList$")
	public void i_verify_review_the_from_the_OfferList() {
	
		// use current cls_jsonArray
		for (int i = 0; i < cls_jsonArray.length(); i++) {
	        	
			// Create Offer json Objects from base Json Array 
			JSONObject json_offer_obj = cls_jsonArray.getJSONObject(i); //
			
			//find the offerList Node in the offerObj 
			for(int x = 0; x<json_offer_obj.names().length(); x++){
				
				System.out.println ( "key = " + json_offer_obj.names().getString(x) + " value = " + json_offer_obj.get(json_offer_obj.names().getString(x)));
			
				// Find the Path to Offer Id 
				if (json_offer_obj.names().getString(x) == "offersList" ) { // note its a jsnArry 
				 	JSONArray offersList_jsonAry = json_offer_obj.toJSONArray(new JSONArray("offersList"));
				 	JSONObject  innerObject = (JSONObject) offersList_jsonAry.get(0);
				   
				    //Search Keys of inner Object of offersList
	                Iterator<String> innerKeys = innerObject.keys();
	                 while(innerKeys.hasNext()) {
	                        String innerKey = innerKeys.next();
	                        if ( innerKey == "offer_id") {
	                      
	                        	// Get the offer id and add it to the cls_offeridList  for testing in next step
	                        	cls_offeridList.add(innerObject.get(innerKey).toString());

	                        	System.out.println (" JsonNode ID:" + i + "key = " + innerKey + " value = " + innerObject.get(innerKey).toString());
	                        	        	
	                        break;
	                       } //end if 
	                 }//end while 
	                 
	                 break;
				}//end if (json_offer_obj.name
		   }// end for..cls_jsonArray
		} // end for (int i = 0;
		
		System.out.println (" ===== END:  I verify or review the offer_id ");
	} 

	@Then("^The Offer_ID will be valid and NOT Null$")
	public void the_Offer_ID_will_be_valid_and_NOT_Null() {
	
		 long actl = 0;   long expd = 0;
		 
		// validate the list of given offer_IDs
	    int cntr  = 0; 
		for (Iterator<String> iter =  cls_offeridList.iterator(); iter.hasNext(); ) {
		    String value  = iter.next();
		    
		    // To do: add regEx for df099b64-d269-421d-bc95-c2af037dcc3b 
		  
			   // assertThat(value.toString().length(), equals(36));
			    if (value.toString().length() == 36) {
			    	 actl = 0;
			    	 assertEquals(" PASS =  ID Counter:" + cntr + "Offer ID = " + value.toString(), expd, actl); 
			    } 
		        else {
		        	 actl = -1;
			    	 assertEquals( " FAIL =  ID Counter:" + cntr + "Offer ID = " + value.toString(), expd, actl); 
		        } 
		    
		  //  System.out.println ("ID Counter:" + cntr + "Offer ID = " + value.toString() );
		    
		    cntr++;
		}//for (Iterator<String> 
	
		
		System.out.println ("====END: The Offer_ID will be valid and NOT Null");
	}

	//
	
	@When("^I verify or review the emailadr from Customer Object$")
	public void i_verify_or_review_the_emailadr_from_Customer_Object() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		//"dataList"
		
		// use current cls_jsonArray
				for (int i = 0; i < cls_jsonArray.length(); i++) {
			        	
					// Create Offer json Objects from base Json Array 
					JSONObject json_offer_obj = cls_jsonArray.getJSONObject(i); //
					
					//find the dataList Node in the offerObj 
					for(int x = 0; x<json_offer_obj.names().length(); x++){
						
						System.out.println ( "key = " + json_offer_obj.names().getString(x) + " value = " + json_offer_obj.get(json_offer_obj.names().getString(x)));
					
						// Find the Path to Customer  
						if (json_offer_obj.names().getString(x) == "dataList" ) { // note its a jsnobj
							
							// Assoc dataList Json Obj 
							JSONObject dataList_jsonObj = json_offer_obj.getJSONObject("dataList");
							
							//from dataList locate Customer jsnAry
							JSONArray  cust_JsonAry = dataList_jsonObj.toJSONArray(new JSONArray("customer"));
							JSONObject innerObject = (JSONObject) cust_JsonAry.get(0);
						   
						    //Search Keys of inner Object of customer
			                Iterator<String> innerKeys = innerObject.keys();
			                 while(innerKeys.hasNext()) {
			                        String innerKey = innerKeys.next();
			                        if ( innerKey == "emailAdr") {
			                      
			                        	// Get the emailAdr and add it to the cls_emailAddrList  for testing in next step
			                        	cls_emailAddrList.add(innerObject.get(innerKey).toString());

			                        	System.out.println (" JsonNode ID:" + i + "key = " + innerKey + " value = " + innerObject.get(innerKey).toString());
			                        	        	
			                        break;
			                       } //end if 
			                 }//end while 
			                 
			                 break;
						}//end if (json_offer_obj.name
				   }// end for..cls_jsonArray
				} // end for (int i = 0;
		
	
		
		System.out.println (" I verify or review the Email ");
	}

	@Then("^The format of the email is Valid and NOT Null$")
	public void the_format_of_the_email_is_Valid_and_NOT_Null() {
	   
		 long actl = 0;   long expd = 0;
		 
		// validate the list of given email IDs
	    int cntr = 0; 
		for (Iterator<String> iter =  cls_emailAddrList.iterator(); iter.hasNext(); ) {
		    String value  = iter.next();
		    
		    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);
	       
		    // assertThat("Email ("+ value + ")  is Valid for Node:",  chk, 0) ; 
		    if (matcher.find() == true) {
		    	 actl = 0;
		    	 assertEquals( "PASS = Email ("+ value + ")  is Valid for Node:" + cntr, expd, actl); 
		    } 
	        else {
	        	 actl = -1;
		    	 assertEquals( "FAILED = Email ("+ value + ")  is Valid for Node:" + cntr, expd, actl); 
	        } 
   
		   
		   //System.out.println ("offfer Node:" + cntr + "email ID = " + value.toString() );
		    
		    cntr++;
		}//for (Iterator<String> iter
		
		
		System.out.println ("=== END: The format of the email is Valid and NOT Null");
	}
	
	
	
}
