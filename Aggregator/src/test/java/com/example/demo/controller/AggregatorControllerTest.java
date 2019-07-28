/*
 * package com.example.demo.controller;
 * 
 * import java.util.Date;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.Mockito; import org.skyscreamer.jsonassert.JSONAssert; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.RequestBuilder; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 * 
 * import com.example.demo.entity.Product; import
 * com.example.demo.services.ProductService;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @WebMvcTest(value = AggregatorController.class, secure = false) public class
 * AggregatorControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private ProductService productService;
 * 
 * Product mockProduct = new
 * Product(2000,"fccc13f1-f337-480b-9305-xxxxxxxxxxx","Samsung S9 Plus"
 * ,"smart phone","Samsung Galaxy","TRUE","PC",new Date(),new Date()); String
 * exampleProductJson =
 * "{\"id\": 2000,\"name\": \"Samsung S9 Plus\",\"description\": \"smart phone\",\"provider\": \"Samsung Galaxy\",\"available\": \"TRUE\",\"lastModifiedDate\": \"2019-07-26T18:30:00.000+0000\",\"messuermentUnit\": \"PC\",\"uuid\": \"fccc13f1-f337-480b-9305-xxxxxxxxxxx\",\"createdDate\": \"2019-07-26T18:30:00.000+0000\"}"
 * ;
 * 
 * @Test public void greetingShouldReturnMessageFromService() throws Exception {
 * 
 * 
 * Mockito.when(
 * productService.updateProductWithID(mockProduct,2000)).thenReturn(mockProduct)
 * ;
 * 
 * RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
 * "/updateProduct/2000").accept( MediaType.APPLICATION_JSON);
 * 
 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
 * 
 * System.out.println(result.getResponse()); String expected
 * ="{id:Course1,name:Spring,description:10 Steps}";
 * 
 * 
 * JSONAssert.assertEquals(expected, result.getResponse() .getContentAsString(),
 * false);
 * 
 * 
 * }
 * 
 * }
 */