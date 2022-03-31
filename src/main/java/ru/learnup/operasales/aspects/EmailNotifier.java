package ru.learnup.operasales.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmailNotifier {

    private static final String PREFIX = "(AOP)";

    @Pointcut("@annotation(ru.learnup.operasales.annotations.EmailNotified)")
    public void playBillServiceLog() {
    }

    @AfterReturning("playBillServiceLog()")
    public void afterSuccess(JoinPoint joinPoint) {
        switch (joinPoint.getSignature().getName()) {
            case ("addPremiere"):
                send(PREFIX + "Успешно добавлена премьера");
                break;
            case ("removePremiere"):
                send(PREFIX + "Успешно удалена премьера");
                break;
            case ("buyTickets"):
                send(PREFIX + "Успешно куплены билеты");
                break;
            default:
                send(PREFIX + "Успешное завершение " + joinPoint.getSignature().getName());
        }
    }

    @AfterThrowing("playBillServiceLog()")
    public void afterError(JoinPoint joinPoint) {
        switch (joinPoint.getSignature().getName()) {
            case ("addPremiere"):
                send(PREFIX + "Ошибка при добавлении премьеры");
                break;
            case ("removePremiere"):
                send(PREFIX + "Ошибка при удалении премьеры");
                break;
            case ("buyTickets"):
                send(PREFIX + "Ошибка при покупке билетов");
                break;
            default:
                send(PREFIX + "Завершение с ошибкой " + joinPoint.getSignature().getName());
        }
    }

    private void send(String message) {
        System.out.println(message);
    }

}