package evaluation;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

public class RAEvaluation {
	Response response;
	JSONObject js = new JSONObject();
	@Test
	public void statusCode() {
		response = given()
				.when()
				.get("https://jsonplaceholder.typicode.com/posts/1");
		
		response.then().statusCode(200);
		response.then().body("id", equalTo(1));
	}
	
	@Test 
	public void postRequest() {
		js.put("title", "foo");
		js.put("body", "bar");
		js.put("userId", 1);
		
		given()
				.contentType(ContentType.JSON)
				.body(js.toJSONString())
		.when()
				.post("https://jsonplaceholder.typicode.com/posts")
		.then()
			.assertThat()
			.statusCode(201)
			.body("title", equalTo("foo"))
			.body("body", equalTo("bar"))
			.body("userId", equalTo(1))
			.log().all();
	}
	
	@Test
	public void testUpdatePost() {
		js.put("title", "updated titile");
		js.put("body", "updated body");
		js.put("userdId", 1);
		js.put("id", 1);
		
		given()
			.contentType(ContentType.JSON)
			.body(js.toJSONString())
		.when()
			.put("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.assertThat()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void testPartialUpdateTitle() {
		js.put("title", "partially title updated");
		
		given()
			.contentType(ContentType.JSON)
			.body(js.toJSONString())
		.when()
			.patch("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.assertThat()
			.statusCode(200)
			.body("title", equalTo("partially title updated"))
			.log().all();
	}
	
	@Test
	public void testDeletewithVerification() {
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.statusCode(200)
			.log().all();
		
		given()
		.when()
			.delete("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
