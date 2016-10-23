package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class WebController {

    private Encoder encoder = new Encoder();
    private Decoder decoder = new Decoder();

	@RequestMapping(value = "/req")
	public ModelAndView showMessage(
			@RequestParam(value = "nameOperation", required = false, defaultValue = "encode") String nameOperation, @RequestParam(value = "string", required = false, defaultValue = "123") String string) throws IOException {


        String newString = "Your string: " + string;
        if(nameOperation.equals("encode"))
        {
            newString += " Encode string: " + encoder.encode(string);
        }
        if (nameOperation.equals("decode"))
        {
            newString += " Decode string: " + decoder.decode(string);
        }

		ModelAndView mv = new ModelAndView("req");
		mv.addObject("message", newString);
		return mv;
	}
}
