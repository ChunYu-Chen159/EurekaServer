package EurekaServer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EurekaServerController {
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String index() 
    {
		return "success";
    }
}
