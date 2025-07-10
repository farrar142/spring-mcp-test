package link.honeycombpizza.mcp;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class McpApplicationTests {
	@Autowired
	private ChatClient chatClient;

	@Test
	void testChatClient(){
		String content = chatClient.prompt().user("2+2=?").call().content();
		assertThat(content)
				.contains("4");
	}

}
