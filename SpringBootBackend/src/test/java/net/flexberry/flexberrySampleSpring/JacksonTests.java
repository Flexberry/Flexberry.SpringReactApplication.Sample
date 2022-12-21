package net.flexberry.flexberrySampleSpring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.flexberry.flexberrySampleSpring.model.Comment;
import net.flexberry.flexberrySampleSpring.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


/**
 * Тесты сериализатора Jackson.
 */
@SpringBootTest
class JacksonTests {

	/**
	 * Проверяет что циклические ссылки моделей не вызовут переполнение стека.
	 * @throws JsonProcessingException Исключение при сериализации в JSON.
	 */
	@Test
	public void bidirectionalCircularRelationThrowNoStackOverflow() throws JsonProcessingException {
		final Customer customer = new Customer();
		customer.setPrimarykey(100);
		customer.setAge(30);
		customer.setName("Jack");

		final Comment comment1 = new Comment();
		comment1.setPrimarykey(101);
		comment1.setCommentText("TestText5");
		comment1.setCustomer(customer);

		final Comment comment2 = new Comment();
		comment2.setPrimarykey(102);
		comment2.setCommentText("TestText6");
		comment2.setCustomer(customer);

		customer.setComments(Arrays.asList(comment1, comment2));

		final String comment1Json = new ObjectMapper().writeValueAsString(comment1);
		final String comment2Json = new ObjectMapper().writeValueAsString(comment2);
		final String customerJson = new ObjectMapper().writeValueAsString(customer);

		assertThat(comment1Json, containsString("101"));
		assertThat(comment1Json, containsString("TestText5"));
		assertThat(comment1Json, containsString("customer"));
		assertThat(comment1Json, containsString("100"));
		assertThat(comment1Json, containsString("Jack"));

		assertThat(comment2Json, containsString("102"));
		assertThat(comment2Json, containsString("TestText6"));
		assertThat(comment2Json, containsString("customer"));
		assertThat(comment2Json, containsString("100"));
		assertThat(comment2Json, containsString("Jack"));

		assertThat(customerJson, containsString("100"));
		assertThat(customerJson, containsString("Jack"));
		assertThat(customerJson, containsString("comments"));
		assertThat(customerJson, containsString("101"));
		assertThat(customerJson, containsString("102"));
	}
}
