//: com.tecsys.itopia.shell.config.CustomPromptProvider.java

package com.tecsys.itopia.shell.config;


import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;


@Component
final class CustomPromptProvider implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        return new AttributedString("itopia > ",
                AttributedStyle.BOLD.foreground(AttributedStyle.GREEN));
    }

}///:~