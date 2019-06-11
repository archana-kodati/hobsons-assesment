package com.hobson.assesment.steps;

import org.openqa.selenium.WebDriver;

public class BaseStepDef {
    public WebDriver driver;
    public BaseStepDef(){
        driver = Hooks.driver;
    }


}
