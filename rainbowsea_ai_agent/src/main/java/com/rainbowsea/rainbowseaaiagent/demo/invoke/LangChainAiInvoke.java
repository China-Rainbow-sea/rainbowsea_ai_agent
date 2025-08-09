package com.rainbowsea.rainbowseaaiagent.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
/**
 * LangChain4j 整合连接 大模型
 */
public class LangChainAiInvoke {

    public static void main(String[] args) {
        // 构建大模型（通过我们在 application.yaml 当中配置的大模型，自动注入(是在只有一个大模型的配置的时候
        // 可以被默认读取到，当有两个大模型的配置的时候，就需要特别指明使用的是那个大模型，需要注入的是那个大模型了
        // 不然，存在歧义是无法自动注入的)）
        ChatLanguageModel qwenModel = QwenChatModel.builder()
                //.apiKey(TestApiKey.API_KEY)
                .apiKey(System.getenv("aliQwen_api"))  // 获取你配置在系统环境变量当中的key值
                .modelName("qwen-max")
                .build();
        String answer = qwenModel.chat("我是程序员李华，你是谁");
        System.out.println(answer);
    }
}