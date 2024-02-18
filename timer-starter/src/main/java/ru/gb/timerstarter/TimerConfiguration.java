package ru.gb.timerstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "timer.enabled", havingValue = "true")
public class TimerConfiguration {

    @Bean
    TimerAspect timerAspect() {
        return new TimerAspect();
    }

}
