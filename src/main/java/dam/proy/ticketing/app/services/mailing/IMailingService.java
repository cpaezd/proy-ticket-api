package dam.proy.ticketing.app.services.mailing;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.PasswordResetToken;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.Usuario;

import java.util.List;
import java.util.Map;

public interface IMailingService
{
	void sendNewTicketMail(Ticket ticket);
	void sendAssignedTicketMail(Ticket ticket);
	void sendNewAnnotationMail(Anotacion anotacion);
	void sendResolvedTicketMail(Ticket ticket);
	void sendRecoverPasswordMail(PasswordResetToken passwordResetToken);
}
