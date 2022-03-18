package egtry.hello;


import java.io.StringReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JTest {
	
	@SuppressWarnings("static-access")
	@Test
	@DisplayName("Generate the expected HTML for a different set of expressions and validate given expressions")
	void HTMLtest() throws ParseException {
		// generation test
		// test 1
		StringReader in=new StringReader("ADD HEADING WITH TEXT \"Hello World\"");
		Hello hello = new Hello(in);	
		Assertions.assertEquals("<h1>Hello World</h1>".replaceAll("[\\n\\t ]", ""), hello.create().replaceAll("[\\n\\t ]", ""));
		// test 2
		StringReader in2=new StringReader("ADD IMAGE WITH SOURCE \"https://www.w3schools.com/html/pic_trulli.jpg\"");
		hello.ReInit(in2);
		Assertions.assertEquals("<img src=\"https://www.w3schools.com/html/pic_trulli.jpg\" />".replaceAll("[\\n\\t ]", ""), hello.create().replaceAll("[\\n\\t ]", ""));
		// test 3
		StringReader in3 =new StringReader("ADD PARAGRAPH WITH TEXT \"Welcome\" AND WITH FONT \"Arial\" AND WITH COLOR \"Red\"");
		hello.ReInit(in3);
		Assertions.assertEquals("<p style=\"color:Red;font-family:Arial;\">Welcome</p>".replaceAll("[\\n\\t ]", ""),hello.create().replaceAll("[\\n\\t ]", ""));
		// test 4
		StringReader in4=new StringReader("ADD LINK WITH TEXT \"Search\" AND WITH LINK \"http://google.com\"");
		hello.ReInit(in4);
		Assertions.assertEquals("<a href=\"http://google.com\">Search</a>".replaceAll("[\\n\\t ]", ""), hello.create().replaceAll("[\\n\\t ]", ""));
		// test 5
		StringReader in5=new StringReader("ADD LINK WITH TEXT \"Email\" AND WITH LINK \"http://gmail.com\" AND WITH COLOR \"Green\"");
		hello.ReInit(in5);
		Assertions.assertEquals("<a href=\"http://gmail.com\" style=\"color:Green;\">Email</a>".replaceAll("[\\n\\t ]", ""), hello.create().replaceAll("[\\n\\t ]", ""));
		// test 6
		StringReader in6=new StringReader("ADD PARAGRAPH WITH FONT \"Arial\" AND WITH TEXT \"Good bye\"");
		hello.ReInit(in6);
		Assertions.assertEquals("<p style=\"font-family:Arial;\">Good bye</p>".replaceAll("[\\n\\t ]", ""), hello.create().replaceAll("[\\n\\t ]", ""));
	

		/// validation test
		// test 1
		StringReader input =new StringReader("ADD IMAGE WIT SOURCE\"https://www.w3schools.com/html/pic_trulli.jpg\"");
		hello.ReInit(input);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertFalse(Hello.valid );
		// test 2
		StringReader input2=new StringReader("Image SOURCE\"https://www.w3schools.com/html/pic_trulli.jpg\"");
		hello.ReInit(input2);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertFalse(Hello.valid );
		// test 3
		StringReader input3=new StringReader("add HEADING WITH \"Hello World\"");
		hello.ReInit(input3);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertFalse(Hello.valid );
		// test 4
		StringReader input4=new StringReader("ADD HEADING WITH TEXT \"Hello World\"");
		hello.ReInit(input4);
		Hello.valid = true;;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertTrue(Hello.valid );
		// test 5
		StringReader input5=new StringReader("ADD WITH \"Hello World\"");
		hello.ReInit(input5);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertFalse(Hello.valid );
		// test 6
		StringReader input6=new StringReader("add image with source https:google.com");
		hello.ReInit(input6);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertFalse(Hello.valid );
		// test 7
		StringReader input7=new StringReader("ADD PARAGRAPH WITH TEXT \"Welcome\" AND WITH FONT \"Arial\" AND WITH COLOR \"Red\"");
		hello.ReInit(input7);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertTrue(Hello.valid );
		// test 8
		StringReader input8=new StringReader("ADD HEADING");
		hello.ReInit(input8);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertFalse(Hello.valid );
		// test 9
		StringReader input9=new StringReader("ADD LINK WITH");
		hello.ReInit(input9);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertFalse(Hello.valid );
		// test 10
		StringReader input10=new StringReader("ADD LINK WITH TEXT \"Search\" AND WITH LINK \"http://google.com\"");
		hello.ReInit(input9);
		Hello.valid = true;
		try {
			hello.create();
		} catch (ParseException e) {
			Hello.valid = false;
		}
		Assertions.assertTrue(Hello.valid );
	
	}
}

