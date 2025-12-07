package dam.proy.ticketing.app.services.mailing;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MailingService implements IMailingService
{
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private IAnotacionService anotacionService;

	@Value("${spring.mail.username}")
	private String emailFrom;

	private final String NEW_TICKET_SUBJECT = "New Ticket";
	private final String NEW_TICKET_ASSIGNED_SUBJECT = "New Ticket Assigned";
	private final String NEW_ANNOTATION_SUBJECT = "New Annotation";
	private final String RESOLVED_TICKET_SUBJECT = "Resolved Ticket";
	private final String CLOSED_TICKET_SUBJECT = "Resolved Annotation";

	private final String NEW_TICKET_TEMPLATE = "tickets/nuevoTicket.html";
	private final String NEW_TICKET_ASSIGNED_TEMPLATE = "tickets/asignadoTicket.html";
	private final String NEW_ANNOTATION_TEMPLATE = "tickets/anotacionTicket.html";
	private final String RESOLVED_TICKET_TEMPLATE = "tickets/ResueltoTicket.html";
	private final String CLOSED_TICKET_TEMPLATE = "tickets/cierreTicket.html";

	private final String[] testEmailsTo = {
	};


	private void sendMail(String subject, List<String> emailsTo, Map<String, Object> data, String template)
	{
		MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		MimeMessageHelper helper;

		Context context = new Context();
		context.setVariables(data);

		String html = this.templateEngine.process(template, context);

		String[] to = emailsTo.toArray(new String[0]);

		try {
			helper = new MimeMessageHelper(mimeMessage, true);

			helper.setFrom(emailFrom);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(html, true);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		this.mailSender.send(mimeMessage);
	}

//	@Async
//	public void testSending() throws MessagingException
//	{
//		String html = this.templateEngine.process("test/test.html", new Context());
//
//		MimeMessage mimeMessage = this.mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//
//		helper.setFrom(emailFrom);
//		helper.setTo(testEmailsTo);
//		helper.setSubject("Testing Email");
//		helper.setText(html, true);
//
//		this.mailSender.send(mimeMessage);
//	}

	@Override
	@Async
	public void sendNewTicketMail(Ticket ticket)
	{
		this.sendMail(
			NEW_TICKET_SUBJECT,
			List.of(ticket.getSolicitante().getUsuario().getEmail()),
			Map.of("ticket", ticket),
			NEW_TICKET_TEMPLATE
		);
	}

	@Override
	@Async
	public void sendAssignedTicketMail(Ticket ticket)
	{
		Grupo g = ticket.getGrupo();
		List<String> agentes = g.getAgentes()
		.stream()
		.map(a -> a.getUsuario().getEmail())
		.toList();

		this.sendMail(
			NEW_TICKET_ASSIGNED_SUBJECT,
			agentes,
			Map.of("ticket", ticket),
			NEW_TICKET_ASSIGNED_TEMPLATE
		);
	}

	@Override
	@Async
	public void sendNewAnnotationMail(Anotacion anotacion)
	{
		List<String> emailsTo = new ArrayList<>();

		if(anotacion.getVisibilidadTicket() == 0)  {
			emailsTo = anotacion
					.getTicket()
					.getGrupo()
					.getAgentes().stream().map(a -> a.getUsuario().getEmail())
					.toList();
		}

		if(anotacion.getVisibilidadTicket() == 1)  {
			emailsTo = List.of(anotacion.getTicket().getSolicitante().getUsuario().getEmail());
		}

		this.sendMail(
			NEW_ANNOTATION_SUBJECT,
			emailsTo,
			Map.of("anotacion", anotacion),
			NEW_ANNOTATION_TEMPLATE
		);
	}

	@Override
	@Async
	public void sendResolvedTicketMail(Ticket ticket)
	{
		this.sendMail(
			RESOLVED_TICKET_SUBJECT,
			List.of(ticket.getSolicitante().getUsuario().getEmail()),
			Map.of("ticket", ticket),
			RESOLVED_TICKET_TEMPLATE
		);
	}
}
