package com.rainbowsea.rainbowseaaiagent.demo.invoke;



import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.ai.chat.model.ChatModel;

/**
 * Spring AI 框架调用 AI 大模型（阿里）
 */
// 取消注释即可在 SpringBoot 项目启动时执行
@Component  // 启动项目会自动注入
public class SpringAiAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel dashscopeChatModel;  // 通过我们在 application.yaml 当中配置的大模型信息，自动注入到IOC 容器

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = dashscopeChatModel.call(new Prompt("你好，我是李华"))
                .getResult()
                .getOutput();
        System.out.println(output.getText());
    }
}