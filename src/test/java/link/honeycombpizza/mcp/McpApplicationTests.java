package link.honeycombpizza.mcp;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.stream.Stream;

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

	@Test
	void testMcpClient(){
		String content = chatClient.prompt("네가 사용 가능한 tool 목록을 알려줘?").call().content();
		assertThat(content)
				.contains("spring_ai_mcp_client_filesystem_read_file");
	}

}
