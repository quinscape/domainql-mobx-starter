package de.quinscape.dqlmobx.runtime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsEntryPointController
{
    @RequestMapping("/main/**")
    public String serveGame()
    {
        return "main";
    }

    @RequestMapping("/login")
    public String serveLogin()
    {
        return "login";
    }
}
