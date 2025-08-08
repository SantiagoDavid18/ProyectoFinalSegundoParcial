package api_rest.producer;

import com. fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org. springframework.stereotype.Service;
import api_rest.dto. NotificacionDto;

@Service
public class NotificacionProducer {

    @Autowired
    private static RabbitTemplate rabbitTemplate;

    @Autowired
    private static ObjectMapper objectMapper;

    public static void enviarNotificacion(String mensaje, String tipo) {
        try {
            NotificacionDto notificacionDto = new NotificacionDto(mensaje, tipo);
            String json = objectMapper.writeValueAsString(notificacionDto);
            rabbitTemplate.convertAndSend("queue.notificaciones", json);
            System.out.println("Notificacion enviada satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }