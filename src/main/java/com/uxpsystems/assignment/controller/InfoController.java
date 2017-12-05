package com.uxpsystems.assignment.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class InfoController {
	@RequestMapping(value="/info", method=GET)
	public String home() {
	return "user";
	}
}
