$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Offers.feature");
formatter.feature({
  "name": "Offers",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the Total Number of offers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have submitted a POST Request via uri",
  "keyword": "Given "
});
formatter.match({
  "location": "OffersStepDef.i_have_submitted_a_POST_Request_via()"
});
formatter.result({
  "error_message": "org.json.JSONException: A JSONObject text must begin with \u0027{\u0027 at 1 [character 2 line 1]\r\n\tat org.json.JSONTokener.syntaxError(JSONTokener.java:505)\r\n\tat org.json.JSONObject.\u003cinit\u003e(JSONObject.java:215)\r\n\tat org.json.JSONObject.\u003cinit\u003e(JSONObject.java:399)\r\n\tat Test.OffersStepDef.i_have_submitted_a_POST_Request_via(OffersStepDef.java:87)\r\n\tat ✽.I have submitted a POST Request via uri(file:Features/Offers.feature:4)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I verify or count the number of Offers JSON Objects returned",
  "keyword": "When "
});
formatter.match({
  "location": "OffersStepDef.i_verify_count_the_of_Offers_JSON_Objects_returned()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The total number of offers objects will be five",
  "keyword": "Then "
});
formatter.match({
  "location": "OffersStepDef.the_total_number_of_offers_objects_will_be()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Verify Offer_ID for given offers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have submitted a POST Request via uri",
  "keyword": "Given "
});
formatter.match({
  "location": "OffersStepDef.i_have_submitted_a_POST_Request_via()"
});
formatter.result({
  "error_message": "org.json.JSONException: A JSONObject text must begin with \u0027{\u0027 at 1 [character 2 line 1]\r\n\tat org.json.JSONTokener.syntaxError(JSONTokener.java:505)\r\n\tat org.json.JSONObject.\u003cinit\u003e(JSONObject.java:215)\r\n\tat org.json.JSONObject.\u003cinit\u003e(JSONObject.java:399)\r\n\tat Test.OffersStepDef.i_have_submitted_a_POST_Request_via(OffersStepDef.java:87)\r\n\tat ✽.I have submitted a POST Request via uri(file:Features/Offers.feature:9)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I verify or review the offer_id from the OfferList",
  "keyword": "When "
});
formatter.match({
  "location": "OffersStepDef.i_verify_review_the_from_the_OfferList()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The Offer_ID will be valid and NOT Null",
  "keyword": "Then "
});
formatter.match({
  "location": "OffersStepDef.the_Offer_ID_will_be_valid_and_NOT_Null()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Verify Customers Email Address on given Offers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have submitted a POST Request via uri",
  "keyword": "Given "
});
formatter.match({
  "location": "OffersStepDef.i_have_submitted_a_POST_Request_via()"
});
formatter.result({
  "error_message": "org.json.JSONException: A JSONObject text must begin with \u0027{\u0027 at 1 [character 2 line 1]\r\n\tat org.json.JSONTokener.syntaxError(JSONTokener.java:505)\r\n\tat org.json.JSONObject.\u003cinit\u003e(JSONObject.java:215)\r\n\tat org.json.JSONObject.\u003cinit\u003e(JSONObject.java:399)\r\n\tat Test.OffersStepDef.i_have_submitted_a_POST_Request_via(OffersStepDef.java:87)\r\n\tat ✽.I have submitted a POST Request via uri(file:Features/Offers.feature:14)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I verify or review the emailadr from Customer Object",
  "keyword": "When "
});
formatter.match({
  "location": "OffersStepDef.i_verify_or_review_the_emailadr_from_Customer_Object()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The format of the email is Valid and NOT Null",
  "keyword": "Then "
});
formatter.match({
  "location": "OffersStepDef.the_format_of_the_email_is_Valid_and_NOT_Null()"
});
formatter.result({
  "status": "skipped"
});
});