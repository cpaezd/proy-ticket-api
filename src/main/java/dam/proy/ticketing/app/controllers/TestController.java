package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.mailing.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/test")
class TestController {

//	@Autowired
//	private MailingService mailingService;

//	@GetMapping("/")
//	public String test()
//	{
//		try
//		{
//			this.mailingService.testSending();
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//
//			return "ERR";
//		}
//
//		return "OK!";
//	}
}
