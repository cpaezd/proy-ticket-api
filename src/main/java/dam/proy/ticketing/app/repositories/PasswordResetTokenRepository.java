package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long>
{
	PasswordResetToken findByToken(String token);
}
