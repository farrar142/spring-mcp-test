package link.honeycombpizza.mcp;


import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiConfig {
    @Autowired
    private SyncMcpToolCallbackProvider toolCallbackProvider;

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder
                .defaultToolCallbacks(toolCallbackProvider.getToolCallbacks())
                .build();
    }

    @Bean
    public ChatClient poolClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder
                .build();
    }

}
