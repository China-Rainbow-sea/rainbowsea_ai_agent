package com.rainbowsea.rainbowsea_image_search_mcp_server;

import com.rainbowsea.rainbowsea_image_search_mcp_server.tools.ImageSearchTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RainbowseaMageSearchMcpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RainbowseaMageSearchMcpServerApplication.class, args);
    }


    @Bean
    public ToolCallbackProvider imageSearchTools(ImageSearchTool imageSearchTool) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(imageSearchTool)
                .build();
    }
}
