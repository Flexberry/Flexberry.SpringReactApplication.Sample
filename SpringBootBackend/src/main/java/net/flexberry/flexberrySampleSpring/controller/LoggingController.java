package net.flexberry.flexberrySampleSpring.controller;

import net.flexberry.flexberrySampleSpring.FlexberrySampleSpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LoggingController {
    Logger logger = LogManager.getLogger(FlexberrySampleSpringApplication.class);

    @GetMapping("/log4jTest")
    public String log4jTest(@RequestParam(value = "logMessage", defaultValue = "Log4j Test!") String name) {
        String strMessage = String.format("Test Log with message %s!", name);

        logger.trace(String.format("A TRACE Message for %s!", name));
        logger.debug(String.format("A DEBUG Message for %s!", name));
        logger.info(String.format("A INFO Message for %s!", name));
        logger.warn(String.format("A WARN Message for %s!", name));
        logger.error(String.format("A ERROR Message for %s!", name));

        return strMessage;
    }

    @GetMapping("/slf4jTest")
    public String slf4jTest(@RequestParam(value = "logMessage", defaultValue = "Slf4j Test!") String name) {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FlexberrySampleSpringApplication.class);
        String strMessage = String.format("Test Log with message %s!", name);

        logger.trace(String.format("A TRACE Message for %s!", name));
        logger.debug(String.format("A DEBUG Message for %s!", name));
        logger.info(String.format("A INFO Message for %s!", name));
        logger.warn(String.format("A WARN Message for %s!", name));
        logger.error(String.format("A ERROR Message for %s!", name));

        return strMessage;
    }
}
